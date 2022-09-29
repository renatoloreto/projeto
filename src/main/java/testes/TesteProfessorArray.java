package testes;

import java.sql.Date;

import dao.ProfessorDAO;
import dao.ProfessorDAOImplArray;
import model.Professor;

public class TesteProfessorArray {

	public static void main(String[] args) {

		ProfessorDAO professorDAO = new ProfessorDAOImplArray();
		// C - Create Cadastrando alunos
		professorDAO.criarProfessor(new Professor("12345678900", "Carlos", "081 111", "12340"));
		professorDAO.criarProfessor(new Professor("12345678901", "Joaquim", "081 222", "12341"));
		professorDAO.criarProfessor(new Professor("12345678902", "José", "081 333", "12342"));
		professorDAO.criarProfessor(new Professor("12345678903", "Sílvio", "081 444", "12343"));
		professorDAO.criarProfessor(new Professor("12345678904", "Alberto", "081 345", "12344"));

		// R - Read Mostrando todos os professores
		for (Professor professor : professorDAO.getTodosProfessores()) {
			System.out.println(professor.toString());
		}

		// U - Update Atualizar nome Professor
		professorDAO.atualizarProfessor(new Professor("12345678900", "Gilberto", "081 555", "12345"));
		
		// Deletar professor
		Professor professor1 = new Professor("12345678904", null, null,  null);
		professorDAO.deleteProfessor(professor1);

		System.out.println("\n------- No final ficou assim ------------");
		for (Professor professor : professorDAO.getTodosProfessores()) {
			System.out.println(professor.toString());
		}

	}

}
