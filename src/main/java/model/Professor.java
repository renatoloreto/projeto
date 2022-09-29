package model;

public class Professor {

	private String cpf;
	private String nome;
	private String telefone;
	private String conta_bancaria;

	@Override
	public String toString() {
		return "Professor [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", conta_bancaria="
				+ conta_bancaria + "]";
	}

	public Professor(String cpf, String nome, String telefone, String conta_bancaria) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.conta_bancaria = conta_bancaria;
	}

	public Professor() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getConta_bancaria() {
		return conta_bancaria;
	}

	public void setConta_bancaria(String conta_bancaria) {
		this.conta_bancaria = conta_bancaria;
	}

}
