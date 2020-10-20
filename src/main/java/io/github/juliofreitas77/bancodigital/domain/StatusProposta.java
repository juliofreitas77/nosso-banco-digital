package io.github.juliofreitas77.bancodigital.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.juliofreitas77.bancodigital.enums.StatusPropostaEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class StatusProposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer status;
//
//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "proposta_id")
//    @MapsId
//    private Proposta proposta;

    public StatusProposta() {
    }

    public StatusProposta(Integer id, StatusPropostaEnum propostaEnum, Proposta proposta) {
        this.id = id;
//      this.status = (propostaEnum == null) ? null : propostaEnum.getCodigo();
//        this.proposta = proposta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public StatusPropostaEnum getStatus() {
//        return StatusPropostaEnum.toEnum(status);
//    }

//    public void setStatus(StatusPropostaEnum spe) {
//        this.status = spe.getCodigo();
//    }

//    public Proposta getProposta() {
//        return proposta;
//    }
//
//    public void setProposta(Proposta proposta) {
//        this.proposta = proposta;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusProposta that = (StatusProposta) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
