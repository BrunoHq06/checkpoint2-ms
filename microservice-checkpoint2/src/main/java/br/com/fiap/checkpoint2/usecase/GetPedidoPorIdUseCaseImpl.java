package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPedidoPorIdUseCaseImpl implements GetPedidoPorIdUseCase {

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoOutputDTO execute(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()) return null;

        PedidoOutputDTO pedidoOutputDTO = pedidoMapper.toPedidoOutpuDTO(pedido.get());
        return pedidoOutputDTO;
    }
}
