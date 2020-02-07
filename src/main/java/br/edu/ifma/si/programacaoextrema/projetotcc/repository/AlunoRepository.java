/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.repository;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class AlunoRepository {
    
    private final EntityManager manager;
    private DAO<Aluno> daoAluno;

    public AlunoRepository(EntityManager manager) {
        this.manager = manager;
        daoAluno = new DAO<Aluno>(manager);
    }
    
    public Aluno buscaPor(Integer id) {
        return daoAluno.buscaPorId(Aluno.class, id);
    }

    public List<Aluno> buscaPor(String nome) {
        return this.manager.createQuery("from Aluno " + "where upper(nome) like :nome", Aluno.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Aluno salvaOuAtualiza(Aluno aluno) {
        return daoAluno.salvaOuAtualiza(aluno);
    }

    public void remove(Aluno aluno) {
        daoAluno.remove(aluno);
    }
    
}
