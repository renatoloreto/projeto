<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.CursoDAO"%>
<%@ page import="dao.CursoDAOImplMysql"%>
<%@ page import="model.Curso"%>

<!DOCTYPE html>
<html>
<head>
	<title>Cursos</title>
	
	<style type="text/css">
		table {
			border-collapse: collapse;
			border-color: black;
		}
		
		th, td {
			padding: 0px 15px;
		}
	</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</head>

<body>

<%@ include file="cabecalho.jsp" %>

	<br><h3>Lista de Cursos</h3>
	<hr>

	<a class="btn btn-success" href="<%=request.getContextPath()%>/CursoServlet?acao=exibir_formulario_cadastrar_curso"> Cadastrar novo curso </a>
	<br>
	<table class="table table-hover text-nowrap">
		<thead>
			<tr>
				<th>Código do Curso</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Data de início</th>
				<th>Data de fim</th>
				<th colspan="2" style="width:5%">Ações</th>
			</tr>
		</thead>
		<tbody>
		
			
			<%
				List<Curso> cursos = (List) request.getAttribute("cursos_todos");
				for (Curso curso : cursos) {
			%>
			<tr>
				<td> <div style="text-align:center"> <%=curso.getCod_curso()%> </div></td>
				<td><%=curso.getNome()%></td>
				<td><%=curso.getDescricao()%></td>
				<td><%=curso.getValor()%></td>
				<td><%=curso.getData_inicio()%></td>
				<td><%=curso.getData_fim()%></td>
				<td><a class="btn btn-warning" href="<%=request.getContextPath()%>/CursoServlet?acao=exibir_formulario_editar_curso&cod_curso=<%=curso.getCod_curso()%>">Editar</a></td>
				<td><a class="btn btn-dark" href="<%=request.getContextPath()%>/CursoServlet?acao=deletar_curso&cod_curso=<%=curso.getCod_curso()%>">Deletar</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

<%@ include file="rodape.jsp" %>

</body>
</html>