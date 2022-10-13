package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditarPedidoUseCaseImpl implements EditarPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO, Long id) {
        Pedido pedido = edit(pedidoRepository, id, pedidoInputDTO);
        return new PedidoOutputDTO(pedido);
    }

    public Pedido edit(PedidoRepository pedidoRepository, Long id, PedidoInputDTO pedidoInputDTO) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()) return null;

        pedido.get().setDataPedido(pedidoInputDTO.getDataPedido());
        pedido.get().setCodigoCliente(pedidoInputDTO.getCodigoCliente());
        pedido.get().setDataCadastro(pedidoInputDTO.getDataCadastro());
        pedido.get().setValorTotal(pedidoInputDTO.getValorTotal());
        pedidoRepository.save(pedido.get());
        return pedido.get();
    }
}
