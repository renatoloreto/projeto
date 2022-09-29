package servlets;

import java.io.*;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.ProfessorDAO;
import dao.ProfessorDAOImplMysql;
import model.Professor;

@WebServlet(description = "ProfessorServlet", urlPatterns = { "/ProfessorServlet" })
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfessorDAO professorDAO;
	private static String CADASTRAR_PROFESSORES = "professores.jsp";
	private static String LISTAR_PROFESSORES = "professores.jsp";
	private static String ATUALIZAR_PROFESSORES = "professores.jsp";
	private static String DELETAR_PROFESSORES = "professores.jsp";

	// Inicializando o servlet
	public void init() throws ServletException {
		professorDAO = new ProfessorDAOImplMysql();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String forward = "";
		RequestDispatcher dispatcher = null;
		String cpf, nome, telefone, conta_bancaria = "";

		if (acao == null) {
			acao = "";
		}

		switch (acao) {
		case "exibir_formulario_cadastrar_professor":
			dispatcher = request.getRequestDispatcher("professor_form_cadastrar.jsp");
			dispatcher.forward(request, response);

			break;
		case "exibir_formulario_editar_professor":
			cpf = request.getParameter("cpf");
			request.setAttribute("professorSelecionado", professorDAO.getProfessorPorCpf(cpf));
			dispatcher = request.getRequestDispatcher("professor_form_editar.jsp");
			dispatcher.forward(request, response);

			break;
		case "insert_professor": // C - Create
			cpf = request.getParameter("cpf");
			nome = request.getParameter("nome");
			telefone = request.getParameter("telefone");
			conta_bancaria = request.getParameter("conta_bancaria");
			
			Professor professor1 = new Professor(cpf, nome, telefone, conta_bancaria);
			professorDAO.criarProfessor(professor1);
			
			request.setAttribute("professores_todos", professorDAO.getTodosProfessores());
			dispatcher = request.getRequestDispatcher("professores.jsp");
			dispatcher.forward(request, response);

			break;
		case "update_professor": // U - Update
			cpf = request.getParameter("cpf");
			nome = request.getParameter("nome");
			telefone = request.getParameter("telefone");
			conta_bancaria = request.getParameter("conta_bancaria");
			
			Professor professor2 = new Professor(cpf, nome, telefone, conta_bancaria);
			professorDAO.atualizarProfessor(professor2);

			request.setAttribute("professores_todos", professorDAO.getTodosProfessores());
			dispatcher = request.getRequestDispatcher("professores.jsp");
			dispatcher.forward(request, response);
			
			break;
		case "deletar_professor": // D - Delete
			cpf = request.getParameter("cpf");
			professorDAO.deleteProfessor(cpf);

			request.setAttribute("professores_todos", professorDAO.getTodosProfessores());
			dispatcher = request.getRequestDispatcher("professores.jsp");
			dispatcher.forward(request, response);

			break;
		default: // R - Read
			request.setAttribute("professores_todos", professorDAO.getTodosProfessores());
			dispatcher = request.getRequestDispatcher("professores.jsp");
			dispatcher.forward(request, response);

			break;
		}
	}

	public void destroy() {

	}
}