<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Professor"%>

<!DOCTYPE html>
<html>
<head>
	<title>Professores</title>
	
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

	<br><h3>Lista de Professores</h3>
	<hr>

	<a class="btn btn-success" href="<%=request.getContextPath()%>/ProfessorServlet?acao=exibir_formulario_cadastrar_professor"> Cadastrar novo professor(a) </a>
	<br>
	<table class="table table-hover text-nowrap">
		<thead>
			<tr>
				<th>CPF</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Conta Bancária</th>
				<th colspan="2" style="width:5%">Ações</th>
			</tr>
		</thead>
		<tbody>
		
			
			<%
				List<Professor> professores = (List) request.getAttribute("professores_todos");
				for (Professor professor : professores) {
			%>
			<tr>
				<td><%=professor.getCpf()%></td>
				<td><%=professor.getNome()%></td>
				<td><%=professor.getTelefone()%></td>
				<td><%=professor.getConta_bancaria()%></td>
				<td><a class="btn btn-warning" href="<%=request.getContextPath()%>/ProfessorServlet?acao=exibir_formulario_editar_professor&cpf=<%=professor.getCpf()%>">Editar</a></td>
				<td><a class="btn btn-dark" href="<%=request.getContextPath()%>/ProfessorServlet?acao=deletar_professor&cpf=<%=professor.getCpf()%>">Deletar</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

<%@ include file="rodape.jsp" %>

</body>
</html>