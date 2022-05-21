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
    <%@ page import="xmlGenerator.generatorCatalogXml" %>
    <jsp:useBean id="user" type="metier.Users" scope="request" />
     <jsp:useBean id="catalog" type="xmlGenerator.generatorCatalogXml" scope="request" />
   
</head>

<body>



    <nav class="menu">
        <div class ="home">Dyoni</div>
        <ul>
          <li><a href="?page=macave">Ma Cave</a></li>
          <li><a href="#lacom">La Communauté</a></li>
          <li><a href="#">La Dyoni Cave</a></li>
        </ul>
        <div class = "logged-user">
            <img src="https://media1.giphy.com/media/hryis7A55UXZNCUTNA/giphy.gif">
            <span class ="name-logged-user">${user.getName()} ${user.getSurname()} </span>
        </div>
    </nav>

    
    <h1>La Dyoni cave</h1>
    
    <div class="cards-list wines">
	<% for(int i = 0; i < user.getCave().getSize(); i+=1) { %>
        <div class="card-wine 1">
            <div class="card_image">
                <img src="https://bordeaux-rive-droite.com/wp-content/uploads/2015/03/La-grave-2011-457x800.jpg" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p>${user.getCave(i).getBottle_name()}</p>
                    </div>
                    <div class="castle">
                        <p>${user.getCave(i).getCastle()}</p>
                    </div>
                    <div class="mill">
                        <p>${user.getCave(i).getMill()}</p>
                    </div>
                </div>
                <div class="card_description_minor">
                    <div class="region">
                        <p>${user.getCave(i).getRegion()}</p>
                    </div>
                    <div class="color">
                        <p>${user.getCave(i).getColor()}</p>
                    </div>
                    <div class="alcool">
                        <p>${user.getCave(i).getAlcool()}</p>
                    </div>
                    <div class="garde">
                        <p>${user.getCave(i).getGarde()}</p>
                    </div>
                    <div class="rating">
                        <p>${user.getCave(i).getRating()}</p>
                    </div>
                </div>
            </div>
        </div>
		<%} %>
        <div class="card-wine 1">
            <div class="card_image">
                <img src="https://bordeaux-rive-droite.com/wp-content/uploads/2015/03/La-grave-2011-457x800.jpg" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p>${cave.getCave(i).getBottle_name()}</p>
                    </div>
                    <div class="castle">
                        <p>${cave.getCave(i).getCastle()}</p>
                    </div>
                    <div class="mill">
                        <p>${cave.getCave(i).getMill()}</p>
                    </div>
                </div>
                <div class="card_description_minor">
                    <div class="region">
                        <p>${cave.getCave(i).getRegion()}</p>
                    </div>
                    <div class="color">
                        <p>${cave.getCave(i).getColor()}</p>
                    </div>
                    <div class="alcool">
                        <p>${cave.getCave(i).getAlcool()}</p>
                    </div>
                    <div class="garde">
                        <p>${cave.getCave(i).getGarde()}</p>
                    </div>
                    <div class="rating">
                        <p>${cave.getCave(i).getRating()}</p>
                    </div>
                </div>
            </div>
        </div>
		
        <div class="card-wine 2">
            <div class="card_image">
                <img
                    src="https://static.cavissima.com/pub/media/catalog/product/cache/21d5b20501320b0a15de21a395cff332/c/h/chateau-d-yquem-sauternes-blancdor_bouteille_17_1_2.png" />
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

        <div class="card-wine 3">
            <div class="card_image">
                <img src="https://medias.nicolas.com/media/sys_master/h88/h7f/9315255287838.png" />
            </div>
            <div class="card_description">
                <div class="card_description_major">
                    <div class="bottle_name">
                        <p>Ajouter une bouteille</p>
                    </div>
                    
                </div>
                <div class="card_description_minor">
                    
                    <div class="button__holder">
    				<button class="plus"><a href="bottleForm.jsp"></a></button>
					</div>
                     
    
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