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
 * @author admin
 */
@Entity
@Table(name = "oficina_registro_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OficinaRegistroCivil.findAll", query = "SELECT o FROM OficinaRegistroCivil o")})
public class OficinaRegistroCivil implements Serializable {

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
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio idMunicipio;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOficRegCivilInscrito")
//    private Collection<Solicitud> solicitudCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOficRegCivilARecoger")
//    private Collection<Solicitud> solicitudCollection1;

    public OficinaRegistroCivil() {
    }

    public OficinaRegistroCivil(Integer id) {
        this.id = id;
    }

    public OficinaRegistroCivil(Integer id, String descr) {
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

    public Municipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

//    @XmlTransient
//    public Collection<Solicitud> getSolicitudCollection() {
//        return solicitudCollection;
//    }
//
//    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
//        this.solicitudCollection = solicitudCollection;
//    }
//
//    @XmlTransient
//    public Collection<Solicitud> getSolicitudCollection1() {
//        return solicitudCollection1;
//    }
//
//    public void setSolicitudCollection1(Collection<Solicitud> solicitudCollection1) {
//        this.solicitudCollection1 = solicitudCollection1;
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
        if (!(object instanceof OficinaRegistroCivil)) {
            return false;
        }
        OficinaRegistroCivil other = (OficinaRegistroCivil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.OficinaRegistroCivil[ id=" + id + " ]";
    }
    
}
