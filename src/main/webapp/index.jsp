<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory,
javax.xml.parsers.DocumentBuilder,org.w3c.dom.*"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue </title>
</head>
<body>
 <c:import var = "users" url="D:\\MIAGE\\M1 MIAGE\\S8\\Web\\projet\\Lisa.xml"/>
 
      <x:parse xml = "${users}" var = "output"/>

      <x:out select = "$output/users/user/pseudo" />
	<h1>Bienvenue <%out.println(request.getParameter("pseudo")); %><x:out select="$users/user/pseudo"/> </h1> 

</body>
</html>