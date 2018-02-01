/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.EstadoSolicitud;
import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.model.Nacimiento;
import cu.registro_civil.web.repository.HistorialEstadoSolicitudRepository;
import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class RastreadorController {

    @Autowired
    HistorialEstadoSolicitudRepository repoHistorial;

    @RequestMapping("rastreador_solicitudes")
    public String show(Model model) {
//        model.addAttribute("historialEstados", repoHistorial.historialDeEstadosPorSolicitud(id));
        return "rastreador/index";
    }

    @RequestMapping(value = "/rastrear_solicitud", method = RequestMethod.POST)
    public String rastrear(Model model, String cod) throws ParseException {       
        try {
            model.addAttribute("notices", "Insertado Correctamente");
            model.addAttribute("historial", repoHistorial.historialDeEstados(cod));
            model.addAttribute("cod", cod);
            return "rastreador/index";
            
        } catch (Exception e) {
            model.addAttribute("notices", "Se ha producido un error: " + e);
            //model.addAttribute("nacimiento", repo.findOne(id));
            // model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
            return "rastreador/index";
        }
    }

}
