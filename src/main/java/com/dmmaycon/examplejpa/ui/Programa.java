package com.dmmaycon.examplejpa.ui;

import java.util.List;

import com.dmmaycon.examplejpa.models.Pessoa;
import com.dmmaycon.examplejpa.services.impl.PessoaService;
import com.dmmaycon.examplejpa.services.interfaces.CrudService;

public class Programa {

	public static void main(String[] args) {
		CrudService<Pessoa, Integer> pessoaService = new PessoaService();
		try {
			Pessoa p = new Pessoa();
			p.setNome("Pedro");
			p.setSobrenome("Augusto");
			p.setIdade(10);			
			pessoaService.insert(p);
			
			List<Pessoa> pessoas = pessoaService.all();
			pessoas.forEach(pessoa -> {
				System.out.println(String.format("Nome: %s \nSobrenome: %s \nIdade: %d", pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade()));				
			});
			if (pessoas.isEmpty()) {
				System.out.println("Não existem pessoas cadastradas.");
			}
			
			
		} catch (Exception e) {
			System.out.println("Erro ao utilizar a JPA: " + e.getMessage());
		}

	}

}
