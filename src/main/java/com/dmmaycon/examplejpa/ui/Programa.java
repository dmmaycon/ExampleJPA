package com.dmmaycon.examplejpa.ui;

import java.util.List;

import com.dmmaycon.examplejpa.models.Pessoa;
import com.dmmaycon.examplejpa.services.impl.PessoaService;
import com.dmmaycon.examplejpa.services.interfaces.CrudService;

public class Programa {

	public static void main(String[] args) {
		CrudService<Pessoa, Integer> pessoaService = new PessoaService();
		try {
			
			System.out.println("Inserindo");
			Pessoa p = new Pessoa();
			p.setNome("Pedro");
			p.setSobrenome("Augusto");
			p.setIdade(10);			
			pessoaService.insert(p);
			
			System.out.println("Alterando");
			Pessoa p2 = pessoaService.byId(1);
			p.setNome("Editou");
			p.setSobrenome("Nome");
			p.setIdade(100);			
			pessoaService.update(p);
			
			
			List<Pessoa> pessoas = pessoaService.all();
			pessoas.forEach(pessoa -> {
				System.out.println(String.format("Nome: %s \nSobrenome: %s \nIdade: %d", pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade()));				
			});
			if (pessoas.isEmpty()) {
				System.out.println("Não existem pessoas cadastradas.");
			}
			
			System.out.println("Excluindo");
			Pessoa p3 = pessoaService.byId(p.getId());		
			pessoaService.delete(p);
			
		} catch (Exception e) {
			System.out.println("Erro ao utilizar a JPA: " + e.getMessage());
		}

	}

}
