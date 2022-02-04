package br.edu.senai.visao;

import java.util.ArrayList;
import java.util.List;

import br.edu.senai.persistencia.FuncionarioDao;

public class ManagerBean {
	
	private List lista;

	public List getLista() {
		
		try {			
			lista = new ArrayList<>();
			lista = new FuncionarioDao().findAll();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}	
} 