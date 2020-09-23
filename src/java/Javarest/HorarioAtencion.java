/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "horario_atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioAtencion.findAll", query = "SELECT h FROM HorarioAtencion h")
    , @NamedQuery(name = "HorarioAtencion.findByIdHorarioAtencion", query = "SELECT h FROM HorarioAtencion h WHERE h.idHorarioAtencion = :idHorarioAtencion")
    , @NamedQuery(name = "HorarioAtencion.findByDia", query = "SELECT h FROM HorarioAtencion h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioAtencion.findByHoraInicio", query = "SELECT h FROM HorarioAtencion h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioAtencion.findByHoraFin", query = "SELECT h FROM HorarioAtencion h WHERE h.horaFin = :horaFin")
    , @NamedQuery(name = "HorarioAtencion.findByObservacion", query = "SELECT h FROM HorarioAtencion h WHERE h.observacion = :observacion")})
public class HorarioAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario_atencion")
    private Integer idHorarioAtencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento idEstablecimiento;

    public HorarioAtencion() {
    }

    public HorarioAtencion(Integer idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public HorarioAtencion(Integer idHorarioAtencion, String dia, Date horaInicio, Date horaFin) {
        this.idHorarioAtencion = idHorarioAtencion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdHorarioAtencion() {
        return idHorarioAtencion;
    }

    public void setIdHorarioAtencion(Integer idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        hash += (idHorarioAtencion != null ? idHorarioAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioAtencion)) {
            return false;
        }
        HorarioAtencion other = (HorarioAtencion) object;
        if ((this.idHorarioAtencion == null && other.idHorarioAtencion != null) || (this.idHorarioAtencion != null && !this.idHorarioAtencion.equals(other.idHorarioAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.HorarioAtencion[ idHorarioAtencion=" + idHorarioAtencion + " ]";
    }
    
}
