/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.projection;

import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.model.OficinaRegistroCivil;
import cu.registro_civil.web.model.Solicitud;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author admin
 */
@Projection(name = "solicitudProjection", types = {Solicitud.class})
public interface SolicitudProjection {

    public Integer getId();

    public String getNombresApellidos();

    public Character getSurtirEfecto();

    public String getCod();

    public String getTipo();

    public String getOtrosDatos();

    public Date getFechaSolicitud();

    public String getEstado();

    public String getEmail();

    public String getUrl();

    public OficinaRegistroCivil getIdOficRegCivilInscrito();

    public OficinaRegistroCivil getIdOficRegCivilARecoger();

}
