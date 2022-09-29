package model;

import java.sql.Date;

public class Curso {

	private int cod_curso;
	private String nome;
	private String descricao;
	private double valor;
	private Date data_inicio;
	private Date data_fim;

	@Override
	public String toString() {
		return "Cursos [cod_curso=" + cod_curso + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", data_inicio=" + data_inicio + ", data_fim=" + data_fim + "]";
	}

	public Curso(int cod_curso, String nome, String descricao, double valor, Date data_inicio, Date data_fim) {
		super();
		this.cod_curso = cod_curso;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public Curso() {
		super();
	}

	public int getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

}
