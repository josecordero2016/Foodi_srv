/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_chef", referencedColumnName = "id_chef")
    @ManyToOne
    private Chef idChef;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<DetalleCombo> detalleComboCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<ProductoFinal> productoFinalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<IngredientesProducto> ingredientesProductoCollection;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Chef getIdChef() {
        return idChef;
    }

    public void setIdChef(Chef idChef) {
        this.idChef = idChef;
    }

    @XmlTransient
    public Collection<DetalleCombo> getDetalleComboCollection() {
        return detalleComboCollection;
    }

    public void setDetalleComboCollection(Collection<DetalleCombo> detalleComboCollection) {
        this.detalleComboCollection = detalleComboCollection;
    }

    @XmlTransient
    public Collection<ProductoFinal> getProductoFinalCollection() {
        return productoFinalCollection;
    }

    public void setProductoFinalCollection(Collection<ProductoFinal> productoFinalCollection) {
        this.productoFinalCollection = productoFinalCollection;
    }

    @XmlTransient
    public Collection<IngredientesProducto> getIngredientesProductoCollection() {
        return ingredientesProductoCollection;
    }

    public void setIngredientesProductoCollection(Collection<IngredientesProducto> ingredientesProductoCollection) {
        this.ingredientesProductoCollection = ingredientesProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
