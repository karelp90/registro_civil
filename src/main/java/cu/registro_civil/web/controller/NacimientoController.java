/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.EstadoSolicitud;
import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.model.Nacimiento;
import cu.registro_civil.web.repository.EstadoSolicitudRepository;
import cu.registro_civil.web.repository.HistorialEstadoSolicitudRepository;
import cu.registro_civil.web.repository.NacimientoRepository;
import cu.registro_civil.web.repository.OficinaRegistroCivilRepository;
import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author admin
 */
@Controller
public class NacimientoController {

    @Autowired
    NacimientoRepository repo;
    @Autowired
    EstadoSolicitudRepository repoEstados;
    @Autowired
    HistorialEstadoSolicitudRepository repoHistorial;
    @Autowired
    OficinaRegistroCivilRepository repoOfRegCivil;

    @RequestMapping(value = "/nacimientos", method = RequestMethod.GET)
    public String index(Model model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("page", repo.findAll(pageable));
        model.addAttribute("modelo", "nacimiento");
        return "nacimiento/index";
    }

    @RequestMapping(value = "/nacimiento/new", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("nacimiento", new Nacimiento());
        model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
        model.addAttribute("modelo", "newNacimiento");
        return "nacimiento/form";
    }

    @RequestMapping("nacimiento/{id}")
    public String show(Model model, @PathVariable Integer id) {
        model.addAttribute("nacimiento", repo.findOne(id));
        model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
        model.addAttribute("estados", repoEstados.findAll());
       model.addAttribute("estadoActual", repoHistorial.estadoActual(id));
        model.addAttribute("estadoInicial", repoHistorial.estadoInicial(id));
        model.addAttribute("estado_h", new HistorialEstadoSolicitud());
        model.addAttribute("historialEstados", repoHistorial.historialDeEstadosPorSolicitud(id));
        return "nacimiento/show";
    }

    @RequestMapping(value = "/nacimiento/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("nacimiento", repo.findOne(id));
        model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
        model.addAttribute("editar", true);
        return "nacimiento/form";
    }

    @RequestMapping(value = "/nacimiento", method = RequestMethod.POST)
    public String save(Model model, Nacimiento nacimiento) throws ParseException {
        try {
            Date fechaActual = new Date();
            EstadoSolicitud estadoInicial = repoEstados.estadoInicial();

            if (nacimiento.getId() == null) {
                nacimiento.setFechaSolicitud(fechaActual);
                nacimiento.generarCod();
                nacimiento.setEstado(estadoInicial.getDescr());
                repo.save(nacimiento);

                HistorialEstadoSolicitud estado = new HistorialEstadoSolicitud();
                estado.setFechaEstado(fechaActual);
                estado.setIdEstado(estadoInicial);
                estado.setIdSolicitud(nacimiento);
                repoHistorial.save(estado);
            } else {
                repo.save(nacimiento);
            }

            model.addAttribute("notices", "Insertado Correctamente");
            return "redirect:/nacimientos";

        } catch (Exception e) {
            model.addAttribute("notices", "Se ha producido un error: " + e);
            //model.addAttribute("nacimiento", repo.findOne(id));
            model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
            return "nacimiento/form";
        }
    }

//    @RequestMapping(value = "/nacimiento/{id}/{page}/{sort}", method = RequestMethod.DELETE)
//    public String delete(final RedirectAttributes redAtrib, @PathVariable Integer id, @PathVariable Integer page, @PathVariable String sort) {
//        sort = sort.replace(" ", "");
//        sort = sort.replace(":", ",");
//        try {
//            repo.delete(id);
//        } catch (Exception e) {
//            redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
//        }
//
//        return "redirect:/nacimiento?page=" + page + "&sort=" + sort;
//    }
    @RequestMapping(value = "/nacimiento/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        System.err.println(id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            System.err.println(e);
            //redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
        }
        return "redirect:/nacimientos";
    }
}
