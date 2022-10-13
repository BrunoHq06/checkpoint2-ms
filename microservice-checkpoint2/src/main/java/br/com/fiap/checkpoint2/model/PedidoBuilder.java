package br.com.fiap.checkpoint2.model;

import java.math.BigDecimal;
import java.time.Instant;

public class PedidoBuilder {
    private Long id;
    private Instant dataPedido;
    private Long codigoCliente;
    private Instant dataCadastro;
    private BigDecimal valorTotal;

    public PedidoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder dataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public PedidoBuilder codigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
        return this;
    }

    public PedidoBuilder dataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public PedidoBuilder valorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Pedido build() {
        if (dataPedido == null || codigoCliente == null || dataCadastro == null || valorTotal == null) {
            throw new IllegalArgumentException("Dados do pedido incompletos");
        }
        Pedido pedido = new Pedido(id,
                dataPedido,
                codigoCliente,
                dataCadastro,
                valorTotal);
        return pedido;
    }

}
