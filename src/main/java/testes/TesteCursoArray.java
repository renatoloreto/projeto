package testes;

import java.sql.Date;

import dao.CursoDAO;
import dao.CursoDAOImplArray;
import model.Curso;

public class TesteCursoArray {

	public static void main(String[] args) {

		CursoDAO cursoDAO = new CursoDAOImplArray();
		// C - Create Cadastrando cursos
		cursoDAO.criarCurso(new Curso(1, "Matemática", "Curso de Matemática", 400,	Date.valueOf("2023-01-01"), Date.valueOf("2023-07-01")));
		cursoDAO.criarCurso(new Curso(2, "Português", "Curso de Português e Redação", 600, Date.valueOf("2023-02-01"), Date.valueOf("2023-08-01")));
		cursoDAO.criarCurso(new Curso(3, "Portugol", "Curso de Português Estruturado", 200, Date.valueOf("2023-03-01"), Date.valueOf("2023-05-01")));
		
		// R - Read Mostrando todos os cursos
		for (Curso curso : cursoDAO.getTodosCursos()) {
			System.out.println(curso.toString());
		}

		// U - Update Atualizar nome Curso
		cursoDAO.atualizarCurso(new Curso(2, "Português/Redação", "Curso de Português e Redação", 600, Date.valueOf("2023-02-02"), Date.valueOf("2023-08-01")));

		// Deletar curso
		Curso curso1 = new Curso(3, null, null,  0, null, null);
		cursoDAO.deleteCurso(curso1);

		System.out.println("\n------- No final ficou assim ------------");
		for (Curso curso : cursoDAO.getTodosCursos()) {
			System.out.println(curso.toString());
		}
	}
}