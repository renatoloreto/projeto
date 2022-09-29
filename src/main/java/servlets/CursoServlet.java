package servlets;

import java.io.*;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.CursoDAO;
import dao.CursoDAOImplMysql;
import model.Curso;

@WebServlet(description = "CursoServlet", urlPatterns = { "/CursoServlet" })
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CursoDAO cursoDAO;
	private static String CADASTRAR_CURSOS = "cursos.jsp";
	private static String LISTAR_CURSOS = "cursos.jsp";
	private static String ATUALIZAR_CURSOS = "cursos.jsp";
	private static String DELETAR_CURSOS = "cursos.jsp";

	// Inicializando o servlet
	public void init() throws ServletException {
		cursoDAO = new CursoDAOImplMysql();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String forward = "";
		RequestDispatcher dispatcher = null;
		int cod_curso = 0;
		String nome, descricao = "";
		double valor = 0;
		Date data_inicio, data_fim = null;

		if (acao == null) {
			acao = "";
		}

		switch (acao) {
		case "exibir_formulario_cadastrar_curso":
			dispatcher = request.getRequestDispatcher("curso_form_cadastrar.jsp");
			dispatcher.forward(request, response);

			break;
		case "exibir_formulario_editar_curso":
			cod_curso = Integer.parseInt(request.getParameter("cod_curso"));
			request.setAttribute("cursoSelecionado", cursoDAO.getCursoPorCod(cod_curso));
			dispatcher = request.getRequestDispatcher("curso_form_editar.jsp");
			dispatcher.forward(request, response);

			break;
		case "insert_curso": // C - Create
			cod_curso = Integer.parseInt(request.getParameter("cod_curso"));
			nome = request.getParameter("nome");
			descricao = request.getParameter("descricao");
			valor = Double.parseDouble(request.getParameter("valor"));
			data_inicio = Date.valueOf(request.getParameter("data_inicio"));
			data_fim = Date.valueOf(request.getParameter("data_fim"));

			Curso curso1 = new Curso(cod_curso, nome, descricao, valor, data_inicio, data_fim);
			cursoDAO.criarCurso(curso1);
			
			request.setAttribute("cursos_todos", cursoDAO.getTodosCursos());
			dispatcher = request.getRequestDispatcher("cursos.jsp");
			dispatcher.forward(request, response);

			break;
		case "update_curso": // U - Update
			cod_curso = Integer.parseInt(request.getParameter("cod_curso"));
			nome = request.getParameter("nome");
			descricao = request.getParameter("descricao");
			valor = Double.parseDouble(request.getParameter("valor"));
			data_inicio = Date.valueOf(request.getParameter("data_inicio"));
			data_fim = Date.valueOf(request.getParameter("data_fim"));

			Curso curso2 = new Curso(cod_curso, nome, descricao, valor, data_inicio, data_fim);
			cursoDAO.atualizarCurso(curso2);

			request.setAttribute("cursos_todos", cursoDAO.getTodosCursos());
			dispatcher = request.getRequestDispatcher("cursos.jsp");
			dispatcher.forward(request, response);
			
			break;
		case "deletar_curso": // D - Delete
			cod_curso = Integer.parseInt(request.getParameter("cod_curso"));
			cursoDAO.deleteCurso(cod_curso);

			request.setAttribute("cursos_todos", cursoDAO.getTodosCursos());
			dispatcher = request.getRequestDispatcher("cursos.jsp");
			dispatcher.forward(request, response);

			break;
		default: // R - Read
			request.setAttribute("cursos_todos", cursoDAO.getTodosCursos());
			dispatcher = request.getRequestDispatcher("cursos.jsp");
			dispatcher.forward(request, response);

			break;
		}
	}

	public void destroy() {

	}
}