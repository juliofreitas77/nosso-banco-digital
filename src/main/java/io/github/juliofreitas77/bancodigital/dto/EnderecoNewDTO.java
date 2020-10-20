package io.github.juliofreitas77.bancodigital.dto;

import io.github.juliofreitas77.bancodigital.domain.Endereco;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class EnderecoNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo obrigatório e deve estar no formato padrão XXXXX-XXX")
    @Pattern(regexp = "^(\\d{0,5}|\\d{5}\\-\\d{0,3})$")
    private String cep;
    @NotEmpty
    private String rua;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String complemento;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;
    @NotNull(message = "idCliente não pode ser um campo nulo")
    private Integer idCliente;

    public EnderecoNewDTO() {
    }
    public EnderecoNewDTO(Endereco obj){
        this.idCliente = obj.getCliente().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
