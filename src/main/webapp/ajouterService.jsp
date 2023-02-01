<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="contProf?act=ajouterService" method="post">
<label>Titre de service</label> <input type="text" name="titreS"><br>
 <label for="service" >Categorie de services</label>

<select id="categorieS"  name="categorieS" >
  <option value="1" >informatique</option>
  <option value="2">cuisine</option>
  <option  value="3">economie</option>
  <option value="4" >etude</option>
</select> 
  <br>

  
<label>description</label> <input type="text" name="descriptionS"><br>
<label>prix</label> <input type="text" name="prixS"><br>


 <input type="submit" name="submit" value="Ajouter un service">
<input type="reset" name="reset"  value="Annuler"><br>



</form>
</body>
</html>