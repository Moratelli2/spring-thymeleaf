package com.matera.blog.controller;

import com.matera.blog.model.Client;
import com.matera.blog.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/client");
        mv.addObject("clients", service.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Client client) {

        ModelAndView mv = new ModelAndView("/clientAdd");
        mv.addObject("client", client);

        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(service.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);

        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Client client, BindingResult result) {

        if (result.hasErrors()) {
            return add(client);
        }

        service.save(client);

        return findAll();
    }

}
