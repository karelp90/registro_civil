package cu.registro_civil.web.repository;

import cu.registro_civil.web.model.Solicitud;
import cu.registro_civil.web.projection.SolicitudProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "listado", path = "solicitud", excerptProjection = SolicitudProjection.class)
public interface SolicitudRepository extends PagingAndSortingRepository<Solicitud, Integer> {

//    /*Metodo para buscar en el servidor los materiales en la pantalla pcpal y mostrar los resultados en el paginador*/
//    @Query(value = "SELECT m FROM NomProSemi m WHERE LOWER(m.descr) LIKE %?1% OR LOWER(m.cod) LIKE %?1%")
//    Page<NomProSemi> SearchProdSemi(@Param("text") String text, Pageable pageable);
//
//    @Query("SELECT cat FROM NomProSemi cat order by cat.id")
//    Page<NomProSemi> listAllProdSemi(Pageable pageable);
}
