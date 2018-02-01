/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.model;

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
@DiscriminatorValue("NACIMIENTO")
@Table(name = "nacimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacimiento.findAll", query = "SELECT n FROM Nacimiento n")})
public class Nacimiento extends Solicitud {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tomo_ci")
    private int tomoCi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folio_ci")
    private int folioCi;

    public Nacimiento() {
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTomoCi() {
        return tomoCi;
    }

    public void setTomoCi(int tomoCi) {
        this.tomoCi = tomoCi;
    }

    public int getFolioCi() {
        return folioCi;
    }

    public void setFolioCi(int folioCi) {
        this.folioCi = folioCi;
    }


    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Nacimiento[ idSolicitud=" + super.getId() + " ]";
    }

}
