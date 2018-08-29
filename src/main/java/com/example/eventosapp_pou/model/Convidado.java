package com.example.eventosapp_pou.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.hibernate.validator.constraints.NotEmpty;

public class Convidado {

    @Id
    private String codigo;

    @javax.validation.constraints.NotEmpty
    private String rg;
    @javax.validation.constraints.NotEmpty
    private  String nomeConvidado;

    @DBRef
    private Evento evento;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
