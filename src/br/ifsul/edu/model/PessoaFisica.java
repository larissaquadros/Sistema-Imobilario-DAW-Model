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
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica extends Pessoa implements Serializable{
    
    @NotNull(message = "O RG não pode ser nulo")
    @NotBlank(message = "O RG não pode ser vazio")
    @Length(max = 10, message = "O RG não pode ter mais que {max} caracteres")
    @Column(name = "rg",length = 10, nullable = false)    
    private String rg;
    
    @CPF(message = "O CPF deve ser valido")
    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não pode ser vazio")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "cpf",length = 14, nullable = false)      
    private String cpf;
    
    @Length(max = 20, message = "O Passaporte não pode ter mais que {max} caracteres")
    @Column(name = "passaporte", length = 20, nullable = false)    
    private String passaporte;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento",nullable = false)
    private Calendar nascimento;

    public PessoaFisica() {
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.rg);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }
    
    
    
}
