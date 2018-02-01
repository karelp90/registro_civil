/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.projection;

import cu.registro_civil.web.model.EstadoSolicitud;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author admin
 */
@Projection(name = "estadoSolicitudProjection", types = {EstadoSolicitud.class})
public interface EstadoSolicitudProjection {

    public String getDescr();

    public String getOrden();

}
