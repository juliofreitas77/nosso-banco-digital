package io.github.juliofreitas77.bancodigital.dto;

import io.github.juliofreitas77.bancodigital.domain.Cliente;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String sobreNome;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotEmpty(message = "Campo cpf não pode ser nulo")
    @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-?\\d{2}", message = "Cpf inválido")
    private String cpf;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj){
        this.id = obj.getId();
        this.name = obj.getNome();
        this.sobreNome = obj.getSobreNome();
        this.email = obj.getEmail();
        this.dataNascimento = obj.getDataNascimento();
        this.cpf = obj.getCpf();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
