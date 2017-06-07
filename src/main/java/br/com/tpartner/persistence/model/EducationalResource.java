/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "educational_resource")
public class EducationalResource implements Serializable {
    @Id
    private final String id;
    
    public EducationalResource() {
        this.id = "0";
    }
    
    public EducationalResource(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
