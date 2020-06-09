package com.dmmaycon.examplejpa.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.dmmaycon.examplejpa.models.Pessoa;
import com.dmmaycon.examplejpa.services.interfaces.CrudService;
import com.dmmaycon.examplejpa.utils.JpaUtils;

public class PessoaService implements CrudService<Pessoa, Integer>{

	public List<Pessoa> all() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
			return pessoas;
		} finally {
			if (em != null) {
				em.close();
			}
		}				
	}

	public Pessoa byId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa insert(Pessoa entity) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin(); // mode edição
			em.persist(entity); // gravar o objeto
			em.getTransaction().commit(); // grava o objeto no banco
			return entity; // reflete as alterações do banco
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Pessoa update(Pessoa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Pessoa entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
