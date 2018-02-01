/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.repository.SolicitudRepository;
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
 * @author admin
 */
@Controller
public class SolicitudController {

    @Autowired
    SolicitudRepository repo;

    @RequestMapping(value = "/solicitudes", method = RequestMethod.GET)
    public String index(Model model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("page", repo.findAll(pageable));
        model.addAttribute("modelo", "solicitud");
        return "solicitud/index";
    }

    /*@RequestMapping(value = "/solicitud/new", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("solicitud", new Nacimiento());
        return "solicitud/form";
    }

    @RequestMapping(value = "/solicitud/{id}/edit", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("solicitud", repo.findOne(id));
        return "solicitud/form";
    }

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public String save(Model model, Nacimiento solicitud) {
        try {
            if (solicitud.getIdSolicitud()!= null) {
                repo.save(solicitud);
                return "redirect:/provincia";
            }
            repo.save(solicitud);
            model.addAttribute("notices", "Insertado Correctamente");
            model.addAttribute("solicitud", new Nacimiento());
            return "solicitud/form";
        } catch (Exception e) {
            model.addAttribute("notices", "Ya existe esa Descripcion");
//            Nacimiento nac = new Nacimiento();
//            nac.setDescripcion(solicitud.getDescripcion());
//            model.addAttribute("cargo", c);
            return "solicitud/form";
        }
    }

    @RequestMapping(value = "/solicitud/{id}/{page}/{sort}", method = RequestMethod.DELETE)
    public String delete(final RedirectAttributes redAtrib, @PathVariable Long id, @PathVariable Integer page, @PathVariable String sort) {
        sort = sort.replace(" ", "");
        sort = sort.replace(":", ",");
        try {
            repo.delete(id);
        } catch (Exception e) {
            redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
        }

        return "redirect:/solicitud?page=" + page + "&sort=" + sort;
    }*/

}
