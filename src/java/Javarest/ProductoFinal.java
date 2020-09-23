/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "producto_final")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoFinal.findAll", query = "SELECT p FROM ProductoFinal p")
    , @NamedQuery(name = "ProductoFinal.findByIdProductoFinal", query = "SELECT p FROM ProductoFinal p WHERE p.idProductoFinal = :idProductoFinal")
    , @NamedQuery(name = "ProductoFinal.findByDescripcion", query = "SELECT p FROM ProductoFinal p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProductoFinal.findByFoto", query = "SELECT p FROM ProductoFinal p WHERE p.foto = :foto")
    , @NamedQuery(name = "ProductoFinal.findByPrecio", query = "SELECT p FROM ProductoFinal p WHERE p.precio = :precio")})
public class ProductoFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto_final")
    private Integer idProductoFinal;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "foto")
    private String foto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoFinal")
    private Collection<Calificacion> calificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoFinal")
    private Collection<ProductoFinalComplementos> productoFinalComplementosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoFinal")
    private Collection<DetallePedido> detallePedidoCollection;
    @JoinColumn(name = "id_combo", referencedColumnName = "id_combo")
    @ManyToOne
    private Combo idCombo;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto")
    @ManyToOne(optional = false)
    private TipoProducto idTipoProducto;

    public ProductoFinal() {
    }

    public ProductoFinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public ProductoFinal(Integer idProductoFinal, BigDecimal precio) {
        this.idProductoFinal = idProductoFinal;
        this.precio = precio;
    }

    public Integer getIdProductoFinal() {
        return idProductoFinal;
    }

    public void setIdProductoFinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    @XmlTransient
    public Collection<ProductoFinalComplementos> getProductoFinalComplementosCollection() {
        return productoFinalComplementosCollection;
    }

    public void setProductoFinalComplementosCollection(Collection<ProductoFinalComplementos> productoFinalComplementosCollection) {
        this.productoFinalComplementosCollection = productoFinalComplementosCollection;
    }

    @XmlTransient
    public Collection<DetallePedido> getDetallePedidoCollection() {
        return detallePedidoCollection;
    }

    public void setDetallePedidoCollection(Collection<DetallePedido> detallePedidoCollection) {
        this.detallePedidoCollection = detallePedidoCollection;
    }

    public Combo getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(Combo idCombo) {
        this.idCombo = idCombo;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoFinal != null ? idProductoFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoFinal)) {
            return false;
        }
        ProductoFinal other = (ProductoFinal) object;
        if ((this.idProductoFinal == null && other.idProductoFinal != null) || (this.idProductoFinal != null && !this.idProductoFinal.equals(other.idProductoFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.ProductoFinal[ idProductoFinal=" + idProductoFinal + " ]";
    }
    
}
