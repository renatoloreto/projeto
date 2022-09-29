package model;

import java.io.Serializable;
import java.util.ArrayList;

import dao.AlunoDAO;
import dao.AlunoDAOImplMysql;

public class AlunosBean implements Serializable{
	private static final long serialVersionUID = -1091168018987733369L;

	AlunoDAO alunoDAO;
	ArrayList<Aluno> alunos;
	Aluno alunoEdicao;

	public AlunosBean() {
		alunoDAO = new AlunoDAOImplMysql();
	}

	public Aluno buscarAlunoPorRa(String ra) {
		return alunoDAO.getAlunoPorRa(ra);
	}
	
	public ArrayList<Aluno> getAlunos() {
		AlunoDAO alunoDAO = new AlunoDAOImplMysql();
		return alunoDAO.getTodosAlunos();
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAlunoEdicao() {
		return alunoEdicao;
	}

	public void setAlunoEdicao(Aluno alunoEdicao) {
		this.alunoEdicao = alunoEdicao;
	}

}
