package com.mycompany.projetosenac.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cadastropet")
public class CadastroPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apelido;
    private String sexo;
    private String raca;
    private String porte;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    
    // Construtor padrão
    public CadastroPet() {
    }
    
    // Construtor com todos os campos
    public CadastroPet(String nome, String sexo, String raca, String porte) {
        this.apelido = nome;
        this.sexo = sexo;
        this.raca = raca;
        this.porte = porte;
    }

    // Getters e setters
    public String getNome() {
        return apelido;
    }

    public void setNome(String nome) {
        this.apelido = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

}
