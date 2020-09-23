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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "detalle_combo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCombo.findAll", query = "SELECT d FROM DetalleCombo d")
    , @NamedQuery(name = "DetalleCombo.findByIdDetalleCombo", query = "SELECT d FROM DetalleCombo d WHERE d.idDetalleCombo = :idDetalleCombo")
    , @NamedQuery(name = "DetalleCombo.findByCantidad", query = "SELECT d FROM DetalleCombo d WHERE d.cantidad = :cantidad")})
public class DetalleCombo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_combo")
    private Integer idDetalleCombo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_combo", referencedColumnName = "id_combo")
    @ManyToOne(optional = false)
    private Combo idCombo;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleCombo() {
    }

    public DetalleCombo(Integer idDetalleCombo) {
        this.idDetalleCombo = idDetalleCombo;
    }

    public DetalleCombo(Integer idDetalleCombo, int cantidad) {
        this.idDetalleCombo = idDetalleCombo;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleCombo() {
        return idDetalleCombo;
    }

    public void setIdDetalleCombo(Integer idDetalleCombo) {
        this.idDetalleCombo = idDetalleCombo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Combo getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(Combo idCombo) {
        this.idCombo = idCombo;
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
        hash += (idDetalleCombo != null ? idDetalleCombo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCombo)) {
            return false;
        }
        DetalleCombo other = (DetalleCombo) object;
        if ((this.idDetalleCombo == null && other.idDetalleCombo != null) || (this.idDetalleCombo != null && !this.idDetalleCombo.equals(other.idDetalleCombo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.DetalleCombo[ idDetalleCombo=" + idDetalleCombo + " ]";
    }
    
}
