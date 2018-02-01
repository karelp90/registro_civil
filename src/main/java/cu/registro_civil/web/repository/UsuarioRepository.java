package cu.registro_civil.web.repository;

import cu.registro_civil.web.model.Nacimiento;
import cu.registro_civil.web.model.Solicitud;
import cu.registro_civil.web.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "listado", path = "usuario")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>{
    
//    /*Metodo para buscar en el servidor los materiales en la pantalla pcpal y mostrar los resultados en el paginador*/
//    @Query(value = "SELECT m FROM NomProSemi m WHERE LOWER(m.descr) LIKE %?1% OR LOWER(m.cod) LIKE %?1%")
//    Page<Nacimiento> SearchProdSemi(@Param("text") String text, Pageable pageable);
//
//    @Query("SELECT cat FROM NomProSemi cat order by cat.id")
//    Page<NomProSemi> listAllProdSemi(Pageable pageable);
    
}


