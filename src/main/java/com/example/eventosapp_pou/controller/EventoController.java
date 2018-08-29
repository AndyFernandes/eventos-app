package com.example.eventosapp_pou.controller;

import com.example.eventosapp_pou.model.Convidado;
import com.example.eventosapp_pou.model.Evento;
import com.example.eventosapp_pou.repository.ConvidadoRepository;
import com.example.eventosapp_pou.repository.EventoRepository;
import com.sun.tools.javac.util.List;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cv;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }
        er.save(evento);
        System.out.println(er.findAll());
        attributes.addFlashAttribute("mensagem", "Convidado adicionado!");
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento>  eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") String codigo){
        System.out.println(codigo);
        Evento evento =  er.findById(codigo).get();
//        Evento evento = new Evento("teste", "teste", "10/20/15", "teste" );
//        Evento evento1 = evento.get();db
        ModelAndView mv = new ModelAndView("detalhesEvento");
        mv.addObject("evento", evento);

        Iterable<Convidado> convidados = cv.findByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String formConvidado(@PathVariable("codigo") String codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{codigo}";
        }

        Evento evento = er.findById(codigo).get();
        convidado.setEvento(evento);
        cv.save(convidado);
        evento.addConvidado(convidado);
        System.out.println(("DEU BOM"));
        er.save(convidado.getEvento());
        attributes.addFlashAttribute("mensagem", "Convidado adicionado!");
        return "redirect:/{codigo}";
    }
}
