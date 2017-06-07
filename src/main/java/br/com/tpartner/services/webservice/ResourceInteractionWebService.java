/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.services.webservice;

import br.com.tpartner.persistence.model.ResourceInteraction;
import br.com.tpartner.services.facade.ResourceInteractionFacade;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sergio
 */
@Controller
@RequestMapping("/resource_interaction")
public class ResourceInteractionWebService {
    @Autowired
    private ResourceInteractionFacade resourceInteractionFacade;
    public String serviceType = "ResourceInteraction Service";
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Serializable> save(@RequestBody ResourceInteraction resourceInteraction) {
        ResourceInteraction a = this.resourceInteractionFacade.save(resourceInteraction);
        return new ResponseEntity<Serializable>(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Serializable> update(@RequestBody ResourceInteraction resourceInteraction) {
        ResourceInteraction a = this.resourceInteractionFacade.update(resourceInteraction);
        return new ResponseEntity<Serializable>(a, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Serializable> delete(@RequestParam(value = "id", required = true) Integer id) {
        this.resourceInteractionFacade.delete(this.resourceInteractionFacade.findById(id));
        return new ResponseEntity<Serializable>(serviceType+": ResourceInteraction deleted",HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Serializable> findById(@RequestParam(value = "id", required = true) Integer id) {
        ResourceInteraction a = this.resourceInteractionFacade.findById(id);
        return new ResponseEntity<Serializable>(a,HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody List<ResourceInteraction> findAll() {
        return this.resourceInteractionFacade.findAll();
    }
}
