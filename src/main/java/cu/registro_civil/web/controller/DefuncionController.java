/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.Defuncion;
import cu.registro_civil.web.repository.DefuncionRepository;
import cu.registro_civil.web.repository.OficinaRegistroCivilRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
public class DefuncionController {

    @Autowired
    DefuncionRepository repo;
    @Autowired
    OficinaRegistroCivilRepository repoOfRegCivil;

    @RequestMapping(value = "/defunciones", method = RequestMethod.GET)
    public String index(Model model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("page", repo.findAll(pageable));
        model.addAttribute("modelo", "defuncion");
        return "defuncion/index";
    }

    @RequestMapping(value = "/defuncion/new", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("defuncion", new Defuncion());
        model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
        model.addAttribute("modelo", "newDefuncion");
        return "defuncion/form";
    }

    @RequestMapping(value = "/defuncion/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("defuncion", repo.findOne(id));
        model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
        model.addAttribute("editar", true);
        return "defuncion/form";
    }

    @RequestMapping(value = "/defuncion", method = RequestMethod.POST)
    public String save(Model model, Defuncion defuncion) {
        try {
            if (defuncion.getId() == null) {
                defuncion.setFechaSolicitud(new Date());
                defuncion.generarCod();
                defuncion.setEstado("Enviado");
            }
            repo.save(defuncion);
            model.addAttribute("notices", "Insertado Correctamente");
            return "redirect:/defunciones";

        } catch (Exception e) {
            model.addAttribute("notices", "Se ha producido un error: " + e);
            //model.addAttribute("nacimiento", repo.findOne(id));
            model.addAttribute("oficinasRegCivil", repoOfRegCivil.findAll());
            return "defuncion/form";
        }
    }

    @RequestMapping(value = "/defuncion/{id}/{page}/{sort}", method = RequestMethod.DELETE)
    public String delete(final RedirectAttributes redAtrib, @PathVariable Integer id, @PathVariable Integer page, @PathVariable String sort) {
        sort = sort.replace(" ", "");
        sort = sort.replace(":", ",");
        try {
            repo.delete(id);
        } catch (Exception e) {
            redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
        }

        return "redirect:/defuncion?page=" + page + "&sort=" + sort;
    }
}
