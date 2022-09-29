package testes;

import dao.ProfessorDAO;
import dao.ProfessorDAOImplMysql;
import model.Professor;

public class TesteProfessorMysql {

	public static void main(String[] args) {

		ProfessorDAO professorDAO = new ProfessorDAOImplMysql();

		// Cadastrando um professor
		Professor prof1 = new Professor("12345678900", "Sokratis", "081 321", "123488");
		professorDAO.criarProfessor(prof1);
		System.out.println("\nDados: " + prof1);
		System.out.println("Professor Salvo com sucesso!");
		System.out.println("");
		
		// Mostrando todos os professores
		for (Professor professor : professorDAO.getTodosProfessores()) {
			System.out.println(professor.toString());
		}
		System.out.println("");
		
		// Atualizar nome Professor
		Professor prof2 = new Professor("12345678900", "Sócrates", "081 321", "123488");
		professorDAO.atualizarProfessor(prof2);
		for (Professor professor : professorDAO.getTodosProfessores()) {
			System.out.println(professor.toString());
		}
		System.out.println("\nProfessor Atualizado com sucesso!");

		// Deletar professor
		Professor prof3 = new Professor("12345678900", null, null, null);
		professorDAO.deleteProfessor(prof3);
		System.out.println("Deletar CPF: " + prof3.getCpf());
		System.out.println("Professor deletado com sucesso!");

		System.out.println("\n------- No final ficou assim ------------");
		for (Professor professor1 : professorDAO.getTodosProfessores()) {
			System.out.println(professor1.toString());
		}
	}
}