<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminDashboard</title>
<link href="style.css" rel="stylesheet">
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

.search {
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 50px;
	width: 65%;
	padding: 15px;
	display: flex;
	justify-content: space-around;
	align-items: center;
}

.search div {
	display: inline-block;
}

div>a {
	margin-left: 2px;
	margin-right: 2px;
	margin-top: 0;
	margin-bottom: 0;
}

.cartesFlex {
	margin: auto;
	width: 70%;
	padding: 20px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
	align-items: center;
}

.card {
	margin-top: 10px;
	margin-bottom: 10px;
}

form>div {
	margin: 10px;
}

.font {
	font-size: 2rem;
	font-family: 'Russo One', sans-serif;
}

.rating>input {
	display: none;
}

.rating  .la1 {
	position: relative;
	width: 1em;
	font-size: 1.4vw;
	color: #FFD601;
	cursor: pointer;
}

span {
	content: "\2606";
	width: 2em;
	font-size: 1.4vw;
	color: #FFD601;
}

.flexBox {
	display: flex;
	justify-content: space-around;
	align-items: center;
	flex-wrap: wrap;
}

.p1 {
	margin: 1px;
}

#id1 {
	font-size: 1.2em;
}

td, th {
	text-align: center;
}
</style>


</head>
<body>

	<div class="navbar  shadow-sm">

		<div class="divIcon">
			<i class="bi bi-emoji-laughing" style="font-size: 2.5em;"> <a
				href="AdminDashbaord" class="font"> Bricoli Liya </a></i>

		</div>


		<div class="navdiv">

			<a href="#" class="btn btn-secondary">Achraf Guazir</a>

			<div style="display: inline-block;">
				<button class="btn btn-outline-primary dropdown-toggle"
					type="button" id="dropdownMenuButton" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Se déconnecter
				</button>
				<div class="dropdown-menu " aria-labelledby="hello">
					<a class="dropdown-item btn btn-outline-primary"
						href="AdminDashbaord?choice=clients">Gérer Clients</a> <a
						class="dropdown-item btn btn-outline-primary"
						href="AdminDashbaord?choice=professionnels">Gérer
						Professionnels</a> <a class="dropdown-item btn btn-outline-primary"
						href="AdminDashbaord?choice=gererPubs">Gérer publication</a> <a
						href="#" class="dropdown-item btn btn-outline-primary">Se
						déconnecter</a>

				</div>
			</div>
		</div>

	</div>



	<div class="container">
		<div class="table-responsive-sm">

			<table class="table table-light bordred table-hover">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Email</th>
						<th scope="col">Ville</th>
						<th scope="col">Adresse</th>
						<th scope="col">supprimer</th>


					</tr>
				</thead>
				<tbody>

					<c:if test="${choix == 'client1'}">
						<c:forEach items="${clients}" var="client">

							<tr>
								<td>${client.getNom()}</td>


								<td>${client.getPrenom()}</td>



								<td>${client.getEmail()}</td>



								<td>${client.getVille()}</td>



								<td>${client.getAdresse()}</td>





								<td>
									<form action="AdminDashboard?choice=delClient" method="POST">
										<input type="hidden" value="${client.getCin()}"
											name="cinClient">
										<button type="submit">
											<img alt="" src="AdminViews/images/icons/trash-fill.svg"
												width="25px" height="25px">
										</button>

									</form>
								</td>

							</tr>




						</c:forEach>
					</c:if>


					<c:if test="${choix == 'professionnel1'}">
=						<c:forEach items="${professionnels}" var="professionnel">

							<tr>
								<td>${professionnel.getNom()}</td>


								<td>${professionnel.getPrenom()}</td>



								<td>${professionnel.getEmail()}</td>



								<td>${professionnel.getVille()}</td>



								<td>${professionnel.getAdresse()}</td>





								<td>
									<form action="AdminDashboard?choice=delProf" method="POST">
										<input type="hidden" value="${professionnel.getCin()}"
											name="cinProf">

										<button>
											<img alt="" src="AdminViews/images/icons/trash-fill.svg"
												width="25px" height="25px">
										</button>
									</form>
								</td>
							</tr>




						</c:forEach>

					</c:if>


				</tbody>
			</table>

		</div>
	</div>