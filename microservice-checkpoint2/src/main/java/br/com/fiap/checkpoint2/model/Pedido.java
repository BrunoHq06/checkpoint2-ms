package br.com.fiap.checkpoint2.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant dataPedido;

    @Column(nullable = false)
    private Long codigoCliente;

    @Column(nullable = false)
    private Instant dataCadastro;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    public Pedido() {
    }

    public Pedido(Long id, Instant dataPedido, Long codigoCliente, Instant dataCadastro, BigDecimal valorTotal) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.codigoCliente = codigoCliente;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
