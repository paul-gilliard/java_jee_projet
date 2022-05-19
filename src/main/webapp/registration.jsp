<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer un compte</title>
</head>
<body>
<x:user doc="users.xml" var="doc" scope="application"/>


	<form id ="form" name="form" method="link" action="Registration">
    <fieldset>
 
	 <tr>
		<td> <label for="title">Pseudo  :</label><br>
	    <input type="text" name="pseudo" id="pseudo"> <br>
	    </td>
	    
	    <td><label for="name">Prénom :</label>
    <input for="textarea" name="name" id="name"><br> </td>
	    
	    <td><label for="surname">Nom :</label>
    <input for="textarea" name="surname" id="surname"><br> </td>
     

 		<td> 
		  <label for="alcool">Mot de passe:</label>
		  <input type="password" id ="password" name="password"><br>
		</td>
        
  		  

     <br>
    <input type="submit" value="Créer un compte" ">
    </tr>
    
</fieldset>
</form>

</body>
</html>