package com.mycompany.projetosenac.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "servicos")
public class TiposServicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String tutorRes;
    private String horario;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public TiposServicos(int id, String tipo, String tutorRes, String horario) {
        this.id = id;
        this.tipo = tipo;
        this.tutorRes = tutorRes;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public String gettipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }

    public String gettutorRes() {
        return tutorRes;
    }

    public void setTutorRes(String tutorRes) {
        this.tutorRes = tutorRes;
    }

    public String gethorario() {
        return horario;
    }

    public void sethorario(String Horario) {
        this.horario = Horario;
    }

    public TiposServicos(String tipo, String tutorRes, String horario) {
        this.tipo = tipo;
        this.tutorRes = tutorRes;
        this.horario = horario;
    }

    public TiposServicos() {
    }
}
