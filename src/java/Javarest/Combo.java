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
 * @author im_jo
 */
@Entity
@Table(name = "combo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combo.findAll", query = "SELECT c FROM Combo c")
    , @NamedQuery(name = "Combo.findByIdCombo", query = "SELECT c FROM Combo c WHERE c.idCombo = :idCombo")
    , @NamedQuery(name = "Combo.findByNombreCombo", query = "SELECT c FROM Combo c WHERE c.nombreCombo = :nombreCombo")
    , @NamedQuery(name = "Combo.findByIdChef", query = "SELECT c FROM Combo c WHERE c.idChef = :idChef")})
public class Combo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_combo")
    private Integer idCombo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_combo")
    private String nombreCombo;
    @Column(name = "id_chef")
    private Integer idChef;
    @OneToMany(mappedBy = "idCombo")
    private Collection<ProductoFinal> productoFinalCollection;

    public Combo() {
    }

    public Combo(Integer idCombo) {
        this.idCombo = idCombo;
    }

    public Combo(Integer idCombo, String nombreCombo) {
        this.idCombo = idCombo;
        this.nombreCombo = nombreCombo;
    }

    public Integer getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(Integer idCombo) {
        this.idCombo = idCombo;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public Integer getIdChef() {
        return idChef;
    }

    public void setIdChef(Integer idChef) {
        this.idChef = idChef;
    }

    @XmlTransient
    public Collection<ProductoFinal> getProductoFinalCollection() {
        return productoFinalCollection;
    }

    public void setProductoFinalCollection(Collection<ProductoFinal> productoFinalCollection) {
        this.productoFinalCollection = productoFinalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombo != null ? idCombo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combo)) {
            return false;
        }
        Combo other = (Combo) object;
        if ((this.idCombo == null && other.idCombo != null) || (this.idCombo != null && !this.idCombo.equals(other.idCombo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Combo[ idCombo=" + idCombo + " ]";
    }
    
}
