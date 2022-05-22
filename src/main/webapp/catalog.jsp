<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory,
javax.xml.parsers.DocumentBuilder,org.w3c.dom.*"
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
    <title>La Dyoni cave</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="metier.Users" %>
    <%@ page import="xmlGenerator.generatorCatalogXml" %>
    <jsp:useBean id="user" type="metier.Users" scope="application" />
     <jsp:useBean id="catalog" type="java.util.HashMap" scope="application" />
   
</head>

<body>



    <nav class="menu">
        <div class ="home">Dyoni</div>
        <ul>
          <li><a href="index.jsp">Ma Cave</a></li>
          <li><a href="#lacom">La Communauté</a></li>
          <li><a href="#">La Dyoni Cave</a></li>
        </ul>
        <div class = "logged-user">
            <img src="https://media1.giphy.com/media/hryis7A55UXZNCUTNA/giphy.gif">
            <span class ="name-logged-user">${user.getName()} ${user.getSurname()} </span>
             </br>
             <span class ="name-logged-user"><a href="login.jsp">déconnexion</a> </span>
        </div>
        </div>
    </nav>

     
<div class="section-application">

    <h1>La Dyoni cave</h1>
    
    <% HashMap<String,List> AllBottles =  user.getAllBottleFromCatalog();%>
    
    <div class="cards-list wines">
	<% for(int i = 1; i<user.getTailleCave()  ; i+=1) { 
		String j = "b"+i; %>
		<p><%  List<String> a = (List<String>)AllBottles.get("b"+i); %></p>
		<%-- <p><% out.println(a.get(0));%></p> --%>
		
        <div class="card-wine 1">
            <div class="card_image">
                <img src="https://bordeaux-rive-droite.com/wp-content/uploads/2015/03/La-grave-2011-457x800.jpg" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p><% out.println(a.get(0));%></p>
                    </div>
                    <div class="castle">
                        <p><% out.println(a.get(1));%></p>
                    </div>
                    <div class="mill">
                        <p><% out.println(a.get(2));%></p>
                    </div>
                </div>
                <div class="card_description_minor">
                    <div class="region">
                        <p><% out.println(a.get(3));%></p>
                    </div>
                    <div class="color">
                        <p><% out.println(a.get(4));%></p>
                    </div>
                    <div class="alcool">
                        <p><% out.println(a.get(5));%> °C</p>
                    </div>
                    <div class="garde">
                        <p><% out.println(a.get(6));%> ans</p>
                    </div>
                    <div class="rating">
                        <p><% out.println(a.get(7));%>⭐</p>
                    </div>
                </div>
            </div>
        </div>
		<%} %>
      

        <div class="card-wine 3">
        
            <div class="card_image">
            
                <img src="https://medias.nicolas.com/media/sys_master/h88/h7f/9315255287838.png" />
            </div>
          
            <div class="card_description">
              <a href="bottleForm.jsp?pseudo=${user.getPseudo()">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p>Ajouter une bouteille</p>
                    </div>
                    
                </div>
                </a>
                </div>
  		     </div>
        </div>

  
    
</div>
    <div class="section-application" id="lacom">
    <h1>La communauté</h1>
    <div class="cards-list users">
        <div class="card-user 1">
            <div class="card_image">
                <img src="https://media2.giphy.com/media/3o752gZdDHjObx309W/giphy.gif?cid=ecf05e47qgbrp8c4mjhk2k7w0o8e10hxrurt0erxxqrp6rs1&rid=giphy.gif&ct=g" />
            </div>
            <div class="card_description">
               <div class="user_name">Cindy</div>
            </div>
        </div>
        <div class="card-user 2">
            <div class="card_image">
                <img src="https://i.imgflip.com/jhn4b.jpg" />
            </div>
            <div class="card_description">
               <div class="user_name">Barney</div>
            </div>
        </div>
    </div>
    </div>


</body>


</html>