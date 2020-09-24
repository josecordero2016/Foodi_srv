/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "vwdetalledepedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwdetalledepedidos.findAll", query = "SELECT v FROM Vwdetalledepedidos v")
    , @NamedQuery(name = "Vwdetalledepedidos.findByIdDp", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.idDp = :idDp")
    , @NamedQuery(name = "Vwdetalledepedidos.findByIdPedido", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.idPedido = :idPedido")
    , @NamedQuery(name = "Vwdetalledepedidos.findByIdProductoFinal", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.idProductoFinal = :idProductoFinal")
    , @NamedQuery(name = "Vwdetalledepedidos.findByIdEstablecimiento", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.idEstablecimiento = :idEstablecimiento")
    , @NamedQuery(name = "Vwdetalledepedidos.findByDescripcion", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Vwdetalledepedidos.findByFoto", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.foto = :foto")
    , @NamedQuery(name = "Vwdetalledepedidos.findByPrecio", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.precio = :precio")
    , @NamedQuery(name = "Vwdetalledepedidos.findByCantidad", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Vwdetalledepedidos.findByIdTipoProducto", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.idTipoProducto = :idTipoProducto")
    , @NamedQuery(name = "Vwdetalledepedidos.findByTipo", query = "SELECT v FROM Vwdetalledepedidos v WHERE v.tipo = :tipo")})
public class Vwdetalledepedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_dp")
    @Id
    private Integer idDp;
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "id_producto_final")
    private Integer idProductoFinal;
    @Column(name = "id_establecimiento")
    private Integer idEstablecimiento;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "foto")
    private String foto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "id_tipo_producto")
    private Integer idTipoProducto;
    @Size(max = 10)
    @Column(name = "tipo")
    private String tipo;

    public Vwdetalledepedidos() {
    }

    public Integer getIdDp() {
        return idDp;
    }

    public void setIdDp(Integer idDp) {
        this.idDp = idDp;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProductoFinal() {
        return idProductoFinal;
    }

    public void setIdProductoFinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
