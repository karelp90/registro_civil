/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author admin
 */
@Entity
@DiscriminatorValue("CIUDADANIA")
@Table(name = "ciudadania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadania.findAll", query = "SELECT c FROM Ciudadania c")})
public class Ciudadania extends Solicitud {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_entra_al_pais")
    @Temporal(TemporalType.DATE)
    private Date fechaEntraAlPais;
    @Column(name = "tomo_ciudadania")
    private Integer tomoCiudadania;
    @Column(name = "folio_ciudadania")
    private Integer folioCiudadania;

    public Ciudadania() {
    }

    public Date getFechaEntraAlPais() {
        return fechaEntraAlPais;
    }

    public void setFechaEntraAlPais(Date fechaEntraAlPais) {
        this.fechaEntraAlPais = fechaEntraAlPais;
    }

    public Integer getTomoCiudadania() {
        return tomoCiudadania;
    }

    public void setTomoCiudadania(Integer tomoCiudadania) {
        this.tomoCiudadania = tomoCiudadania;
    }

    public Integer getFolioCiudadania() {
        return folioCiudadania;
    }

    public void setFolioCiudadania(Integer folioCiudadania) {
        this.folioCiudadania = folioCiudadania;
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Ciudadania[ idSolicitud=" + super.getId() + " ]";
    }

}
