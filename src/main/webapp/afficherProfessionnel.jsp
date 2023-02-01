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

<table border="1">

<tr>
<td>CIN</td>
<td>Nom</td>
<td>Prénom</td>
<td>Email</td>
<td>Ville</td>
<td>Adresse</td>
<td>N° Téléphone</td>
<td>sexe</td>
<td>SurMoi</td>
<td>Cv</td>
<td>Modifier</td>
<td>Supprimer</td>
</tr>

<c:forEach items="${listeProfessionnel}" var="professionnel" varStatus="boucle" >

			<tr>

				<td>${ professionnel.getCin() }</td>
				<td>${ professionnel.getNom() }</td>
				<td>${ professionnel.getPrenom() }</td>
				<td>${ professionnel.getEmail() }</td>
				<td>${ professionnel.getVille() }</td>
				<td>${ professionnel.getAdresse() }</td>
				<td>${ professionnel.getNumTel() }</td>
				<td>${ professionnel.getSexe() }</td>
				<td>${ professionnel.getSurMoi() }</td>
				<td>${ professionnel.getCv() }</td>

				<td>
					<form action="controlleur?act=modifierProf?&m=${ professionnel.cin}&nom=${ professionnel.getNom() }
					&prenom=${ professionnel.getPrenom() }&email=${ professionnel.getEmail() }&ville=${ professionnel.getVille() }
					&adresse=${ professionnel.getAdresse() }&num=${ professionnel.getNumTel() }&sexe=${ professionnel.getSexe() }
					&surmoi=${ professionnel.getSurMoi() }
					&cv=${ professionnel.getCv() }&mdp=${ professionnel.getMotdepasse() }"
						method="POST">
						<input type="submit" name="modifier" value="modifier">
					</form>
				</td>

				<td>
					<form
						action="controlleur?act=supprimerProf&s=${ professionnel.cin }"
						method="post">
						<input type="submit" name="modifier" value="supprimer">
					</form>
				</td>

			</tr>
		</c:forEach>
					


</table>
<p><a href="ajouterProfessionnel.jsp">Ajouter</a></p>


</body>
</html>