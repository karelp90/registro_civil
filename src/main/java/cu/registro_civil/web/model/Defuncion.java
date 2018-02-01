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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author admin
 */
@Entity
@DiscriminatorValue("DEFUNCION")
@Table(name = "defuncion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Defuncion.findAll", query = "SELECT d FROM Defuncion d")})
public class Defuncion extends Solicitud {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_fallecimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaFallecimiento;
    @Column(name = "tomo_defuncion")
    private Integer tomoDefuncion;
    @Column(name = "folio_defuncion")
    private Integer folioDefuncion;
    @Size(max = 255)
    @Column(name = "lugar_fallecimiento")
    private String lugarFallecimiento;

    public Defuncion() {
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Integer getTomoDefuncion() {
        return tomoDefuncion;
    }

    public void setTomoDefuncion(Integer tomoDefuncion) {
        this.tomoDefuncion = tomoDefuncion;
    }

    public Integer getFolioDefuncion() {
        return folioDefuncion;
    }

    public void setFolioDefuncion(Integer folioDefuncion) {
        this.folioDefuncion = folioDefuncion;
    }

    public String getLugarFallecimiento() {
        return lugarFallecimiento;
    }

    public void setLugarFallecimiento(String lugarFallecimiento) {
        this.lugarFallecimiento = lugarFallecimiento;
    }


    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Defuncion[ idSolicitud=" + super.getId() + " ]";
    }

}
