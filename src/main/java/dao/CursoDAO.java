package dao;

import java.util.ArrayList;

import model.Curso;

public interface CursoDAO {
	
	void criarCurso(Curso curso);       // C - Create
    ArrayList<Curso> getTodosCursos();  // R - Read
    Curso getCursoPorCod(Integer cod_curso);     // R - Read
    void atualizarCurso(Curso curso);   // U - Update (atualizar)
    void deleteCurso(Curso curso);      // D - Delete
    void deleteCurso(Integer cod_curso);        // D - Delete

}
