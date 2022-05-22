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
    <title>Ma cave</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <%@ page import="metier.Users" %>
    <jsp:useBean id="user" type="metier.Users" scope="application" />
     <jsp:useBean id="catalog" type="java.util.HashMap" scope="application" />

   
</head>

<body>

<% HashMap<String,List> userBottles =  user.getBottles();%>


    <nav class="menu">
        <div class ="home">Dyoni</div>
        <ul>
          <li><a href="?page=macave">Ma Cave</a></li>
          <li><a href="#lacom">La Communauté</a></li>
          <li><a href="catalog.jsp" accesskey="1" title="">La Dyoni Cave</a></li>
        </ul>
        <div class = "logged-user">
            <img src="https://media1.giphy.com/media/hryis7A55UXZNCUTNA/giphy.gif">
            <span class ="name-logged-user">${user.getName()} ${user.getSurname()} </span>
            </br>
             <span class ="name-logged-user"><a href="login.jsp">déconnexion</a> </span>
        </div>
    </nav>

    
<div class="section-application">
    <h1>Ma cave</h1>
    <div class="cards-list wines">
<% out.println(userBottles.get("c4").get(0)); %>
<% out.println(user.getBottlesById(userBottles.get("c4").get(0).toString())); %>
 
      
        <div class="card-wine 2">
            <div class="card_image">
                <img
                    src="https://static.cavissima.com/pub/media/catalog/product/cache/21d5b20501320b0a15de21a395cff332/c/h/chateau-d-yquem-sauternes-blancdor_bouteille_17_1_2.png" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                    <% out.println(userBottles.get("b4")); %>
                        <p><%userBottles.get("b"+user.getId()); %></p>
                    </div>
                    <div class="castle">
                        <p>castle</p>
                    </div>
                    <div class="mill">
                        <p>mill</p>
                    </div>
                </div>
                <div class="card_description_minor">
                    <div class="region">
                        <p>region</p>
                    </div>
                    <div class="color">
                        <p>color</p>
                    </div>
                    <div class="alcool">
                        <p>alcool</p>
                    </div>
                    <div class="garde">
                        <p>garde</p>
                    </div>
                    <div class="rating">
                        <p>rating</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="card-wine 3">
        
            <div class="card_image">
                <img src="https://medias.nicolas.com/media/sys_master/h88/h7f/9315255287838.png" />
            </div>
            <div class="card_description">
            
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p><a href="bottleForm.jsp?pseudo=${user.getPseudo()}">Ajouter une bouteille</a></p>
                    </div>
                    
                </div>
                <div class="card_description_minor">
                    <!--  
                    <div class="button__holder">
    				<button class="plus"></button>
					</div>
					-->
                     
    
                </div>
            </div>
        </div>

        <div class="card-wine 4">
            <div class="card_image">
                <img src="https://onwine.pf/2234-large_default/porto-valdouro-tawny-19.jpg" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p>bottle_name</p>
                    </div>
                    <div class="castle">
                        <p>castle</p>
                    </div>
                    <div class="mill">
                        <p>mill</p>
                    </div>
                </div>
                <div class="card_description_minor">
                    <div class="region">
                        <p>region</p>
                    </div>
                    <div class="color">
                        <p>color</p>
                    </div>
                    <div class="alcool">
                        <p>alcool</p>
                    </div>
                    <div class="garde">
                        <p>garde</p>
                    </div>
                    <div class="rating">
                        <p>rating</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <div class="section-application">
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
    
