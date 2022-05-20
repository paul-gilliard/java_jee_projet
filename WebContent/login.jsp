<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
<title>Connexion</title>
</head>
<body>
<%@include file="logo.jsp" %>
	<div class="section-application">
		<h1>Se connecter</h1>
		<form method="post" action="LoginCheck">
			<table>
				<tr>
					<td>Identifiant</td>
					<td><input type="text" name="username"></td>
					<td>Mot de passe</td>
					<td><input type="password" name="password"></td>
					<td><input type="submit" value="Connexion"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>