package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoUseCaseImpl implements CriarPedidoUseCase {

    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO) {

        Pedido pedido = pedidoMapper.toPedido(pedidoInputDTO);
        pedidoRepository.save(pedido);
        return new PedidoOutputDTO(pedido);
    }
}
