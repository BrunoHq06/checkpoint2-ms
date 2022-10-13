package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.PedidoInputDTO;
import br.com.fiap.checkpoint2.dto.PedidoOutputDTO;
import br.com.fiap.checkpoint2.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private CriarPedidoUseCase criarPedidoUseCase;
    @Autowired
    private ListarPedidoUseCase listarPedidoUseCase;
    @Autowired
    private DeletarPedidoUseCase deletePedidoUseCase;
    @Autowired
    private GetPedidoPorIdUseCase getPedidoPorIdUseCase;
    @Autowired
    private EditarPedidoUseCase editarPedidoUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoOutputDTO> createPedido(@RequestBody @Valid PedidoInputDTO pedidoInputDTO){
        PedidoOutputDTO pedidoOutputDTO = criarPedidoUseCase.execute(pedidoInputDTO);
        return new ResponseEntity<>(pedidoOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoOutputDTO>> listPedidos() {
        List<PedidoOutputDTO> pedidos = listarPedidoUseCase.execute();
        if (pedidos == null || pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoOutputDTO> searchPedidoById(@PathVariable Long id) {
        PedidoOutputDTO pedido = getPedidoPorIdUseCase.execute(id);
        if (pedido == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoOutputDTO> editPedido(@RequestBody @Valid PedidoInputDTO pedidoInputDTO, @PathVariable Long id) {
        PedidoOutputDTO pedidoOutputDTO = editarPedidoUseCase.execute(pedidoInputDTO, id);
        return new ResponseEntity<>(pedidoOutputDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removePedido(@PathVariable Long id) {
        deletePedidoUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
