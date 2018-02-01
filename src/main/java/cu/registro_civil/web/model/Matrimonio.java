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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@DiscriminatorValue("MATRIMONIO")
@Table(name = "matrimonio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matrimonio.findAll", query = "SELECT m FROM Matrimonio m")})
public class Matrimonio extends Solicitud {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombres_apellidos_hombre")
    private String nombresApellidosHombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombres_apellidos_mujer")
    private String nombresApellidosMujer;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_matrimonio")
    @Temporal(TemporalType.DATE)
    private Date fechaMatrimonio;
    @Column(name = "tomo_matrimonio")
    private Integer tomoMatrimonio;
    @Column(name = "folio_matrimonio")
    private Integer folioMatrimonio;

    public Matrimonio() {
    }

    public String getNombresApellidosHombre() {
        return nombresApellidosHombre;
    }

    public void setNombresApellidosHombre(String nombresApellidosHombre) {
        this.nombresApellidosHombre = nombresApellidosHombre;
    }

    public String getNombresApellidosMujer() {
        return nombresApellidosMujer;
    }

    public void setNombresApellidosMujer(String nombresApellidosMujer) {
        this.nombresApellidosMujer = nombresApellidosMujer;
    }

    public Date getFechaMatrimonio() {
        return fechaMatrimonio;
    }

    public void setFechaMatrimonio(Date fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public Integer getTomoMatrimonio() {
        return tomoMatrimonio;
    }

    public void setTomoMatrimonio(Integer tomoMatrimonio) {
        this.tomoMatrimonio = tomoMatrimonio;
    }

    public Integer getFolioMatrimonio() {
        return folioMatrimonio;
    }

    public void setFolioMatrimonio(Integer folioMatrimonio) {
        this.folioMatrimonio = folioMatrimonio;
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Matrimonio[ idSolicitud=" + super.getId() + " ]";
    }
    
}
