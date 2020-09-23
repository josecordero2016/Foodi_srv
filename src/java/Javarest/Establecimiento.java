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
@Table(name = "establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Establecimiento.findAll", query = "SELECT e FROM Establecimiento e")
    , @NamedQuery(name = "Establecimiento.findByIdEstablecimiento", query = "SELECT e FROM Establecimiento e WHERE e.idEstablecimiento = :idEstablecimiento")
    , @NamedQuery(name = "Establecimiento.findByNombre", query = "SELECT e FROM Establecimiento e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Establecimiento.findByDireccion", query = "SELECT e FROM Establecimiento e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Establecimiento.findByTelefono", query = "SELECT e FROM Establecimiento e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Establecimiento.findByWhatsapp", query = "SELECT e FROM Establecimiento e WHERE e.whatsapp = :whatsapp")
    , @NamedQuery(name = "Establecimiento.findByDescripcion", query = "SELECT e FROM Establecimiento e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Establecimiento.findByLatitud", query = "SELECT e FROM Establecimiento e WHERE e.latitud = :latitud")
    , @NamedQuery(name = "Establecimiento.findByLongitud", query = "SELECT e FROM Establecimiento e WHERE e.longitud = :longitud")
    , @NamedQuery(name = "Establecimiento.findByVerificado", query = "SELECT e FROM Establecimiento e WHERE e.verificado = :verificado")
    , @NamedQuery(name = "Establecimiento.findByCalificacion", query = "SELECT e FROM Establecimiento e WHERE e.calificacion = :calificacion")
    , @NamedQuery(name = "Establecimiento.findByReglas", query = "SELECT e FROM Establecimiento e WHERE e.reglas = :reglas")
    , @NamedQuery(name = "Establecimiento.findByFoto", query = "SELECT e FROM Establecimiento e WHERE e.foto = :foto")})
public class Establecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_establecimiento")
    private Integer idEstablecimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 10)
    @Column(name = "whatsapp")
    private String whatsapp;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verificado")
    private boolean verificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Size(max = 150)
    @Column(name = "reglas")
    private String reglas;
    @Size(max = 150)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<Ingredientes> ingredientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<Complementos> complementosCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<Chef> chefCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<HorarioAtencion> horarioAtencionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<DisponibilidadMesas> disponibilidadMesasCollection;
    @OneToMany(mappedBy = "idEstablecimiento")
    private Collection<CategoriaEstablecimiento> categoriaEstablecimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablecimiento")
    private Collection<ProductoFinal> productoFinalCollection;

    public Establecimiento() {
    }

    public Establecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Establecimiento(Integer idEstablecimiento, String nombre, String direccion, String telefono, String latitud, String longitud, boolean verificado, int calificacion) {
        this.idEstablecimiento = idEstablecimiento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.verificado = verificado;
        this.calificacion = calificacion;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Ingredientes> getIngredientesCollection() {
        return ingredientesCollection;
    }

    public void setIngredientesCollection(Collection<Ingredientes> ingredientesCollection) {
        this.ingredientesCollection = ingredientesCollection;
    }

    @XmlTransient
    public Collection<Complementos> getComplementosCollection() {
        return complementosCollection;
    }

    public void setComplementosCollection(Collection<Complementos> complementosCollection) {
        this.complementosCollection = complementosCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Chef> getChefCollection() {
        return chefCollection;
    }

    public void setChefCollection(Collection<Chef> chefCollection) {
        this.chefCollection = chefCollection;
    }

    @XmlTransient
    public Collection<HorarioAtencion> getHorarioAtencionCollection() {
        return horarioAtencionCollection;
    }

    public void setHorarioAtencionCollection(Collection<HorarioAtencion> horarioAtencionCollection) {
        this.horarioAtencionCollection = horarioAtencionCollection;
    }

    @XmlTransient
    public Collection<DisponibilidadMesas> getDisponibilidadMesasCollection() {
        return disponibilidadMesasCollection;
    }

    public void setDisponibilidadMesasCollection(Collection<DisponibilidadMesas> disponibilidadMesasCollection) {
        this.disponibilidadMesasCollection = disponibilidadMesasCollection;
    }

    @XmlTransient
    public Collection<CategoriaEstablecimiento> getCategoriaEstablecimientoCollection() {
        return categoriaEstablecimientoCollection;
    }

    public void setCategoriaEstablecimientoCollection(Collection<CategoriaEstablecimiento> categoriaEstablecimientoCollection) {
        this.categoriaEstablecimientoCollection = categoriaEstablecimientoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        hash += (idEstablecimiento != null ? idEstablecimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establecimiento)) {
            return false;
        }
        Establecimiento other = (Establecimiento) object;
        if ((this.idEstablecimiento == null && other.idEstablecimiento != null) || (this.idEstablecimiento != null && !this.idEstablecimiento.equals(other.idEstablecimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Establecimiento[ idEstablecimiento=" + idEstablecimiento + " ]";
    }
    
}
