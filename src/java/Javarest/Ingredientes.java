/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author im_jo
 */
@Entity
@Table(name = "ingredientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i")
    , @NamedQuery(name = "Ingredientes.findByIdIngredientes", query = "SELECT i FROM Ingredientes i WHERE i.idIngredientes = :idIngredientes")
    , @NamedQuery(name = "Ingredientes.findByNombre", query = "SELECT i FROM Ingredientes i WHERE i.nombre = :nombre")})
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingredientes")
    private Integer idIngredientes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "ingredientes_producto", joinColumns = {
        @JoinColumn(name = "id_ingredientes", referencedColumnName = "id_ingredientes")}, inverseJoinColumns = {
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")})
    @ManyToMany
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;

    public Ingredientes() {
    }

    public Ingredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Ingredientes(Integer idIngredientes, String nombre) {
        this.idIngredientes = idIngredientes;
        this.nombre = nombre;
    }

    public Integer getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
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
        hash += (idIngredientes != null ? idIngredientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.idIngredientes == null && other.idIngredientes != null) || (this.idIngredientes != null && !this.idIngredientes.equals(other.idIngredientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Ingredientes[ idIngredientes=" + idIngredientes + " ]";
    }
    
}
