/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Giovani Trevisol
 */
public class Categoria implements Serializable{

    private Integer id;
    private String nome;

    //construtor vazio
    public Categoria() {

    }

    //construtor com atributos
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return true;
    }
    
            

}
