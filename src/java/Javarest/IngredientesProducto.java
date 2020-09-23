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
@Table(name = "ingredientes_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngredientesProducto.findAll", query = "SELECT i FROM IngredientesProducto i")
    , @NamedQuery(name = "IngredientesProducto.findByIdIp", query = "SELECT i FROM IngredientesProducto i WHERE i.idIp = :idIp")})
public class IngredientesProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ip")
    private Integer idIp;
    @JoinColumn(name = "id_ingredientes", referencedColumnName = "id_ingredientes")
    @ManyToOne(optional = false)
    private Ingredientes idIngredientes;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public IngredientesProducto() {
    }

    public IngredientesProducto(Integer idIp) {
        this.idIp = idIp;
    }

    public Integer getIdIp() {
        return idIp;
    }

    public void setIdIp(Integer idIp) {
        this.idIp = idIp;
    }

    public Ingredientes getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Ingredientes idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIp != null ? idIp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientesProducto)) {
            return false;
        }
        IngredientesProducto other = (IngredientesProducto) object;
        if ((this.idIp == null && other.idIp != null) || (this.idIp != null && !this.idIp.equals(other.idIp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.IngredientesProducto[ idIp=" + idIp + " ]";
    }
    
}
