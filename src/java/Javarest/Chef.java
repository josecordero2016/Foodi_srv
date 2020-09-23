/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "chef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chef.findAll", query = "SELECT c FROM Chef c")
    , @NamedQuery(name = "Chef.findByIdChef", query = "SELECT c FROM Chef c WHERE c.idChef = :idChef")
    , @NamedQuery(name = "Chef.findByFechaContratado", query = "SELECT c FROM Chef c WHERE c.fechaContratado = :fechaContratado")})
public class Chef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chef")
    private Integer idChef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_contratado")
    @Temporal(TemporalType.DATE)
    private Date fechaContratado;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(mappedBy = "idChef")
    private Collection<Producto> productoCollection;

    public Chef() {
    }

    public Chef(Integer idChef) {
        this.idChef = idChef;
    }

    public Chef(Integer idChef, Date fechaContratado) {
        this.idChef = idChef;
        this.fechaContratado = fechaContratado;
    }

    public Integer getIdChef() {
        return idChef;
    }

    public void setIdChef(Integer idChef) {
        this.idChef = idChef;
    }

    public Date getFechaContratado() {
        return fechaContratado;
    }

    public void setFechaContratado(Date fechaContratado) {
        this.fechaContratado = fechaContratado;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChef != null ? idChef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chef)) {
            return false;
        }
        Chef other = (Chef) object;
        if ((this.idChef == null && other.idChef != null) || (this.idChef != null && !this.idChef.equals(other.idChef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.Chef[ idChef=" + idChef + " ]";
    }
    
}
