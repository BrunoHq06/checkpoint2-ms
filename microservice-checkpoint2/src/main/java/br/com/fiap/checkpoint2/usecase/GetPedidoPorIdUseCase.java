package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;

public interface GetPedidoPorIdUseCase {

    PedidoOutputDTO execute(Long id);
}
