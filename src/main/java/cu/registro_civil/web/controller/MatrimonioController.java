/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.controller;

import cu.registro_civil.web.model.Matrimonio;
import cu.registro_civil.web.repository.MatrimonioRepository;
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
public class MatrimonioController {

    @Autowired
    MatrimonioRepository repo;

    @RequestMapping(value = "/matrimonios", method = RequestMethod.GET)
    public String index(Model model, @SortDefault("id") Pageable pageable) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date); //2016/11/16 12:08:43
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date date2 = new Date();
        dateFormat2.format(date2); //2016/11/16 12:08:43

       /* 
       Nacimiento s = new Nacimiento();
        s.setNombresApellidos("Karel Perez Tase");
        s.setSurtirEfecto('E');
        s.setCantCertif(3);
        s.setCod("hy");
        s.setFechaSolicitud(new Date());
        s.setHoraSolicitud(new Date());
        s.setEstado("recibido");
        s.setEmail("karel@fre.co");
        s.setUrl("www.portalgr,.cu");
        s.setIdOficRegCivilARecoger(repoO.findOne(1));
        s.setIdOficRegCivilInscrito(repoO.findOne(1));        
        s.setTomoCi(432);
        s.setFolioCi(165);
        s.setFechaNacimiento(new Date());
       
        repo.save(s);
       */
        model.addAttribute("page", repo.findAll(pageable));
        model.addAttribute("modelo", "matrimonio");
        return "matrimonio/index";
    }

    @RequestMapping(value = "/matrimonio/new", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("matrimonio", new Matrimonio());
        return "matrimonio/form";
    }

    @RequestMapping(value = "/matrimonio/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Integer id) {
        model.addAttribute("matrimonio", repo.findOne(id));
        return "matrimonio/form";
    }

    @RequestMapping(value = "/matrimonio", method = RequestMethod.POST)
    public String save(Model model, Matrimonio matrimonio) {
        try {
            if (matrimonio.getId() != null) {
                repo.save(matrimonio);
                return "redirect:/provincia";
            }
            repo.save(matrimonio);
            model.addAttribute("notices", "Insertado Correctamente");
            model.addAttribute("matrimonio", new Matrimonio());
            return "matrimonio/form";
        } catch (Exception e) {
            model.addAttribute("notices", "Ya existe esa Descripcion");
//            Nacimiento nac = new Nacimiento();
//            nac.setDescripcion(matrimonio.getDescripcion());
//            model.addAttribute("cargo", c);
            return "matrimonio/form";
        }
    }

    @RequestMapping(value = "/matrimonio/{id}/{page}/{sort}", method = RequestMethod.DELETE)
    public String delete(final RedirectAttributes redAtrib, @PathVariable Integer id, @PathVariable Integer page, @PathVariable String sort) {
        sort = sort.replace(" ", "");
        sort = sort.replace(":", ",");
        try {
            repo.delete(id);
        } catch (Exception e) {
            redAtrib.addFlashAttribute("notices", "Hay datos que dependen de este Cargo");
        }

        return "redirect:/matrimonio?page=" + page + "&sort=" + sort;
    }
}
