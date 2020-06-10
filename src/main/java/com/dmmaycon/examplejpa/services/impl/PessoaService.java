package com.dmmaycon.examplejpa.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

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
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			return em.find(Pessoa.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
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
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin(); // mode edição
			em.merge(entity); // gravar o objeto mergeado // roda duas consultas select + update
//			em.unwrap(Session.class).update(entity); // direto no hibernate só faz o update
			em.getTransaction().commit(); // grava o objeto no banco
			return entity; // reflete as alterações do banco
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void delete(Pessoa entity) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin(); // mode edição
			em.remove(entity); // remove o objeto 
			em.getTransaction().commit(); // remove o objeto no banco
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	public void deleteById(Integer id) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			Pessoa p = em.find(Pessoa.class, id);
			if (p != null) {
				em.getTransaction().begin(); // mode edição
				em.remove(p); // remove o objeto 
				em.getTransaction().commit(); // remove o objeto no banco
			}			
		} finally {
			if (em != null) {
				em.close();
			}
		}		
	}
	
}
