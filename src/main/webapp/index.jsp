<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Projeto Java</title>
<link rel="stylesheet" href="css/style.css">
<style>
* {
	margin: 0 auto;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Open Sans', sans-serif;
}

#menu-h {
	background-color: rgb(37, 37, 39);
}

#menu-h ul {
	max-width: 800px;
	list-style: none;
	padding: 0;
}

#menu-h ul li {
	display: inline;
}

#menu-h ul li a {
	color: #FFF;
	padding: 20px;
	display: inline-block;
	text-decoration: none;
	transition: background .4s;
}

#menu-h ul li a:hover {
	background-color: rgb(24, 139, 233);
}
/*
#menu-h ul li:last-child a {
    float: right;
    background-color: rgb(24, 139, 233);
}
*/
* {
	color: white;
	align-content: center;
}

h3 {
	color: #1598CB;
}

a:link {
	text-decoration: none;
}

.div0 {
	align-items: center;
	align-content: center;
	text-align: center;
	background: black;
	height: 200px;
	float: left;
	width: 99%;
	bottom: 0;
	position: absolute;
	margin: 0px;
}

.div1 {
	float: left;
	width: 32%;
	height: 100%;
	background: black;
}

.div2 {
	float: left;
	width: 33%;
	height: 100%;
	background: black;
}

.div3 {
	float: left;
	width: 33%;
	height: 100%;
	background: black;
}
</style>

</head>

<body>

	<nav id="menu-h">
		<ul>
			<li><a href="#">Home</a></li>

			<li><a href="#">Alunos</a></li>

			<li><a href="#">Professores</a></li>

			<li><a href="#">Disciplinas</a></li>

			<li><a href="#">Cursos</a></li>
		</ul>
	</nav>


	<footer>
		<div class="div0">
			<div class="div1">
				<ul class="footer-list-top" style="list-style-type: none;">
					<li>
						<h3 class="footer-list-header">Documentações Importantes</h3>
					</li>
					<li><a href="https://www.w3schools.com" target="_blank">w3c</a></li>
					<li><a href="https://www.oracle.com/br/index.html"
						target="_blank">Oracle</a></li>
					<li><a
						href="https://www.w3schools.com/css/tryit.asp?filename=trycss_layout_float3"
						target="_blank">Div float left</a></li>
				</ul>
			</div>
			<div class="div2">
				<ul class="footer-list-top" style="list-style-type: none;">
					<li>
						<h3 class="footer-list-header">Contatos</h3>
					</li>
					<li>Alexsandro</li>
					<li>Pedro</li>
					<li>Lucas</li>
					<li>Matheus</li>
					<li>Claytony</li>
					<li>Tony</li>
					<li>Eduardo</li>
					<li>Renato</li>
				</ul>
			</div>
			<div class="div3">
				<ul class="footer-list-top" style="list-style-type: none;">
					<li>
						<h3 class="footer-list-header">Redes Sociais</h3>
					</li>
					<li><a href="https://github.com/BT002" target="_blank">GitHub</a></li>
					<li><a href="https://www.youtube.com" target="_blank">YouTube</a></li>
					<li><a href="https://twitter.com" target="_blank">Twitter</a></li>
					<li><a href="https://www.facebook.com" target="_blank">Facebook</a></li>
					<li><a href="https://www.linkedin.com" target="_blank">Linkedin</a></li>
				</ul>
			</div>
		</div>
	</footer>

</body>

</html>