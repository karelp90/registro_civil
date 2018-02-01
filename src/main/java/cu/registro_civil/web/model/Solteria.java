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
@DiscriminatorValue("SOLTERIA")
@Table(name = "solteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solteria.findAll", query = "SELECT s FROM Solteria s")})
public class Solteria extends Solicitud {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_solteria")
    @Temporal(TemporalType.DATE)
    private Date fechaSolteria;
    @Column(name = "tomo_ci")
    private Integer tomoCi;
    @Column(name = "folio_ci")
    private Integer folioCi;

    public Solteria() {
    }

    public Date getFechaSolteria() {
        return fechaSolteria;
    }

    public void setFechaSolteria(Date fechaSolteria) {
        this.fechaSolteria = fechaSolteria;
    }

    public Integer getTomoCi() {
        return tomoCi;
    }

    public void setTomoCi(Integer tomoCi) {
        this.tomoCi = tomoCi;
    }

    public Integer getFolioCi() {
        return folioCi;
    }

    public void setFolioCi(Integer folioCi) {
        this.folioCi = folioCi;
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Solteria[ idSolicitud=" + super.getId() + " ]";
    }
    
}
