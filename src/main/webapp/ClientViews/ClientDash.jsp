<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	background-color: #0d6efd;
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
	margin-bottom: 20px;
	width: 45%;
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
	padding: 15px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
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
	color : #f8f9fa;
	
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
</style>


</head>
<body>

	<div class="navbar  shadow-sm">

		<div class="divIcon">
			<i class=" bi-emoji-wink-fill" style="font-size: 2.5em; color:#fff"> <a
				href="ClientDashboardControll" class="font"> Bricoli Liya </a></i>

		</div>


		<div class="navdiv">

			<a href="#" class="btn btn-secondary">${  sessionScope.client.getNom() }</a>

			<div style="display: inline-block;">
				<button class="btn btn-outline-light dropdown-toggle"
					type="button" id="dropdownMenuButton" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Se déconnecter
				</button>
				<div class="dropdown-menu " aria-labelledby="hello">
					<a class="dropdown-item btn btn-outline-light"
						href="ClientViews/ajouterBesoin.jsp">lister un besoin</a> <a
						class="dropdown-item btn btn-outline-light"
						href="ClientDashboardControll?choice=mesBesoins">Mes Besoins</a> <a
						class="dropdown-item btn btn-outline-light"
						href="ClientDashboardControll?choice=mesInvitaitons">Mes
						invitations envoyées</a> <a
						class="dropdown-item btn btn-outline-light"
						href="ClientDashboardControll?choice=mesDemandes">Demande
						d'Emploies</a> <a class="dropdown-item btn btn-outline-light"
						href="ClientDashboardControll?choice=mesProfessionnels">Mes
						Professionnels</a> <a href="#"
						class="dropdown-item btn btn-outline-light">Se déconnecter</a>

				</div>
			</div>
		</div>

	</div>






	<div class="shadow-sm search bg-body rounded">

		<form action="ClientDashboardControll" method="GET">

			<div>


				<select name="descr" class="form-select">
					<option value="Taza">1 an d'éxpérience</option>
					<option value="Tetouan">2 ans d'éxpérience</option>
					<option value="Tiznit">3 ans d'éxpérience</option>
				</select>

			</div>

			<div>

				<input class="form-control" type="text" placeholder="plombier.."
					name="emploie" required>

			</div>

			<div>

				<select name="ville" class="form-select">
					<option value="Agadir">Agadir</option>
					<option value="Al Hoceima">Al Hoceima</option>
					<option value="Azilal">Azilal</option>
					<option value="Beni Mellal">Beni Mellal</option>
					<option value="Ben Slimane">Ben Slimane</option>
					<option value="Boulemane">Boulemane</option>
					<option value="Casablanca">Casablanca</option>
					<option value="Chaouen">Chaouen</option>
					<option value="El Jadida">El Jadida</option>
					<option value="El Kelaa des Sraghna">El Kelaa des Sraghna</option>
					<option value="Er Rachidia">Er Rachidia</option>
					<option value="Essaouira">Essaouira</option>
					<option value="Fes">Fes</option>
					<option value="Figuig">Figuig</option>
					<option value="Guelmim">Guelmim</option>
					<option value="Ifrane">Ifrane</option>
					<option value="Kenitra">Kenitra</option>
					<option value="Khemisset">Khemisset</option>
					<option value="Khenifra">Khenifra</option>
					<option value="Khouribga">Khouribga</option>
					<option value="Laayoune">Laayoune</option>
					<option value="Larache">Larache</option>
					<option value="Marrakech">Marrakech</option>
					<option value="Meknes">Meknes</option>
					<option value="Nador">Nador</option>
					<option value="Ouarzazate">Ouarzazate</option>
					<option value="Oujda">Oujda</option>
					<option value="Rabat">Rabat-Sale</option>
					<option value="Safi">Safi</option>
					<option value="Settat">Settat</option>
					<option value="Sidi Kacem">Sidi Kacem</option>
					<option value="Tanger">Tanger</option>
					<option value="Tan-Tan">Tan-Tan</option>
					<option value="Taounate">Taounate</option>
					<option value="Taroudannt">Taroudannt</option>
					<option value="Tata">Tata</option>
					<option value="Taza">Taza</option>
					<option value="Tetouan">Tetouan</option>
					<option value="Tiznit">Tiznit</option>
				</select> <input type="text" value="chercher" name="choice" hidden>


			</div>



		

			<div>

				<button class="btn btn-primary btn1">chercher</button>

			</div>



		</form>
	</div>


	<div class="cartesFlex shadow-sm bg-body rounded">


		<c:forEach items="${professionnels}" var="professionnel">



			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="ClientViews/assets/img.jpeg"
					width="100px" height="200px" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${professionnel.getNom()}
						${professionnel.getPrenom()}</h5>
					<p class="p1" id="id1">${professionnel.getEmploie()}
					<p>
					



					<div>
						<p class="p1">
							<i class="bi bi-geo-alt-fill"></i> <i>${professionnel.getVille()}</i>
						</p>
					</div>

				</div>



				<div class="card-body flexBox">
					<form action="ClientDashboardControll?choice=profil" method="POST">
						<input name="cin" type="text" value="${professionnel.getCin()} "
							hidden>
						<button class="card-link btn btn-outline-primary">voir
							plus</button>
					</form>
					<div>
						<span>&#9733;</span> <span>&#9733;</span> <span>&#9733;</span> <span>&#9733;</span>
						<span>&#9734;</span>
					</div>




				</div>
			</div>


		</c:forEach>

	</div>




</body>
</html>