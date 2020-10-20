package io.github.juliofreitas77.bancodigital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.juliofreitas77.bancodigital.domain.Proposta;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

public class PropostaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyy")
    private Date last_update;

    @Max(value = 2)
    @Min(value = 1)
    private int propostaAceite;

    public PropostaDTO() {
    }

    public PropostaDTO(Proposta obj) {
        this.id = obj.getId();
        this.last_update = new Date();
        this.propostaAceite = propostaAceite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public int getPropostaAceite() {
        return propostaAceite;
    }

    public void setPropostaAceite(int propostaAceite) {
        this.propostaAceite = propostaAceite;
    }
}
