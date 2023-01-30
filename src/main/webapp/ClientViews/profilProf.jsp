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

.td_center {
	vertical-align: middle;
}

.rate {
	float: left;
	height: 46px;
	padding: 0 10px;
}

.rate:not(:checked)>input {
	position: absolute;
	top: -9999px;
}

.rate:not(:checked)>label {
	float: right;
	width: 1em;
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 30px;
	color: #ccc;
}

.rate:not(:checked)>label:before {
	content: '★ ';
}

.rate>input:checked ~ label {
	color: #ffc700;
}

.rate:not(:checked)>label:hover, .rate:not(:checked)>label:hover ~ label
	{
	color: #deb217;
}

.rate>input:checked+label:hover, .rate>input:checked+label:hover ~ label,
	.rate>input:checked ~ label:hover, .rate>input:checked ~ label:hover ~
	label, .rate>label:hover ~ input:checked ~ label {
	color: #c59b08;
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







	<section>
		<div class="container py-5">


			<div class="row">
				<div class="col-lg-3">
					<div class="card mb-4">
						<div class="card-body text-center">
							<img src="ClientViews/assets/img.jpeg" alt="avatar"
								style="width: inherit; border-raduis: 15px;">
							<h5 class="my-3">${professionnel1.getNom()}
								${professionnel1.getPrenom()}</h5>
							<p class="text-muted mb-1">${professionnel1.getEmploie()}</p>
							<p class="text-muted mb-4">${professionnel1.getAdresse()}</p>
							<div class="d-flex justify-content-center mb-2">

								<form method="POST"
									action="ClientDashboardControll?choice=offrir">
									<input type="text" name="cinP"
										value="${professionnel1.getCin()}" hidden>
									<button class="m-2 btn btn-outline-primary" id="Employer"
										type="submit">Envoyer Offre</button>
								</form>



							</div>


							<div class="m-2">
								<span>&#9733;</span> <span>&#9733;</span> <span>&#9733;</span> <span>&#9733;</span>
								<span>&#9734;</span>
							</div>
						</div>
					</div>
					<div class="card mb-4 mb-lg-0">
						<div class="card-body p-4">
							<ul class="list-group list-group-flush rounded-3">
								<li
									class="list-group-item d-flex justify-content-between align-items-center p-3">
									<i class="bi bi-linkedin"></i>
									<p class="m-0">@${professionnel1.getNom()}_${professionnel1.getPrenom()}
									</p>
								</li>

							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-8">


					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">
										<b>Nom Complet</b>
									</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${professionnel1.getNom()}
										${professionnel1.getPrenom()}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">
										<b>Email</b>
									</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${professionnel1.getEmail()}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">
										<b>NumTél</b>
									</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${professionnel1.getNumTel()}</p>
								</div>
							</div>
							<hr>

							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">
										<b>Adresse</b>
									</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${professionnel1.getAdresse()}</p>
								</div>
							</div>
						</div>
					</div>




					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">
										<b>A propos de moi</b>
									</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${professionnel1.getSurMoi()}</p>
								</div>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card mb-4 mb-md-0">
								<div class="card-body">
									<p class="mb-4">
										<span class="text-primary font-italic me-1">Cv et
											Expériences</span>

									</p>

								</div>
							</div>

						</div>
					</div>


					<div class="row">
						<div class="col-md-12">
							<div class="card mb-4 mb-md-0">
								<div class="card-body">
									<p class="mb-4">
										<span class="text-primary font-italic me-1">Avis des
											clients</span>

									</p>

									<div style="width: inherit;">
										<div style="overflow-x: hidden; overflow-y: auto;">
											<table class="table">


												<c:forEach items="${Evaluation}" var="evaluation">
													 <c:if test = "${evaluation.getDescription() != ''}">
													<tr>

														<th scope="row" class="pic"><img alt=""
															src="ClientViews/assets/sssss.png" width="50px"></th>

														<td></td>
														<td></td>
														<td></td>
														<td></td>

														<td class="td_center">

															<p>${evaluation.getNom()}${evaluation.getPrenom()}</p>
														</td>

														<td></td>
														<td></td>
														<td></td>
														<td></td>

														<td class="td_center">


															<p>${evaluation.getDescription()}</p>

														</td>

														<td></td>
														<td></td>
														<td></td>
														<td></td>


														<td><div>
																<c:forEach var="i" begin="1"
																	end="${evaluation.getnbrEtoileProf()}" step="1">
																	<span>&#9733;</span>
																</c:forEach>
																<c:forEach var="i"
																	begin="${evaluation.getnbrEtoileProf()}" end="4"
																	step="1">
																	<span>&#9734;</span>
																</c:forEach>
															</div></td>



													</tr>
													</c:if>
												</c:forEach>

											</table>
										</div>

									</div>


								</div>
							</div>


							<div class="row">
								<div class="col-md-12">
									<div class="card mb-4 mb-md-0">
										<div class="card-body">
											<p class="mb-4">
												<span class="text-primary font-italic me-1">Donner
													votre avis</span>

											</p>

											<div class="w-100 justfy-content-center rounded "
												style="border: 3px solid grey">
												<form action="ClientDashboardControll?choice=noter"
																method="POST">

													<div class="rate">
														<input type="radio" id="star5" name="rate" value="5" /> <label
															for="star5" title="text">5 stars</label> <input
															type="radio" id="star4" name="rate" value="4" /> <label
															for="star4" title="text">4 stars</label> <input
															type="radio" id="star3" name="rate" value="3" /> <label
															for="star3" title="text">3 stars</label> <input
															type="radio" id="star2" name="rate" value="2" /> <label
															for="star2" title="text">2 stars</label> <input
															type="radio" id="star1" name="rate" value="1" /> <label
															for="star1" title="text">1 star</label>



													</div>
													<div class="mr-3">
														<textarea class="form-control ml-4" 
															placeholder="Ecrivez ici votre commentaire...."
															name="commentaire" required></textarea>
													</div>
													<div>

														<c:if test="${active == ''}">
															
																<input type="hidden" value="${progress.getCin()}"
																	name="cinPro">
																<button class="btn btn-secondary" type="submit">evaluer</button>
														
														</c:if>
														<c:if test="${active == 'disabled'}">
															<button class="btn btn-secondary" disabled>evaluer</button>

														</c:if>
													</div>
												</form>
											</div>
										</div>


									</div>
								</div>


							</div>
						</div>

					</div>
	</section>






</body>
</html>