package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "Principal", urlPatterns = { "/Principal" })
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Principal() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	  response.sendRedirect("AlunoServlet");
	}

}
