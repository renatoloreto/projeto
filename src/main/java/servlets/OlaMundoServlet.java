package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns = { "/ola", "/hello"})
public class OlaMundoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private String message;

   
   // Inicializando o servlet
   public void init() throws ServletException {
      message = "Olá mundo!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1>Olá mundo!</h1>");
		printWriter.print("<p>Paragrafo 1</p>");
		printWriter.print("<p>Paragrafo 2</p>");
		printWriter.print("Próxima Linha<br>");
		printWriter.print("<a href=\"http://www.google.com\">Link para outra página </a>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();
      
   }
   
   // response.sendRedirect(request.getContextPath() + "/olamundo.jsp")

   public void destroy() {
	   message = "";
   }
}