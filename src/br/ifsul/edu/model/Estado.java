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
@Table(name = "estado")
public class Estado implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_estado",sequenceName = "seq_estado_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_estado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome do estado não pode ser nulo")
    @NotBlank(message = "O nome do estado não pode ser vazio")
    @Length(max = 50,message = "O nome do estado não pode ter mais de {max} caracteres")
    @Column(name = "nome",length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "A UF não pode ser nula")
    @NotBlank(message = "A UF não pode ser vazia")
    @Length(max = 2, min = 2,message = "A UF tem que ter {max} caracteres")    
    @Column(name = "uf",length = 2, nullable = false)
    private String uf;

    public Estado() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
