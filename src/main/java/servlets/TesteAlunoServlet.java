package servlets;

import java.io.*;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.AlunoDAO;
import dao.AlunoDAOImplMysql;
import model.Aluno;

@WebServlet(description = "AlunoServlet", urlPatterns = { "/TesteAlunoServlet" })
public class TesteAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlunoDAO alunoDAO;
	private static String CADASTRAR_ALUNOS = "alunos.jsp";
	private static String LISTAR_ALUNOS = "alunos.jsp";
	private static String ATUALIZAR_ALUNOS = "alunos.jsp";
	private static String DELETAR_ALUNOS = "alunos.jsp";

	// Inicializando o servlet
	public void init() throws ServletException {
		alunoDAO = new AlunoDAOImplMysql();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String forward = "";
		String opcao = request.getParameter("opcao");
		
		RequestDispatcher dispatcher = null;
		String ra, nome, telefone, endereco, data_nascimento = "";
	
		if (acao == null) {
			acao = "";
		}
		
		if (opcao == null) {
			opcao = "nome_aluno";
		}

		switch (acao) {
		case "exibir_formulario_cadastrar_aluno":
			dispatcher = request.getRequestDispatcher("aluno_form_cadastrar.jsp");
			dispatcher.forward(request, response);

			break;
		case "exibir_formulario_editar_aluno":
			ra = request.getParameter("ra");
			request.setAttribute("alunoSelecionado", alunoDAO.getAlunoPorRa(ra));
			dispatcher = request.getRequestDispatcher("aluno_form_editar.jsp");
			dispatcher.forward(request, response);

			break;
		case "insert_aluno": // C - Create
			ra = request.getParameter("ra");
			nome = request.getParameter("nome");
			telefone = request.getParameter("telefone");
			endereco = request.getParameter("endereco");
			data_nascimento = request.getParameter("data_nascimento");

			Aluno aluno1 = new Aluno(ra, nome, telefone, endereco, Date.valueOf(data_nascimento));
			alunoDAO.criarAluno(aluno1);
			
			request.setAttribute("alunos_todos", alunoDAO.getTodosAlunos());
			dispatcher = request.getRequestDispatcher("alunos.jsp");
			dispatcher.forward(request, response);

			break;
		case "update_aluno": // U - Update
			ra = request.getParameter("ra");
			nome = request.getParameter("nome");
			telefone = request.getParameter("telefone");
			endereco = request.getParameter("endereco");
			data_nascimento = request.getParameter("data_nascimento");

			Aluno aluno2 = new Aluno(ra, nome, telefone, endereco, Date.valueOf(data_nascimento));
			alunoDAO.atualizarAluno(aluno2);

			request.setAttribute("alunos_todos", alunoDAO.getTodosAlunos());
			dispatcher = request.getRequestDispatcher("alunos.jsp");
			dispatcher.forward(request, response);
			
			break;
		case "deletar_aluno": // D - Delete
			ra = request.getParameter("ra");
			alunoDAO.deleteAluno(ra);

			request.setAttribute("alunos_todos", alunoDAO.getTodosAlunos());
			dispatcher = request.getRequestDispatcher("alunos.jsp");
			dispatcher.forward(request, response);

			break;
		default: // R - Read
			request.setAttribute("alunos_todos", alunoDAO.getTodosAlunos());
			dispatcher = request.getRequestDispatcher("alunos.jsp");
			dispatcher.forward(request, response);

			break;
		}
		
		switch(opcao) {
		case "nome_aluno":
			nome = request.getParameter("nome");
			dispatcher = request.getRequestDispatcher("headerTeste.jsp");
			dispatcher.forward(request, response);
			break;
		case "endereco_aluno":
			endereco = request.getParameter("endereco");
			dispatcher = request.getRequestDispatcher("headerTeste.jsp");
			dispatcher.forward(request, response);
			break;
			}
	}

	public void destroy() {

	}
}