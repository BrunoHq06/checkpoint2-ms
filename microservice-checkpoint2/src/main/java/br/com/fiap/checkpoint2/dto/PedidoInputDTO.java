package br.com.fiap.checkpoint2.dto;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.PedidoBuilder;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;


public class PedidoInputDTO {

    @NotNull
    private Instant dataPedido;

    @NotNull
    @Size(min = 3, max = 5, message = "O código do cliente deve ter entre 3 e 5 dígitos.")
    private Long codigoCliente;

    @NotNull
    private Instant dataCadastro;

    @NotNull
    private BigDecimal valorTotal;

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
