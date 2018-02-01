/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.EstadoSolicitud;
import cu.registro_civil.web.repository.EstadoSolicitudRepository;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author copy
 */
@Controller
public class EstadoSolicitudController {

    @Autowired
    EstadoSolicitudRepository repo;

    @RequestMapping(value = "/estados_solicitud", method = RequestMethod.GET)
    public String index(Model model, @SortDefault("orden") Pageable pageable) {
        model.addAttribute("page", repo.findAll(pageable));
        model.addAttribute("modelo", "estados");
        return "estado_solicitud/index";
    }

    @RequestMapping(value = "/estado_solicitud/new", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("estado", new EstadoSolicitud());
        model.addAttribute("modelo", "newEstado");
        return "estado_solicitud/form";
    }

    @RequestMapping("estado_solicitud/{id}")
    public String show(Model model, @PathVariable Integer id) {
        model.addAttribute("nacimiento", repo.findOne(id));
        return "estado_solicitud/show";
    }

    @RequestMapping(value = "/estado_solicitud/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("estado", repo.findOne(id));
        model.addAttribute("editar", true);
        return "estado_solicitud/form";
    }

    @RequestMapping(value = "/estado_solicitud", method = RequestMethod.POST)
    public String save(Model model, EstadoSolicitud estado) throws ParseException {
        try {
            repo.save(estado);
            model.addAttribute("notices", "Insertado Correctamente");
            return "redirect:/estados_solicitud";

        } catch (Exception e) {
            model.addAttribute("notices", "Se ha producido un error: " + e.getMessage());
            model.addAttribute("estado", estado);
            return "estado_solicitud/form";
        }
    }

    @RequestMapping(value = "/estado_solicitud/delete/{id}", method = RequestMethod.POST)
    public String delete(final RedirectAttributes redAtrib, @PathVariable Integer id, @PathVariable Integer page, @PathVariable String sort) {
        sort = sort.replace(" ", "");
        sort = sort.replace(":", ",");
        try {
            repo.delete(id);
        } catch (Exception e) {
            redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
        }

        return "redirect:/nacimiento?page=" + page + "&sort=" + sort;
    }
//    @RequestMapping(value = "/estado_solicitud/delete/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable Integer id) {
//        try {
//            repo.delete(id);
//        } catch (Exception e) {
//            System.err.println(e);
//            //redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
//        }
//        return "redirect:/nacimientos";
//    }

}
