/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "categoria_establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaEstablecimiento.findAll", query = "SELECT c FROM CategoriaEstablecimiento c")
    , @NamedQuery(name = "CategoriaEstablecimiento.findByIdCe", query = "SELECT c FROM CategoriaEstablecimiento c WHERE c.idCe = :idCe")})
public class CategoriaEstablecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ce")
    private Integer idCe;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne
    private Establecimiento idEstablecimiento;

    public CategoriaEstablecimiento() {
    }

    public CategoriaEstablecimiento(Integer idCe) {
        this.idCe = idCe;
    }

    public Integer getIdCe() {
        return idCe;
    }

    public void setIdCe(Integer idCe) {
        this.idCe = idCe;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCe != null ? idCe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaEstablecimiento)) {
            return false;
        }
        CategoriaEstablecimiento other = (CategoriaEstablecimiento) object;
        if ((this.idCe == null && other.idCe != null) || (this.idCe != null && !this.idCe.equals(other.idCe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.CategoriaEstablecimiento[ idCe=" + idCe + " ]";
    }
    
}
