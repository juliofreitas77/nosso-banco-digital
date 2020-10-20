package io.github.juliofreitas77.bancodigital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String sobreNome;
    @Column(unique = true)
    private String email;
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String cpf;

    @OneToOne(mappedBy = "cliente")
    private ImageCPF imageCPF;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "cliente")
    private Proposta proposta;

    public Cliente() {
    }

    public Cliente(String name, String sobreNome, String email, LocalDate dataNascimento, String cpf) {
        this.nome = name;
        this.sobreNome = sobreNome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Cliente(String name, String sobreNome, String email, LocalDate dataNascimento, String cpf, List enderecos, Proposta proposta) {
        this.nome = name;
        this.sobreNome = sobreNome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.enderecos = enderecos;
        this.proposta = proposta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id) &&
                cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
