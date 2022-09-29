<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.AlunoDAO"%>
<%@ page import="dao.AlunoDAOImplMysql"%>
<%@ page import="model.Aluno"%>

<!DOCTYPE html>
<html>
<head>
	<title>Alunos</title>
	
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

	<br><h3>Lista de Alunos</h3>
	<hr> 

	<a class="btn btn-success" href="<%=request.getContextPath()%>/AlunoServlet?acao=exibir_formulario_cadastrar_aluno"> Cadastrar novo aluno </a>
	<br>
	
 	<table class="table table-hover text-nowrap ">
		<thead>
			<tr>
				<th>RA</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Endereço</th>
				<th>Data de nascimento</th>
				<th colspan="2" style="width:5%">Ações</th>
			</tr>
		</thead>
		<tbody>
			
			<%
				List<Aluno> alunos = (List) request.getAttribute("alunos_todos");
				for (Aluno aluno : alunos) {
			%>
			<tr>
				<td><%=aluno.getRa()%></td>
				<td><%=aluno.getNome()%></td>
				<td><%=aluno.getTelefone()%></td>
				<td><%=aluno.getEndereco()%></td>
				<td><%=aluno.getData_nascimento()%></td>
				<td><a class="btn btn-warning" href="<%=request.getContextPath()%>/AlunoServlet?acao=exibir_formulario_editar_aluno&ra=<%=aluno.getRa()%>">Editar</a></td>
				<td><a class="btn btn-dark" href="<%=request.getContextPath()%>/AlunoServlet?acao=deletar_aluno&ra=<%=aluno.getRa()%> ">Deletar</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

<%@ include file="rodape.jsp" %>

</body>
</html>