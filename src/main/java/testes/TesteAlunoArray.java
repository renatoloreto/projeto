package testes;

import java.sql.Date;

import dao.AlunoDAO;
import dao.AlunoDAOImplArray;
import model.Aluno;

public class TesteAlunoArray {

	public static void main(String[] args) {

		AlunoDAO alunoDAO = new AlunoDAOImplArray();
		// C - Create Cadastrando alunos
		alunoDAO.criarAluno(new Aluno("001", "Tonho", "081 111", "Rua do Alto",	Date.valueOf("2001-01-01")));
		alunoDAO.criarAluno(new Aluno("002", "Bil", "081 222", "Avenida Longa", Date.valueOf("2002-02-02")));
		alunoDAO.criarAluno(new Aluno("003", "Cumpade", "081 333", "BR 321", Date.valueOf("2003-03-03")));
		alunoDAO.criarAluno(new Aluno("004", "Zé", "081 444", "Beco Largo", Date.valueOf("2004-04-04")));
		alunoDAO.criarAluno(new Aluno("005", "Epaminondas", "081 345", "Rua Sobe e Desce", Date.valueOf("2005-01-05")));

		// R - Read Mostrando todos os alunos
		for (Aluno aluno : alunoDAO.getTodosAlunos()) {
			System.out.println(aluno.toString());
		}

		// U - Update Atualizar nome Aluno
		alunoDAO.atualizarAluno(new Aluno("005", "Gil", "081 555", "Rua Paralela", Date.valueOf("2005-05-05")));

		// Deletar aluno
		Aluno aluno1 = new Aluno("004", null, null,  null, null);
		alunoDAO.deleteAluno(aluno1);

		System.out.println("\n------- No final ficou assim ------------");
		for (Aluno aluno : alunoDAO.getTodosAlunos()) {
			System.out.println(aluno.toString());
		}
	}
}