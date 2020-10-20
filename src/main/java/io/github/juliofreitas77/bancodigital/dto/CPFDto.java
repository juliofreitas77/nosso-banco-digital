package io.github.juliofreitas77.bancodigital.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CPFDto implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotEmpty(message = "Arquivo obrigatório")
    private byte[] imagcpf;

    @NotEmpty(message = "idCliente é obrigatório")
    private Integer idCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagcpf() {
        return imagcpf;
    }

    public void setImagcpf(byte[] imagcpf) {
        this.imagcpf = imagcpf;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
