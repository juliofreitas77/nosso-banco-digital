package io.github.juliofreitas77.bancodigital.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.juliofreitas77.bancodigital.enums.StatusPropostaEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Proposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_image_cpf")
    private ImageCPF imageCPF;

    @Column(name = "codigo_proposta")
    @JsonProperty("proposta_status")
    private StatusPropostaEnum propostaEnum;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date last_update;

    public Proposta() {
    }

    public Proposta(Integer id, Date instante, Cliente cliente, ImageCPF imageCPF, Endereco endereco, StatusPropostaEnum propostaEnum) {
        this.id = id;
        this.last_update = instante;
        this.cliente = cliente;
        this.imageCPF = imageCPF;
        this.endereco = endereco;
        this.propostaEnum = propostaEnum.ABERTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusPropostaEnum getPropostaEnum() {
        return propostaEnum;
    }

    public void setPropostaEnum(StatusPropostaEnum propostaEnum) {
        this.propostaEnum = propostaEnum;
    }

    public ImageCPF getImageCPF() {
        return imageCPF;
    }

    public void setImageCPF(ImageCPF imageCPF) {
        this.imageCPF = imageCPF;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date instante) {
        this.last_update = instante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return getId().equals(proposta.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", cliente=" + cliente +
//                ", endereco=" + endereco +
                ", imageCPF=" + imageCPF +
//                ", statusProposta=" + statusProposta +
                '}';
    }
}
