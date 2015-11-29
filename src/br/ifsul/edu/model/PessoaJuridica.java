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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "pessoa_juridica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaJuridica extends Pessoa implements Serializable{
    
    @NotNull(message = "O nome fantasia não pode ser nulo")
    @NotBlank(message = "O nome fantasia não pode ser vazio")
    @Length(max = 50, message = "O nome fantasia não pode ter mais que {max} caracteres")
    @Column(name = "nome_fantasia", length = 50, nullable = false)
    private String nome_fantasia;
    
    @NotNull(message = "O CNPJ não pode ser nulo")
    @NotBlank(message = "O CNPJ não pode ser vazio")
    @Length(max = 18, message = "O CNPJ não pode ter mais que {max} caracteres")
    @Column(name = "cnpj",length = 18, nullable = false)    
    private String cnpj;
   
    @NotNull(message = "O IE não pode ser nulo")
    @NotBlank(message = "O IE não pode ser vazio")
    @Length(max = 20, message = "O IE não pode ter mais que {max} caracteres")
    @Column(name = "ie",length = 20, nullable = false)      
    private String ie;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao",nullable = false)
    private Calendar data_fundacao;

    public PessoaJuridica() {
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public Calendar getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(Calendar data_fundacao) {
        this.data_fundacao = data_fundacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome_fantasia);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.nome_fantasia, other.nome_fantasia)) {
            return false;
        }
        return true;
    }
    
       
    
}
