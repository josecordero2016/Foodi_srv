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
@Table(name = "disponibilidad_mesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadMesas.findAll", query = "SELECT d FROM DisponibilidadMesas d")
    , @NamedQuery(name = "DisponibilidadMesas.findByIdDisponibilidad", query = "SELECT d FROM DisponibilidadMesas d WHERE d.idDisponibilidad = :idDisponibilidad")
    , @NamedQuery(name = "DisponibilidadMesas.findByNumMesa", query = "SELECT d FROM DisponibilidadMesas d WHERE d.numMesa = :numMesa")
    , @NamedQuery(name = "DisponibilidadMesas.findByCantSillas", query = "SELECT d FROM DisponibilidadMesas d WHERE d.cantSillas = :cantSillas")
    , @NamedQuery(name = "DisponibilidadMesas.findByDisponibilidad", query = "SELECT d FROM DisponibilidadMesas d WHERE d.disponibilidad = :disponibilidad")})
public class DisponibilidadMesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disponibilidad")
    private Integer idDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_mesa")
    private int numMesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_sillas")
    private int cantSillas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponibilidad")
    private boolean disponibilidad;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;

    public DisponibilidadMesas() {
    }

    public DisponibilidadMesas(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public DisponibilidadMesas(Integer idDisponibilidad, int numMesa, int cantSillas, boolean disponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
        this.numMesa = numMesa;
        this.cantSillas = cantSillas;
        this.disponibilidad = disponibilidad;
    }

    public Integer getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCantSillas() {
        return cantSillas;
    }

    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisponibilidad != null ? idDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadMesas)) {
            return false;
        }
        DisponibilidadMesas other = (DisponibilidadMesas) object;
        if ((this.idDisponibilidad == null && other.idDisponibilidad != null) || (this.idDisponibilidad != null && !this.idDisponibilidad.equals(other.idDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.DisponibilidadMesas[ idDisponibilidad=" + idDisponibilidad + " ]";
    }
    
}
