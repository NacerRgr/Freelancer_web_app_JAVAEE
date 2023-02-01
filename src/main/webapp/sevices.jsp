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
<td>Titre</td>
<td>description</td>
<td>Prix</td>
<td>categorie</td>
<td>Modifier</td>
<td>Supprimer</td>

</tr>

<c:forEach items="${afficherService}" var="service" varStatus="boucle" >

			<tr>

				<td>${ service.getTitreS() }</td>
				<td>${ service.getDescription() }</td>
				<td>${ service.getPrix() }</td>
				<td>${ service.getCategorie() }</td>
				

				<td>
					<form action="contProf?act=ajouterService?&m=""
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
<p><button><a href="ajouterService.jsp">Ajouter</a></button></p>


</body>
</html>