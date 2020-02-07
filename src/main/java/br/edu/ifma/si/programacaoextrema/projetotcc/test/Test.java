/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.test;

import br.edu.ifma.si.programacaoextrema.projetotcc.model.Aluno;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.Orientador;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author silas
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("br.edu.ifma.si.programacaoextrema_programacaoextrema_ptojetotcc_trabalhofinal_jar_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        
        Aluno aluno = new Aluno();
        aluno.setNome("Silas Nazare Chagas");
        aluno.setMatricula(1234);
        
        Professor professor1 = new Professor();
        professor1.setNome("Professor Mauro");
        professor1.setCodigo(123);
        
        Professor professor2 = new Professor();
        professor2.setNome("Professor Claudio");
        professor2.setCodigo(456);
        
        Orientador orientador = new Orientador();
        orientador.setNome("Professor Claudio");
        orientador.setCodOrientador(4560);
        orientador.setProfessor(professor2);
        
        manager.persist(aluno);
        manager.persist(professor1);
        manager.persist(professor2);
        manager.persist(orientador);
	transaction.commit();

	manager.close();
	factory.close();
    }
    
}
