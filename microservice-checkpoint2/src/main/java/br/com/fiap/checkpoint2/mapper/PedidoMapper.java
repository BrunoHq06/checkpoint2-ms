package br.com.fiap.checkpoint2.mapper;

import br.com.fiap.checkpoint2.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.PedidoBuilder;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public Pedido toPedido(PedidoInputDTO dto) {
        return new PedidoBuilder()
                .dataPedido(dto.getDataPedido())
                .codigoCliente(dto.getCodigoCliente())
                .dataCadastro(dto.getDataCadastro())
                .valorTotal(dto.getValorTotal())
                .build();
    }
    public PedidoOutputDTO toPedidoOutpuDTO(Pedido pedido) {
        return new PedidoOutputDTO(pedido);
    }

}
