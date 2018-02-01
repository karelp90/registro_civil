/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @author admin
 */
@Entity
@Table(name = "historial_estado_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialEstadoSolicitud.findAll", query = "SELECT h FROM HistorialEstadoSolicitud h")})
public class HistorialEstadoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_estado")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", locale = "en-US")
    private Date fechaEstado;
    @Size(max = 255)
    @Column(name = "observ")
    private String observ;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoSolicitud idEstado;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;

    public HistorialEstadoSolicitud() {
    }

    public HistorialEstadoSolicitud(Integer id) {
        this.id = id;
    }

    public HistorialEstadoSolicitud(Integer id, Date fechaEstado) {
        this.id = id;
        this.fechaEstado = fechaEstado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public EstadoSolicitud getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoSolicitud idEstado) {
        this.idEstado = idEstado;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialEstadoSolicitud)) {
            return false;
        }
        HistorialEstadoSolicitud other = (HistorialEstadoSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"fechaEstado\": " + fechaEstado + ", \"observ\":" + observ + " }";
    }

}
