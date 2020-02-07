/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author silas
 */
public class EMFactory {
    
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetotcc");
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    public void close() {
        factory.close();
    }
    
}
