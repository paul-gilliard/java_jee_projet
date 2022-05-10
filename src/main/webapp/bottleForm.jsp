<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id ="form" name="form" method="link" action="NewBottle">
    <fieldset>

	 <tr>
		<td> <label for="title">Nom  :</label><br>
	    <input type="text" name="bottle_name" id="bottle_name"> <br>
	    </td>
	    
	    <td><label for="castle">Château</label>
    <input for="textarea" name="castle" id="castle"><br> </td>
	    
	    <td><label for="title2">Millésime :</label>
    <input type="number" id="mill" name="mill" min="1995" max="2022"> <br>
     </td>
    
    	<td> 
	     <label for="region">Region :</label><br>
	    <select id="region" name="region">
	        <option value = "Alsace">Alsace</option>
	        <option value = "Bourgogne">Bourgogne</option>
	        <option value = "Beaujolais">Beaujolais</option>
	        <option value = "Savoie">Savoie</option>
	        <option value = "Rhone">Rhone</option>
	        <option value = "Province">Province</option>
	        <option value = "Corse">Corse</option>
	        <option value = "Bordeaux">Bordeaux</option>
	        <option value = "Languedoc">Languedoc</option>
	        <option value = "Loire">Loire</option>
	    </select><br>
    	</td>
    
     

    	<td> 
	    	<label for="color">Couleur :</label><br>
		    <input type="radio" name="color" id="color" value='Blanc'>
		    <label for='white'>Blanc</label><br>
		    <input type="radio" name="color" id="color" value='Rosé'>
		    <label for='rose'>Rosé</label><br>
		    <input type="radio" name="color" id="color" value='Rouge'>
		    <label for='red'>Rouge</label><br>
    	</td>

   

 		<td> 
		  <label for="alcool">Teneur en alcool :</label>
		  <input for="text" id ="alcool" name="alcool"><br>
		</td>
        
  		<td> 
	        <label for="garde">Niveau de garde :</label>
	        <input for="text" id="garde" name="garde">
            <br>
        </td>
        
        
	<td>
	    <label for="rating"> Note :</label><br>
	        <select id="rating" name="rating">
	            <option value = "1">1</option>
	            <option value = "2">2</option>
	            <option value = "3">3</option>
	            <option value = "4">4</option>
	            <option value = "5">5</option>
	     </select> <br>
     </td>
    

     <br>
    <input type="submit" value="Ajouter" ">
    </tr>
    
</fieldset>
</form>

</body>
</html>