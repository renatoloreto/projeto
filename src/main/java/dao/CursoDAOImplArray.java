package dao;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;

public class CursoDAOImplArray implements CursoDAO {
	
	//Para armazenar os cursos vindos do banco de dados
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    @Override
    public void criarCurso(Curso curso) {
    	cursos.add(curso);
    }

    @Override
    public ArrayList<Curso> getTodosCursos() {
        return cursos;
    }

	@Override
	public Curso getCursoPorCod(Integer cod_curso) {
		for (Curso curso : cursos) {
			if(curso.getCod_curso() == (cod_curso)){
				return curso;
			}
		}
		return null;
	}
    
	@Override
	public void atualizarCurso(Curso curso) {
    	for (Curso cur : cursos) {
			if(cur.getCod_curso() == (curso.getCod_curso())) {
				cur.setNome(curso.getNome());
				cur.setDescricao(curso.getDescricao());
				cur.setValor(curso.getValor());
				cur.setData_inicio(curso.getData_inicio());
				cur.setData_fim(curso.getData_fim());
				break;
			}
		}
	}

    @Override
    public void deleteCurso(Curso curso) {
    	for (Curso cur : cursos) {
			if(cur.getCod_curso() == (curso.getCod_curso())) {
				cursos.remove(cur);
				break;
			}
		}
    }

	@Override
	public void deleteCurso(Integer cod_curso) {
		
	}

}
