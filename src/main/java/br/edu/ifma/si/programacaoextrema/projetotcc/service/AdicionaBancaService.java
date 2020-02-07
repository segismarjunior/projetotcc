/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.service;

import br.edu.ifma.si.programacaoextrema.projetotcc.connection.EMFactory;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.Banca;
import br.edu.ifma.si.programacaoextrema.projetotcc.model.TCC;
import br.edu.ifma.si.programacaoextrema.projetotcc.repository.BancaRepository;
import br.edu.ifma.si.programacaoextrema.projetotcc.repository.TCCRepository;
import java.util.Objects;
import javax.persistence.EntityManager;

/**
 *
 * @author silas
 */
public class AdicionaBancaService {
    
    private final EntityManager manager;
    private final BancaRepository bancaRepository;
    private final TCCRepository tccRepository;

    public AdicionaBancaService() {
	this.manager = new EMFactory().getEntityManager();
	this.bancaRepository = new BancaRepository(manager);
        this.tccRepository = new TCCRepository(manager);
    }

    public Banca salva(Banca banca) throws BancaException {
        try {
            manager.getTransaction().begin();
            
            TCC tccExistente = tccRepository.buscaPor(banca.getTcc().getId());
                if (Objects.nonNull(tccExistente) && !Objects.equals(banca, tccExistente)) {
                    throw new BancaException("Já existe uma Banca com este TCC.");
		}
		Banca bancaSalva = bancaRepository.salvaOuAtualiza(banca);
                
                manager.getTransaction().commit();
		return bancaSalva;

            } catch(Exception e) {
                throw new RuntimeException(e );
        }
    }
    
}
