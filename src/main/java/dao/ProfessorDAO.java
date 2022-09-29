package dao;

import java.util.ArrayList;

import model.Professor;

public interface ProfessorDAO {
	
	void criarProfessor(Professor professor);       // C - Create
    ArrayList<Professor> getTodosProfessores();  // R - Read
    Professor getProfessorPorCpf(String cpf);     // R - Read
    void atualizarProfessor(Professor professor);   // U - Update (atualizar)
    void deleteProfessor(Professor professor);      // D - Delete
    void deleteProfessor(String cpf);        // D - Delete

}
