/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author germa
 */
@Entity
@Table(name = "vwbuscar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwbuscar.findAll", query = "SELECT v FROM Vwbuscar v")
    , @NamedQuery(name = "Vwbuscar.findById1", query = "SELECT v FROM Vwbuscar v WHERE v.id1 = :id1")
    , @NamedQuery(name = "Vwbuscar.findByIdProductoFinal", query = "SELECT v FROM Vwbuscar v WHERE v.idProductoFinal = :idProductoFinal")
    , @NamedQuery(name = "Vwbuscar.findByNombre", query = "SELECT v FROM Vwbuscar v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vwbuscar.findByPrecio", query = "SELECT v FROM Vwbuscar v WHERE v.precio = :precio")
    , @NamedQuery(name = "Vwbuscar.findByEstablecimiento", query = "SELECT v FROM Vwbuscar v WHERE v.establecimiento = :establecimiento")
    , @NamedQuery(name = "Vwbuscar.findByFoto", query = "SELECT v FROM Vwbuscar v WHERE v.foto = :foto")
    , @NamedQuery(name = "Vwbuscar.findByTipo", query = "SELECT v FROM Vwbuscar v WHERE v.tipo = :tipo")})
public class Vwbuscar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_1")
    @Id
    private BigInteger id1;
    @Column(name = "id_producto_final")
    private Integer idProductoFinal;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "precio")
    private String precio;
    @Size(max = 2147483647)
    @Column(name = "establecimiento")
    private String establecimiento;
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;

    public Vwbuscar() {
    }

    public BigInteger getId1() {
        return id1;
    }

    public void setId1(BigInteger id1) {
        this.id1 = id1;
    }

    public Integer getIdProductoFinal() {
        return idProductoFinal;
    }

    public void setIdProductoFinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
