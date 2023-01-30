<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes demandes d'emploies</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Russo+One&display=swap"
	rel="stylesheet">


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>



<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<style type="text/css">
body {
	background-color: #E9F3F9;
	margin: 0;
	position: relative;
}

.navbar {
	background-color: #fff;
	display: flex;
	justify-content: space-around;
	margin-bottom: 30px;
	position: sticky;
	width: 100%;
	top: 0;
	z-index: 2;
}

a {
	text-decoration: none;
}

.dropdown-menu {
	z-index: 100;
}

.Container {
	width: 50%;
	margin: auto;
	padding: 0;
}

td {
	padding: 10px;
}

table {
	padding: 10px;
}

.pic {
	width: 150px;
}

.pic1 {
	width: 200px;
}

h5, h6, p {
	font-size: 1.05rem;
}

.font {
	font-size: 2rem;
	font-family: 'Russo One', sans-serif;
}
</style>

</head>
<body>


	<div class="navbar  shadow-sm">

		<div class="divIcon">
			<i class="bi bi-emoji-laughing" style="font-size: 2.5em;"> <a
				href="ClientDashboardControll" class="font"> Bricoli Liya </a></i>

		</div>


		<div class="navdiv">

			<a href="#" class="btn btn-secondary">Mohamed Nacer Erragragy</a>

			<div style="display: inline-block;">
				<button class="btn btn-outline-primary dropdown-toggle"
					type="button" id="dropdownMenuButton" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Se déconnecter
				</button>
				<div class="dropdown-menu " aria-labelledby="hello">
					<a class="dropdown-item btn btn-outline-primary"
						href="ClientViews/ajouterBesoin.jsp">lister un besoin</a> <a
						class="dropdown-item btn btn-outline-primary"
						href="ClientDashboardControll?choice=mesBesoins">Mes Besoins</a> <a
						class="dropdown-item btn btn-outline-primary"
						href="ClientDashboardControll?choice=mesInvitaitons">Mes
						invitations envoyées</a> <a
						class="dropdown-item btn btn-outline-primary" href="#">Demande
						d'Emploies</a> <a class="dropdown-item btn btn-outline-primary"
						href="#">Mes Professionnels</a> <a href="#"
						class="dropdown-item btn btn-outline-primary">Se déconnecter</a>

				</div>
			</div>
		</div>
	</div>

	<div class="Container shadow-lg  bg-white rounded">

		<table class="table table-striped">

			<c:forEach items="${mesDemandes}" var="demande">

				<tr>
					<th scope="row" class="pic"><img alt=""
						src="ClientViews/assets/sssss.png" width="120px"></th>
					<td class="">
						<h5>${demande.getNom()}</h5>
						<h6>${demande.getPrenom()}</h6>
						<h6>${demande.getEmploie()}</h6>
						<p>${demande.getSurMoi()}</p>
					</td>
					<td></td>

					<td>
						<form action="ClientDashboardControll?choice=AccepterInv"
							method="POST">
							<input type="hidden" name="idInvitationP"
								value="${demande.getCin()}">
							<button class="btn btn-outline-primary">Accepter</button>
						</form>
					</td>
					<td>
						<form action="ClientDashboardControll?choice=rejeterInv"
							method="POST">
							<input type="hidden" name="idInvitationP"
								value="${demande.getIdIntivtationP()}">
							<button class="btn btn-outline-danger">
								<img style="display: inline-block; margin-right: 5px;" alt=""
									src="ClientViews/assets/trash-fill.svg" width="20px">Rejeter
							</button>
						</form>

					</td>


				</tr>

			</c:forEach>

		</table>



	</div>




</body>
</html>