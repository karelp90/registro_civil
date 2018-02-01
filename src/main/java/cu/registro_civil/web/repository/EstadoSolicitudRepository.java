/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.repository;

import cu.registro_civil.web.model.EstadoSolicitud;
import cu.registro_civil.web.projection.EstadoSolicitudProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author copy
 */
@RepositoryRestResource(collectionResourceRel = "listado", path = "estados", excerptProjection = EstadoSolicitudProjection.class)
public interface EstadoSolicitudRepository extends PagingAndSortingRepository<EstadoSolicitud, Integer> {

    @Query(value = "SELECT e FROM EstadoSolicitud e WHERE LOWER(e.orden) = 'inicio'")
    EstadoSolicitud estadoInicial();

//    @Query(value = "SELECT h FROM HistorialEstadoSolicitud h WHERE h.idSolicitud.id = ?1")
//    EstadoSolicitud estadoActual(@Param("idSolicitud") Integer idSolicitud);
}
