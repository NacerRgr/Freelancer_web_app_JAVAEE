<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">




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
	height: 100px;
}

a {
	text-decoration: none;
}

.div1 {
	width: 45%;
	margin: auto
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



	<div class="shadow-lg p-4 mb-5 bg-white rounded div1">

		<span>
			<h4 class=" h4 text-center">
				<i class="bi bi-briefcase-fill"></i> modifier votre publication
			</h4>
		</span>
		<form action="ClientDashboardControll?choice=modifierOk" method="POST">
			<div class="mb-2">
				<label class="form-label">titre de besoin</label> <input type="text"
					class="form-control" name="titre" placeholder="cherche un plombier"
					value="${besoin.getTitre()}" required>
			</div>
			<div class="mb-2">
				<label class="form-label">catégorie</label> <input type="text"
					name="categorie" class="form-control" placeholder="plomberie ...."
					value="${besoin.getCategoirie()}" required>
			</div>
			<div class="mb-2">
				<label class="form-label">Montant</label> <input type="text"
					name="montant" class="form-control" placeholder="Ex 150DH ..."
					value="${besoin.getPrix()}" required>
			</div>
			<div class="mb-2">
				<label class="form-label">Description</label>
				<textarea class="form-control" rows="3" name="description"
					value="${besoin.getDescription()}"></textarea>
			</div>
			<div class="mb-2">
				<button class="btn btn-success w-20 " type="submit">Modifier</button>
			</div>
		</form>
</body>



</html>