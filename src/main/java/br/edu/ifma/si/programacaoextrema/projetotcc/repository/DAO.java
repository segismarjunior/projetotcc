/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Entidade;
import java.util.Objects;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class DAO<T extends Entidade> {
    
    private final EntityManager manager;
    
    DAO(EntityManager manager) {
        this.manager = manager;
    }
    
    T buscaPorId(Class<T> cClass, Integer id) {
        return manager.find(cClass, id);
    }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
             this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
    
}
