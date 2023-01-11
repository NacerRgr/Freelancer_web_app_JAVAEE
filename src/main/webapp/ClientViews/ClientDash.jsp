<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClientDash</title>
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
	width: 80%;
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
</style>


</head>
<body>

	<div class="navbar  shadow-sm">

		<div class="divIcon">
			<i class="bi bi-emoji-laughing" style="font-size: 2.5em;"> <a
				href="ClientDashboardControll" class="font"> Bricoli Liya </a></i>

		</div>


		<div class="navdiv">
			<a href="ClientViews/ajouterBesoin.jsp"
				class="btn btn-outline-primary">lister un besoin</a> <a
				href="ClientDashboardControll?choice=mesBesoins"
				class="btn btn-outline-primary">Mes Besoins</a> <a href="#"
				class="btn btn-secondary">Mohamed Nacer Erragragy</a> <a href="#"
				class="btn btn-primary">Se déconnecter</a>
		</div>
	</div>



	<div class="shadow-lg search bg-body rounded">

		<form action="">

			<div>

				<input class="form-control" placeholder="Ex siteWeb ..">

			</div>

			<div>

				<input class="form-control" placeholder="plombier..">

			</div>

			<div>

				<input class="form-control" placeholder="ville">

			</div>

			<div>

				<select class="form-select" aria-label="Default select example">
					<option selected>professionnel ou service</option>
					<option value="professionnel">Professionnel</option>
					<option value="service">Service</option>
				</select>
			</div>

			<div>

				<input class="btn btn-primary btn1" type="button" value="chercher">

			</div>



		</form>
	</div>


	<div class="cartesFlex shadow-lg bg-body rounded">


		<c:forEach items="${professionnels}" var="professionnel">



			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="ClientViews/assets/img.jpeg"
					width="100px" height="200px" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${professionnel.getNom()}
						${professionnel.getPrenom()}</h5>
					<p class="card-text">${professionnel.getSurMoi()}</p>
				</div>

				<div class="card-body">
					<a href="#" class="card-link">Employer</a> <a href="#"
						class="card-link">Another link</a>
				</div>
			</div>


		</c:forEach>

	</div>




</body>
</html>