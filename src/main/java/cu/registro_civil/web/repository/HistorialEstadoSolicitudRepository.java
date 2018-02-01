/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.repository;

import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.projection.HistorialEstadoSolicitudProjection;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author admin
 */
@RepositoryRestResource(collectionResourceRel = "listado", path = "historial", excerptProjection = HistorialEstadoSolicitudProjection.class)
public interface HistorialEstadoSolicitudRepository extends PagingAndSortingRepository<HistorialEstadoSolicitud, Integer> {

    //    /*Metodo para buscar en el servidor los materiales en la pantalla pcpal y mostrar los resultados en el paginador*/
    @Query(value = "SELECT h FROM HistorialEstadoSolicitud h WHERE h.idSolicitud.id = ?1 AND LOWER(h.idEstado.orden) = 'inicio' ")
    HistorialEstadoSolicitud estadoInicial(@Param("idSolicitud") Integer idSolicitud);
    
    @Query(value = "SELECT h FROM HistorialEstadoSolicitud h WHERE h.fechaEstado = ( SELECT MAX(m.fechaEstado) FROM HistorialEstadoSolicitud m WHERE m.idSolicitud.id = ?1 ) ")
    HistorialEstadoSolicitud estadoActual(@Param("idSolicitud") Integer idSolicitud);

    @Query(value = "SELECT h FROM HistorialEstadoSolicitud h WHERE h.idSolicitud.id = ?1 ORDER BY h.fechaEstado DESC")
    Collection<HistorialEstadoSolicitud> historialDeEstadosPorSolicitud(@Param("idSolicitud") Integer idSolicitud);
    
    @Query(value = "SELECT h FROM HistorialEstadoSolicitud h WHERE h.idSolicitud.cod = ?1 ORDER BY h.fechaEstado DESC")
    Collection<HistorialEstadoSolicitud> historialDeEstados(@Param("cod") String cod);
}
