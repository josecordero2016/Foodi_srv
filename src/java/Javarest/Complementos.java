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
@Table(name = "complementos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complementos.findAll", query = "SELECT c FROM Complementos c")
    , @NamedQuery(name = "Complementos.findByIdComplementos", query = "SELECT c FROM Complementos c WHERE c.idComplementos = :idComplementos")
    , @NamedQuery(name = "Complementos.findByImagen", query = "SELECT c FROM Complementos c WHERE c.imagen = :imagen")
    , @NamedQuery(name = "Complementos.findByNombre", query = "SELECT c FROM Complementos c WHERE c.nombre = :nombre")})
public class Complementos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complementos")
    private Integer idComplementos;
    @Size(max = 200)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComplementos")
    private Collection<ProductoFinalComplementos> productoFinalComplementosCollection;

    public Complementos() {
    }

    public Complementos(Integer idComplementos) {
        this.idComplementos = idComplementos;
    }

    public Complementos(Integer idComplementos, String nombre) {
        this.idComplementos = idComplementos;
        this.nombre = nombre;
    }

    public Integer getIdComplementos() {
        return idComplementos;
    }

    public void setIdComplementos(Integer idComplementos) {
        this.idComplementos = idComplementos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    @XmlTransient
    public Collection<ProductoFinalComplementos> getProductoFinalComplementosCollection() {
        return productoFinalComplementosCollection;
    }

    public void setProductoFinalComplementosCollection(Collection<ProductoFinalComplementos> productoFinalComplementosCollection) {
        this.productoFinalComplementosCollection = productoFinalComplementosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComplementos != null ? idComplementos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complementos)) {
            return false;
        }
        Complementos other = (Complementos) object;
        if ((this.idComplementos == null && other.idComplementos != null) || (this.idComplementos != null && !this.idComplementos.equals(other.idComplementos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Complementos[ idComplementos=" + idComplementos + " ]";
    }
    
}
