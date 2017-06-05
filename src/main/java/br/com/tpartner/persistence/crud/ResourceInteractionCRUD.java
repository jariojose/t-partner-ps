/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.crud;

import br.com.tpartner.persistence.model.ResourceInteraction;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface ResourceInteractionCRUD {
    /* Client */
    public ResourceInteraction save(ResourceInteraction resourceInteraction);
    public ResourceInteraction update(ResourceInteraction resourceInteraction);
    public void delete(ResourceInteraction resourceInteraction);
    /* Aux */
    public ResourceInteraction findById(String resourceInteractionId);
    public List<ResourceInteraction> findAll();
}
