/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.crud;

import br.com.tpartner.persistence.model.GamingTheSystem;

/**
 *
 * @author sergio
 */
public interface GamingTheSystemCRUD
        extends GenericCRUD<GamingTheSystem, Integer> {
    public GamingTheSystem newGamingTheSystem();
}
