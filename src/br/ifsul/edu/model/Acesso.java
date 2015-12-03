/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "acesso")
public class Acesso implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acesso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_acesso",nullable = false)
    private Calendar data_acesso;
    
    @NotNull(message = "O usuario não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    public Acesso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(Calendar data_acesso) {
        this.data_acesso = data_acesso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Acesso other = (Acesso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
