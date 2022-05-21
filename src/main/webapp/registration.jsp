<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
<title>Créer un compte</title>
</head>
<body>
	<x:user doc="users.xml" var="doc" scope="application" />
	<%@include file="logo.jsp"%>
	<div class="section-application">
		<h1>Créer un compte</h1>
		<form id="form" name="form" method="post" action="Registration">
			<table>
				<tr>
					<td><label for="title">Pseudo :</label>
					<input type="text"name="pseudo" id="pseudo"></td>

					<td><label for="name">Prénom :</label> 
					<input for="textarea" name="name" id="name"></td>

					<td><label for="surname">Nom :</label> 
					<input for="textarea" name="surname" id="surname"></td>

					<td><label for="alcool">Mot de passe :</label> 
					<input type="password" id="password" name="password"></td>

					<td><input type="submit" value="Créer un compte""></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>