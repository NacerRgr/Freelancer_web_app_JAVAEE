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

<form action="controlleur?act=ajouterProf" method="post">
<label>CIN</label> <input type="text" name="cinP"><br>
<label>Nom</label> <input type="text" name="nomP" > <br>
<label>Prénom</label> <input type="text" name="prenomP"><br>
<label>Email</label> <input type="email" name="emailP"><br>

<label>Ville</label> <input type="text" name="villeP"><br>
<label>Adresse</label> <input type="text" name="adresseP"><br>
<label>Mot de passe</label> <input type="text" name="mdpP"><br>
<label>N° Téléphone</label> <input type="text" name="numTelP"><br>
<label>Sexe</label> <input type="text" name="sexeP"><br>
<label>Description</label> <input type="text" name="surMoiP"><br>
<label>Cv</label> <input type="text" name="CvP"><br>

 <input type="submit" name="submit" value="Ajouter">
<input type="reset" name="reset"  value="Annuler"><br>



</form>
</body>
</html>