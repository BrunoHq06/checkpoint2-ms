package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPedidoUseCaseImpl implements ListarPedidoUseCase {

    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoOutputDTO> execute() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos
                .stream()
                .map(product -> pedidoMapper.toPedidoOutpuDTO(product))
                .collect(Collectors.toList());
    }
}
