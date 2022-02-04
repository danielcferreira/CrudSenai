package br.edu.senai.entidade;

public class Funcionario {
	
	private Integer idFuncionario;	
	private String nome;	
	private Double salario;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idFuncionario, String nome, Double salario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome
				+ ", salario=" + salario + "]";
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}		
}   