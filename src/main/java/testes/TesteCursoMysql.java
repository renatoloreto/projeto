package testes;

import java.sql.Date;

import dao.CursoDAO;
import dao.CursoDAOImplMysql;
import model.Curso;

public class TesteCursoMysql {

    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAOImplMysql();
        
        // Cadastrando um curso
        Curso curso1 = new Curso(10, "Faísca", "Curso de Física", 500, Date.valueOf("2023-06-01"), Date.valueOf("2023-12-01"));
        cursoDAO.criarCurso(curso1);
        System.out.println("\nDados: " + curso1);
        System.out.println("Curso Salvo com sucesso!");
        System.out.println("");
        
        // Mostrando todos os cursos
        for (Curso curso : cursoDAO.getTodosCursos()) {
			System.out.println(curso.toString());
		}
        System.out.println("");
        
        //Atualizar nome Curso
        Curso curso2 = new Curso(10, "Física", "Curso de Física", 500, Date.valueOf("2023-06-01"), Date.valueOf("2023-12-01"));
        cursoDAO.atualizarCurso(curso2);
        for (Curso curso : cursoDAO.getTodosCursos()) {
			System.out.println(curso.toString());
		}
        System.out.println("Curso Atualizado com sucesso!");
        
        // Deletar curso
        Curso curso3 = new Curso(10, null, null, 0, null, null);
        cursoDAO.deleteCurso(curso3);
        System.out.println("\nDeletar Código do Curso: " + curso3.getCod_curso());
        System.out.println("Curso deletado com sucesso!");

        System.out.println("\n------- No final ficou assim ------------");
        for (Curso c1 : cursoDAO.getTodosCursos()) {
			System.out.println(c1.toString());
		}
    }
}