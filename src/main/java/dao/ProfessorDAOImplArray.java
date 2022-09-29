package dao;

import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorDAOImplArray implements ProfessorDAO {

    //Para armazenar os professores vindos do banco de dados
    private ArrayList<Professor> professores = new ArrayList<Professor>();

    @Override
    public void criarProfessor(Professor professor) {
    	professores.add(professor);
    }

    @Override
    public ArrayList<Professor> getTodosProfessores() {
        return professores;
    }

	@Override
	public Professor getProfessorPorCpf(String cpf) {
		for (Professor professor : professores) {
			if(professor.getCpf().equals(cpf)){
				return professor;
			}
		}
		return null;
	}
    
	@Override
	public void atualizarProfessor(Professor professor) {
    	for (Professor prof : professores) {
			if(prof.getCpf().equals(professor.getCpf())) {
				prof.setCpf(professor.getCpf());
				prof.setNome(professor.getNome());
				prof.setTelefone(professor.getTelefone());
				prof.setConta_bancaria(professor.getConta_bancaria());
				break;
			}
		}
	}

    @Override
    public void deleteProfessor(Professor professor) {
    	for (Professor prof : professores) {
			if(prof.getCpf().equals(professor.getCpf())) {
				professores.remove(prof);
				break;
			}
		}
    }

	@Override
	public void deleteProfessor(String cpf) {
		
	}


}
