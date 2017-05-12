/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.services.controller;

import br.com.tpartner.persistence.crud.AccessSessionCRUD;
import br.com.tpartner.persistence.model.AccessSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sergio
 */
public class AccessSessionController {
    @Autowired
    AccessSessionCRUD accessSessionCRUD;
    
    public AccessSession save(AccessSession accessSession) {
        return this.accessSessionCRUD.save(accessSession);
    }

    public AccessSession update(AccessSession accessSession) {
        return this.accessSessionCRUD.update(accessSession);
    }

    public void delete(AccessSession accessSession) {
        this.accessSessionCRUD.delete(accessSession);
    }

    public AccessSession findById(int accessSessionId) {
        return this.accessSessionCRUD.findById(accessSessionId);
    }

    public List<AccessSession> findAll() {
        return this.accessSessionCRUD.findAll();
    }
}