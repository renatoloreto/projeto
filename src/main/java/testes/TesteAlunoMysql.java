package testes;

import java.sql.Date;

import dao.AlunoDAO;
import dao.AlunoDAOImplMysql;
import model.Aluno;

public class TesteAlunoMysql {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAOImplMysql();
        
        // Cadastrando um aluno
        Aluno a1 = new Aluno("777", "Mira Arriba", "081 123", "Hasta La Vista", Date.valueOf("2002-02-02"));
        alunoDAO.criarAluno(a1);
        System.out.println("Aluno Salvo com sucesso!");
        
        // Mostrando todos os alunos
        for (Aluno aluno : alunoDAO.getTodosAlunos()) {
			System.out.println(aluno.toString());
		}
        
        //Atualizar nome Aluno
        Aluno a2 = new Aluno("777", "Mirandiba", "081 101", "Boa Vista", Date.valueOf("2002-02-02"));
        alunoDAO.atualizarAluno(a2);
        System.out.println("Aluno Atualizado com sucesso!");
        
        // Deletar aluno
        Aluno a3 = new Aluno("777", null, null, null, null);
        alunoDAO.deleteAluno(a3);

        System.out.println("------- No final ficou assim ------------");
        for (Aluno aluno1 : alunoDAO.getTodosAlunos()) {
			System.out.println(aluno1.toString());
		}
    }
}