<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<head>
<link rel="stylesheet" href="dashprofessionnelCss.css">
<script src="https://kit.fontawesome.com/45e38e596f.js"
	crossorigin="anonymous"></script>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>

</head>
<html>
<body>
	<div class="area">


		<div class="container con1">
			<p>Bienvenu(e), Asmahan</p>

		</div>
		<hr>
		<center>
			<div class="container con3">
				<form action="#" method="post">
					<input type="text" name="besoinChercher"
						placeholder="Ex:Site web, plombier..."> <input type="text"
						name="categorieService" placeholder="catégorie"> <input
						type="text" name="villeClient" placeholder="ville">


					<button type="submit" class="btn btn-primary">Rechercher</button>
				</form>

			</div>
		</center>

		<div class="caards">
			<h3>
				<b>La liste des besoins</b>
			</h3>
				<div class="row row-cols-1 row-cols-md-4 g-4">
							<c:forEach items="${ listBesoins }" var="listebesoin" varStatus="boucle">
				
					<div class="col">
						<div class="card">
							<img src="icon-user.svg" class="card-img-top" alt="..."
								class="imaage" height="135px">
							<div class="card-body">
								<h5 class="card-title titrecard">
									<c:out value="${listebesoin.getTitreBesoin()}" />
								</h5>
								<p class="categorie">

									catégorie : <span> gghghf</span>
								</p>
								<p class="card-text">
									<c:out value="${listebesoin.getDescription()}" />
								</p>
								<p>
									<i class="Fa fa-solid fa-map-pin"></i><span><c:out
											value="${listebesoin.getVille()}" /></span>
								</p>

							</div>
						</div>
					</div>
								</c:forEach>
					
				</div>
		</div>
	</div>


	<nav class="main-menu">
		<ul>
			<li><a href="http://justinfarrow.com"> <i
					class="fa fa-home fa-2x"></i> <span class="nav-text">
						Dashboard </span>
			</a></li>
			<li class="has-subnav"><a href="#"> <i
					class="fa fa-solid fa-user"></i> <span class="nav-text"> Mon
						profil </span>
			</a></li>
			<li class="has-subnav"><a href="#"> <i
					class="fa fa-folder-open fa-2x"></i> <span class="nav-text">
						Mon Cv </span>
			</a></li>
			<li class="has-subnav"><a href="contProf?act=afficherServices"> <i
					class="fa fa-list fa-2x"></i> <span class="nav-text"> Mes
						services </span>
			</a></li>

			<li><a href="#"> <i class="fa fa-bar-chart-o fa-2x"></i> <span
					class="nav-text"> Graphs and Statistics </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-font fa-2x"></i> <span
					class="nav-text"> Quotes </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-table fa-2x"></i> <span
					class="nav-text"> Tables </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-map-marker fa-2x"></i> <span
					class="nav-text"> Maps </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-info fa-2x"></i> <span
					class="nav-text"> Documentation </span>
			</a></li>
		</ul>

		<ul class="logout">
			<li><a href="#"> <i class="fa fa-power-off fa-2x"></i> <span
					class="nav-text"> Se déconnecter </span>
			</a></li>
		</ul>
	</nav>

</body>
</html>