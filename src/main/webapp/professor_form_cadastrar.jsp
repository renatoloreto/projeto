<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.ProfessorDAO"%>
<%@ page import="dao.ProfessorDAOImplMysql"%>
<%@ page import="model.Professor"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastrar Professor(a)</title>
</head>

<body>
<div style="text-align:center; font-size:110%"/div>
	<h2>Cadastrando novo Professor(a)</h2>
	
		<form method="GET" action="ProfessorServlet" name="form1">
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="hidden" name="acao" value="insert_professor">
		  CPF: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="cpf" placeholder="Ex: 001.002.003-04"><p>
		  Nome: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="nome"><p>
		  Telefone: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="telefone" placeholder="Ex: (99) 99999-9999"><p>
		  Conta Bancária: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="conta_bancaria" placeholder="Ex: Ag. 0001 Cc. 0001-0"><p>
		  
		  <input type="submit" value="Salvar alterações">
		  <input type="reset" value="Apagar campos">
		  <input type="button" value="Cancelar" onClick="history.go(-1)">
		</form> 

</body>
</html>