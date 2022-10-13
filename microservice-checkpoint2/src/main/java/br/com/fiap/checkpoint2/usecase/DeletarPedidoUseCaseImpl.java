package br.com.fiap.checkpoint2.usecase;

import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarPedidoUseCaseImpl implements DeletarPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void execute(Long id) {
        pedidoRepository.deleteById(id);
    }
}
