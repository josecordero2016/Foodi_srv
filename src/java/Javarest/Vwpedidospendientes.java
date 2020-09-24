/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author im_jo
 */
@Entity
@Table(name = "vwpedidospendientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwpedidospendientes.findAll", query = "SELECT v FROM Vwpedidospendientes v")
    , @NamedQuery(name = "Vwpedidospendientes.findByIdPedido", query = "SELECT v FROM Vwpedidospendientes v WHERE v.idPedido = :idPedido")
    , @NamedQuery(name = "Vwpedidospendientes.findByNombres", query = "SELECT v FROM Vwpedidospendientes v WHERE v.nombres = :nombres")
    , @NamedQuery(name = "Vwpedidospendientes.findByIdEstablecimiento", query = "SELECT v FROM Vwpedidospendientes v WHERE v.idEstablecimiento = :idEstablecimiento")
    , @NamedQuery(name = "Vwpedidospendientes.findByFecha", query = "SELECT v FROM Vwpedidospendientes v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vwpedidospendientes.findByDireccion", query = "SELECT v FROM Vwpedidospendientes v WHERE v.direccion = :direccion")
    , @NamedQuery(name = "Vwpedidospendientes.findByLatitud", query = "SELECT v FROM Vwpedidospendientes v WHERE v.latitud = :latitud")
    , @NamedQuery(name = "Vwpedidospendientes.findByLongitud", query = "SELECT v FROM Vwpedidospendientes v WHERE v.longitud = :longitud")
    , @NamedQuery(name = "Vwpedidospendientes.findByValorTotal", query = "SELECT v FROM Vwpedidospendientes v WHERE v.valorTotal = :valorTotal")})
public class Vwpedidospendientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_pedido")
    @Id
    private Integer idPedido;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 2147483647)
    @Column(name = "id_establecimiento")
    private String idEstablecimiento;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 25)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 25)
    @Column(name = "longitud")
    private String longitud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    public Vwpedidospendientes() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(String idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
