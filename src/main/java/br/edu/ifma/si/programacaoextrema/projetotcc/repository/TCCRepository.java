/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.TCC;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class TCCRepository {
    
    private final EntityManager manager;
    private DAO<TCC> daoTcc;

    public TCCRepository(EntityManager manager) {
        this.manager = manager;
        daoTcc = new DAO<TCC>(manager);
    }
    
    public TCC buscaPor(Integer id) {
        return daoTcc.buscaPorId(TCC.class, id);
    }

    public List<TCC> buscaPor(String nome) {
        return this.manager.createQuery("from TCC " + "where upper(nome) like :nome", TCC.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public TCC salvaOuAtualiza(TCC tcc) {
        return daoTcc.salvaOuAtualiza(tcc);
    }

    public void remove(TCC tcc) {
        daoTcc.remove(tcc);
    }
    
}
