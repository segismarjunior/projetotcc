/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Orientador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class OrientadorRepository {
    
    private final EntityManager manager;
    private DAO<Orientador> daoOrientador;

    public OrientadorRepository(EntityManager manager) {
        this.manager = manager;
        daoOrientador = new DAO<Orientador>(manager);
    }
    
    public Orientador buscaPor(Integer id) {
        return daoOrientador.buscaPorId(Orientador.class, id);
    }

    public List<Orientador> buscaPor(String nome) {
        return this.manager.createQuery("from Orientador " + "where upper(nome) like :nome", Orientador.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Orientador salvaOuAtualiza(Orientador orientador) {
        return daoOrientador.salvaOuAtualiza(orientador);
    }

    public void remove(Orientador orientador) {
        daoOrientador.remove(orientador);
    }
    
}
