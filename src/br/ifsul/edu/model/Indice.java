/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "indice")
public class Indice implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_indice", sequenceName = "seq_indice_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_indice", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome do índice deve ser informado")
    @NotBlank(message = "O nome do índice deve ser informado")
    @Length(max = 15, message = "O nome do índice não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 15, nullable = false)
    private String nome;

    public Indice() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Indice other = (Indice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
    
}
