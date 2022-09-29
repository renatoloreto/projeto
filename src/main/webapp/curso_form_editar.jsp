<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.CursoDAO"%>
<%@ page import="dao.CursoDAOImplMysql"%>
<%@ page import="model.Curso"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar curso</title>
</head>


<body>

	<h2>Editando dados do curso</h2>
	
	<%
		Curso curso = (Curso) request.getAttribute("cursoSelecionado");

	%>

	<form method="GET" action="CursoServlet" name="form1">
	  <input type="hidden" name="acao" value="update_aluno">
	  Código do Curso: 
	  <input type="text" name="cod_curso" value="<%=curso.getCod_curso() %>"><p>
	  Nome: 
	  <input type="text" name="nome" value="<%=curso.getNome() %>"><p>
	  Descrição: 
	  <input type="text" name="descricao" value="<%=curso.getDescricao() %>"><p>
	  Valor: 
	  <input type="text" name="valor" value="<%=curso.getValor() %>"><p>
	  Data de início: 
	  <input type="date" name="data_inicio" value="<%=curso.getData_inicio() %>"><p>
	  Data de fim: 
	  <input type="date" name="data_fim" value="<%=curso.getData_fim() %>"><p>
	  
	  <input type="submit" value="Salvar alterações">
	  <input type="button" value="Cancelar" onClick="history.go(-1)">
	</form> 

</body>
</html>