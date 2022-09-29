package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;


public interface AlunoDAO {

	void criarAluno(Aluno aluno);       // C - Create
    ArrayList<Aluno> getTodosAlunos();  // R - Read
    Aluno getAlunoPorRa(String ra);     // R - Read
    void atualizarAluno(Aluno aluno);   // U - Update (atualizar)
    void deleteAluno(Aluno aluno);      // D - Delete
    void deleteAluno(String ra);        // D - Delete

}