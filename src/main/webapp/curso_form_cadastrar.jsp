<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.CursoDAO"%>
<%@ page import="dao.CursoDAOImplMysql"%>
<%@ page import="model.Curso"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastrar Curso</title>
</head>

<body>
<div style="text-align:center; font-size:110%"/div>
	<h2>Cadastrando novo Curso</h2>
	
		<form method="GET" action="CursoServlet" name="form1">
		  <input type="hidden" name="acao" value="insert_aluno">
		  Código do Curso: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="cod_curso"><p>
		  Nome: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="nome"><p>
		  Descrição: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="descricao"><p>
		  Valor: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="text" name="valor"><p>
		  Data de início: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="date" name="data_inicio"><p>
		  Data de fim: 
		  <input style="border-radius:2px 5px; box-shadow:2px 2px 3px" type="date" name="data_fim"><p>
		  
		  <input type="submit" value="Salvar alterações">
		  <input type="reset" value="Apagar campos">
		  <input type="button" value="Cancelar" onClick="history.go(-1)">
		</form> 

</body>
</html>