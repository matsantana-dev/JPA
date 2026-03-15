/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author matheus
 */
@Entity
@Table(name = "pet")
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findByCodigo", query = "SELECT p FROM Pet p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pet.findByNome", query = "SELECT p FROM Pet p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pet.findByPeso", query = "SELECT p FROM Pet p WHERE p.peso = :peso")})
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @JoinColumn(name = "codhumano", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Humano codhumano;

    public Pet() {
    }

    public Pet(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Humano getCodhumano() {
        return codhumano;
    }

    public void setCodhumano(Humano codhumano) {
        this.codhumano = codhumano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pet[ codigo=" + codigo + " ]";
    }
    
}
