<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.ProfessorDAO"%>
<%@ page import="dao.ProfessorDAOImplMysql"%>
<%@ page import="model.Professor"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar professor(a)</title>
</head>


<body>

	<h2>Editando dados do professor(a)</h2>
	
	<%
		Professor professor = (Professor) request.getAttribute("professorSelecionado");

	%>

	<form method="GET" action="ProfessorServlet" name="form1">
	  <input type="hidden" name="acao" value="update_professor">
	  CPF: 
	  <input type="text" name="cpf" value="<%=professor.getCpf() %>"><p>
	  Nome: 
	  <input type="text" name="nome" value="<%=professor.getNome() %>"><p>
	  Telefone: 
	  <input type="text" name="telefone" value="<%=professor.getTelefone() %>"><p>
	  Conta Bancária: 
	  <input type="text" name="conta_bancaria" value="<%=professor.getConta_bancaria() %>"><p>
	 	  
	  <input type="submit" value="Salvar alterações">
	  <input type="button" value="Cancelar" onClick="history.go(-1)">
	</form> 

</body>
</html>