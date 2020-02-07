/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Professor;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class ProfessorRepository {
    
    private final EntityManager manager;
    private DAO<Professor> daoProfessor;

    public ProfessorRepository(EntityManager manager) {
        this.manager = manager;
        daoProfessor = new DAO<Professor>(manager);
    }
    
    public Professor buscaPor(Integer id) {
        return daoProfessor.buscaPorId(Professor.class, id);
    }

    public List<Professor> buscaPor(String nome) {
        return this.manager.createQuery("from Professor " + "where upper(nome) like :nome", Professor.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Professor salvaOuAtualiza(Professor professor) {
        return daoProfessor.salvaOuAtualiza(professor);
    }

    public void remove(Professor professor) {
        daoProfessor.remove(professor);
    }
    
}
