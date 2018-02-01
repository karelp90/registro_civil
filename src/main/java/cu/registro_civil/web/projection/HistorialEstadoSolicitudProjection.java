/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.projection;

import cu.registro_civil.web.model.EstadoSolicitud;
import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.model.OficinaRegistroCivil;
import cu.registro_civil.web.model.Solicitud;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author admin
 */
@Projection(name = "historialEstadoSolicitudProjection", types = {HistorialEstadoSolicitud.class})
public interface HistorialEstadoSolicitudProjection {

    public Date getFechaEstado();

    public String getObserv();

//    public EstadoSolicitud getIdEstado();
//
//    public Solicitud getIdSolicitud();

}
