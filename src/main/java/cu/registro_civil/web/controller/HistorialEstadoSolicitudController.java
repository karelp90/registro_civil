/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.HistorialEstadoSolicitud;
import cu.registro_civil.web.model.Solicitud;
import cu.registro_civil.web.repository.HistorialEstadoSolicitudRepository;
import cu.registro_civil.web.repository.SolicitudRepository;
import cu.registro_civil.web.repository.UsuarioRepository;
import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
public class HistorialEstadoSolicitudController {

    @Autowired
    HistorialEstadoSolicitudRepository repo;
    @Autowired
    SolicitudRepository repoSolicitud;
    @Autowired
    UsuarioRepository repoU;

    //   @RequestMapping(value = "/estados_solicitud", method = RequestMethod.GET)
//    public String index(Model model, @SortDefault("id") Pageable pageable) {
//        model.addAttribute("page", repo.findAll(pageable));
//        model.addAttribute("modelo", "estados");
//        return "estado_solicitud/index";
//    }
//
//    @RequestMapping(value = "/estado_solicitud/new", method = RequestMethod.GET)
//    public String nuevo(Model model) {
//        model.addAttribute("estado", new EstadoSolicitud());
//        model.addAttribute("modelo", "newEstado");
//        return "estado_solicitud/form";
//    }
//
//    @RequestMapping("estado_solicitud/{id}")
//    public String show(Model model, @PathVariable Integer id) {
//        model.addAttribute("nacimiento", repo.findOne(id));
//        return "estado_solicitud/show";
//    }
//
    @ModelAttribute(value = "estado_h")
    public HistorialEstadoSolicitud construct() {
        return new HistorialEstadoSolicitud();
    }

    @ResponseBody
    @RequestMapping(value = "/historial_estado/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HistorialEstadoSolicitud edit(@PathVariable Integer id) {
        System.err.println(repo.findOne(id).getFechaEstado());
        return repo.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "historial_estado/update", method = RequestMethod.POST)
    public void update(@ModelAttribute("estado_h") HistorialEstadoSolicitud estado_h) {
        repo.save(estado_h);
    }

    @RequestMapping(value = "/historial_estados", method = RequestMethod.POST)
    public String save(Model model, HistorialEstadoSolicitud estadoAnterior) throws ParseException {
        try {
            Date fechaActual = new Date();
            Integer idSolicitud = estadoAnterior.getIdSolicitud().getId();

            HistorialEstadoSolicitud nuevoEstado = new HistorialEstadoSolicitud();
            nuevoEstado.setFechaEstado(fechaActual);
            nuevoEstado.setIdEstado(estadoAnterior.getIdEstado());
            nuevoEstado.setIdSolicitud(estadoAnterior.getIdSolicitud());
            nuevoEstado.setObserv(estadoAnterior.getObserv());

            repo.save(nuevoEstado);

            //Actualizando el ultimo estado de la solicitud, en la tabla solicitud
            Solicitud solicitud = repoSolicitud.findOne(idSolicitud);
            solicitud.setEstado(estadoAnterior.getIdEstado().getDescr());
            repoSolicitud.save(solicitud);

            model.addAttribute("notices", "Insertado Correctamente");
            return "redirect:/nacimiento/" + idSolicitud;

        } catch (Exception e) {
            System.err.println("Se ha producido un error: " + e);
            Integer idSolicitud = estadoAnterior.getIdSolicitud().getId();
            model.addAttribute("notices", "Se ha producido un error: " + e);
            model.addAttribute("estadoInicial", repo.findOne(estadoAnterior.getId()));
            return "redirect:/nacimiento/" + idSolicitud;
        }
    }
//    @RequestMapping(value = "/estado_solicitud/delete/{id}", method = RequestMethod.POST)
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
