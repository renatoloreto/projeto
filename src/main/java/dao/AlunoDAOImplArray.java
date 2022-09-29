package dao;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAOImplArray implements AlunoDAO {

    //Para armazenar os alunos vindos do banco de dados
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public void criarAluno(Aluno aluno) {
    	alunos.add(aluno);
    }

    @Override
    public ArrayList<Aluno> getTodosAlunos() {
        return alunos;
    }

	@Override
	public Aluno getAlunoPorRa(String ra) {
		for (Aluno aluno : alunos) {
			if(aluno.getRa().equals(ra)){
				return aluno;
			}
		}
		return null;
	}
    
	@Override
	public void atualizarAluno(Aluno aluno) {
    	for (Aluno al : alunos) {
			if(al.getRa().equals(aluno.getRa())) {
				al.setNome(aluno.getNome());
				al.setTelefone(aluno.getTelefone());
				al.setEndereco(aluno.getEndereco());
				al.setData_nascimento(aluno.getData_nascimento());
				break;
			}
		}
	}

    @Override
    public void deleteAluno(Aluno aluno) {
    	for (Aluno al : alunos) {
			if(al.getRa().equals(aluno.getRa())) {
				alunos.remove(al);
				break;
			}
		}
    }

	@Override
	public void deleteAluno(String ra) {
		
	}


}