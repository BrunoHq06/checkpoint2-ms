package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;

public interface EditarPedidoUseCase {

    PedidoOutputDTO execute(PedidoInputDTO pedidoInputDTO, Long id);
}
