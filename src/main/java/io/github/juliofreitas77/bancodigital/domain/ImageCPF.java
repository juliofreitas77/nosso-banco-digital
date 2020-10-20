package io.github.juliofreitas77.bancodigital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class ImageCPF implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "imagem", columnDefinition = "mediumblob")
    @NotNull
    private byte[] imagem;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idCliente",unique = true)
    private Cliente cliente;

    @JsonIgnore
    @OneToOne(mappedBy = "imageCPF")
    private Proposta proposta;

    public ImageCPF(Integer id, byte[] imagem, Cliente cliente, Proposta proposta) {
        this.id = id;
        this.imagem = imagem;
        this.cliente = cliente;
        this.proposta = proposta;
    }

    public ImageCPF() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }
}
