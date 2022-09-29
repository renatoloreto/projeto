package model;

import java.sql.Date;

public class Aluno {

	private String ra;
	private String nome;
	private String telefone;
	private String endereco;
	private Date data_nascimento;
	
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", data_nascimento=" + data_nascimento + "]";
	}

	public Aluno(String ra, String nome, String telefone, String endereco, Date data_nascimento) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.data_nascimento = data_nascimento;
	}

	public Aluno() {
		super();
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public java.sql.Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

}
