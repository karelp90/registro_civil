/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.projection;

import cu.registro_civil.web.model.Municipio;
import cu.registro_civil.web.model.OficinaRegistroCivil;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author admin
 */
@Projection(name = "oficinaRegistroCivilProjection", types = {OficinaRegistroCivil.class})
public interface OficinaRegistroCivilProjection {

    public Integer getId();

    public String getDescr();

  //  public Municipio getIdMunicipio();

}
