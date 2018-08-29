package com.example.eventosapp_pou.model;

import com.sun.tools.javac.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import sun.jvm.hotspot.memory.Generation;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;

@Document
public class Evento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String codigo;

    @javax.validation.constraints.NotEmpty
    private String nome;
    @javax.validation.constraints.NotEmpty
    private String local;
    @javax.validation.constraints.NotEmpty
    private String data;
    @javax.validation.constraints.NotEmpty
    private String horario;

    @DBRef
    private ArrayList<Convidado> convidados = new ArrayList<Convidado>();


    public  Evento(String nome, String local, String data, String horario){
        this.nome = nome;
        this.local =local;
        this.data = data;
        this.horario = horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public  String toString(){
        return String.format(
                "Evento[nome='%s', local='%s', data=%s, horario=%s]", nome, local, data, horario);
    }

    public ArrayList<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<Convidado> convidados) {
        this.convidados = convidados;
    }

    public void addConvidado(Convidado convidado){
        this.convidados.add(convidado);
    }
}
