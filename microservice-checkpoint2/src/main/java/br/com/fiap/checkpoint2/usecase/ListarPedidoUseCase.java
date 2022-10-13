package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;

import java.util.List;

public interface ListarPedidoUseCase {
    List<PedidoOutputDTO> execute();
}
