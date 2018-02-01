/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author admin
 */
@Entity
@Table(name = "estado_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoSolicitud.findAll", query = "SELECT e FROM EstadoSolicitud e")})
public class EstadoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr")
    private String descr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "orden")
    private String orden;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
//    private Collection<HistorialEstadoSolicitud> historialEstadoSolicitudCollection;

    public EstadoSolicitud() {
    }

    public EstadoSolicitud(Integer id) {
        this.id = id;
    }

    public EstadoSolicitud(Integer id, String descr) {
        this.id = id;
        this.descr = descr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
    

//    @XmlTransient
//    public Collection<HistorialEstadoSolicitud> getHistorialEstadoSolicitudCollection() {
//        return historialEstadoSolicitudCollection;
//    }
//
//    public void setHistorialEstadoSolicitudCollection(Collection<HistorialEstadoSolicitud> historialEstadoSolicitudCollection) {
//        this.historialEstadoSolicitudCollection = historialEstadoSolicitudCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSolicitud)) {
            return false;
        }
        EstadoSolicitud other = (EstadoSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.EstadoSolicitud[ id=" + id + " ]";
    }

}
