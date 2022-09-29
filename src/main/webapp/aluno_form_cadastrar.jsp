<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.AlunoDAO"%>
<%@ page import="dao.AlunoDAOImplMysql"%>
<%@ page import="model.Aluno"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastrar Aluno</title>
</head>

<body>
<div style="text-align:center; font-size:110%"/div>
	<h2>Cadastrando novo Aluno</h2>
	
		<form method="GET" action="AlunoServlet" name="form1">
		  <input type="hidden" name="acao" value="insert_aluno">
		  RA: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="number" name="ra"><p>
		  Nome: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="nome"><p>
		  Endereço: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="endereco" placeholder="Ex: Rua João, 100"><p>
		  Telefone: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="tel" name="telefone" placeholder="Ex: (99) 99999-9999"><p>
		  Data de Nascimento: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="date" name="data_nascimento"> 
		  
		  <br><br><input type="submit" value="Salvar alterações">
		  <input type="reset" value="Apagar campos">
		  <input type="button" value="Cancelar" onClick="history.go(-1)">
		  
		</form> 

</body>

</html>