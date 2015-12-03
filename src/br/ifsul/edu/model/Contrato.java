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
@Table(name = "contrato")
public class Contrato implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_contrato", sequenceName = "seq_contrato_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_contrato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio",nullable = false)
    private Calendar data_inicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_encerramento",nullable = true)
    private Calendar data_encerramento;
    
    @NotNull(message = "O locatário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa locatario;
    
    @ManyToOne
    @JoinColumn(name = "indice", referencedColumnName = "id", nullable = false)
    private Indice indice;
    
    @NotNull(message = "O imóvel deve ser informado")
    @ManyToOne
    @JoinColumn(name = "imovel", referencedColumnName = "id", nullable = false)
    private Imovel imovel;
    
    @NotNull(message = "O valor do aluguel deve ser informado")
    @Column(name = "valor_aluguel", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor_aluguel;
    
    @Column(name = "observacao", nullable = false, columnDefinition = "text")
    private String observacao;

    public Contrato() {
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
        final Contrato other = (Contrato) obj;
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

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Calendar getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Calendar data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    public Pessoa getLocatario() {
        return locatario;
    }

    public void setLocatario(Pessoa locatario) {
        this.locatario = locatario;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Double getValor_aluguel() {
        return valor_aluguel;
    }

    public void setValor_aluguel(Double valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
