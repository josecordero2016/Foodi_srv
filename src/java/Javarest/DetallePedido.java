/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByIdDp", query = "SELECT d FROM DetallePedido d WHERE d.idDp = :idDp")
    , @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallePedido.findByPrecioUnitario", query = "SELECT d FROM DetallePedido d WHERE d.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "DetallePedido.findByObservacion", query = "SELECT d FROM DetallePedido d WHERE d.observacion = :observacion")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dp")
    private Integer idDp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @JoinColumn(name = "id_producto_final", referencedColumnName = "id_producto_final")
    @ManyToOne(optional = false)
    private ProductoFinal idProductoFinal;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDp) {
        this.idDp = idDp;
    }

    public DetallePedido(Integer idDp, int cantidad, BigDecimal precioUnitario) {
        this.idDp = idDp;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdDp() {
        return idDp;
    }

    public void setIdDp(Integer idDp) {
        this.idDp = idDp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public ProductoFinal getIdProductoFinal() {
        return idProductoFinal;
    }

    public void setIdProductoFinal(ProductoFinal idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDp != null ? idDp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.idDp == null && other.idDp != null) || (this.idDp != null && !this.idDp.equals(other.idDp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.DetallePedido[ idDp=" + idDp + " ]";
    }
    
}
