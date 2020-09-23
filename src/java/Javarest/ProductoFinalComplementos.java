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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "producto_final_complementos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoFinalComplementos.findAll", query = "SELECT p FROM ProductoFinalComplementos p")
    , @NamedQuery(name = "ProductoFinalComplementos.findByIdPfc", query = "SELECT p FROM ProductoFinalComplementos p WHERE p.idPfc = :idPfc")})
public class ProductoFinalComplementos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pfc")
    private Integer idPfc;
    @JoinColumn(name = "id_complementos", referencedColumnName = "id_complementos")
    @ManyToOne(optional = false)
    private Complementos idComplementos;
    @JoinColumn(name = "id_producto_final", referencedColumnName = "id_producto_final")
    @ManyToOne(optional = false)
    private ProductoFinal idProductoFinal;

    public ProductoFinalComplementos() {
    }

    public ProductoFinalComplementos(Integer idPfc) {
        this.idPfc = idPfc;
    }

    public Integer getIdPfc() {
        return idPfc;
    }

    public void setIdPfc(Integer idPfc) {
        this.idPfc = idPfc;
    }

    public Complementos getIdComplementos() {
        return idComplementos;
    }

    public void setIdComplementos(Complementos idComplementos) {
        this.idComplementos = idComplementos;
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
        hash += (idPfc != null ? idPfc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoFinalComplementos)) {
            return false;
        }
        ProductoFinalComplementos other = (ProductoFinalComplementos) object;
        if ((this.idPfc == null && other.idPfc != null) || (this.idPfc != null && !this.idPfc.equals(other.idPfc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Javarest.ProductoFinalComplementos[ idPfc=" + idPfc + " ]";
    }
    
}
