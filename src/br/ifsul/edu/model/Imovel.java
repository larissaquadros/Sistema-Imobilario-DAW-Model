/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "imovel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Imovel implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_imovel", sequenceName = "seq_imovel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_imovel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O endereço não pode ser nulo")
    @NotBlank(message = "O endereço não pode ser vazio")
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode ser vazio")
    @Length(max = 50, message = "O bairro não pode ter mais que {max} caracteres")
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;
    
    @NotNull(message = "O complemento não pode ser nulo")
    @NotBlank(message = "O complemento não pode ser vazio")
    @Length(max = 30, message = "O complemento não pode ter mais que {max} caracteres")
    @Column(name = "complemento", length = 30, nullable = false)
    private String complemento;
    
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;
    
    @NotNull(message = "O preço deve ser informado")
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
    private Double preco;
    
    @NotNull(message = "A operação deve ser informada")
    @Column(name = "operacao", length = 10, nullable = false)
    private String operacao;
    
    @NotNull(message = "O tipo de imóvel deve ser informado")
    @Column(name = "tipo_imovel", length = 20, nullable = false)
    private String tipo_imovel;
    
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = true)
    private Condominio condominio;
    
    @NotNull(message = "O proprietário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = true)
    private Pessoa proprietario;
    
    @ManyToMany
    @JoinTable(name = "caracteristicas",
            joinColumns = 
            @JoinColumn(name = "imovel", referencedColumnName = "id"), 
            inverseJoinColumns = 
            @JoinColumn(name = "caracteristica", referencedColumnName = "id"))    
    private List<Caracteristica> caracteristicas = new ArrayList<>();

    public Imovel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Imovel other = (Imovel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTipo_imovel() {
        return tipo_imovel;
    }

    public void setTipo_imovel(String tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    
    
}
