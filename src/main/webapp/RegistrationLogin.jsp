<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Acceuil</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>


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
	
	

<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function(){
	  document.getElementById("professionnel12").addEventListener("click", function(){
		  document.getElementById("professionnelEmploie").style.display = "block";
		});

		document.getElementById("profes").addEventListener("click", function(){
		  document.getElementById("professionnelEmploie").style.display = "none";
		});
	});
	
document.addEventListener("DOMContentLoaded", function(){
	  document.getElementById("professionnel12").addEventListener("click", function(){
		  document.getElementById("professionnelEmploie1").style.display = "block";
		});

		document.getElementById("profes").addEventListener("click", function(){
		  document.getElementById("professionnelEmploie1").style.display = "none";
		});
	});
	
	
document.addEventListener("DOMContentLoaded", function(){
	  let form = document.getElementById("myForm");
	  document.getElementById("inlineRadio1").addEventListener("click", function(){
	    form.action = "AuthControll?authenticate=admin";
	  });

	  document.getElementById("inlineRadio2").addEventListener("click", function(){
	    form.action = "AuthControll?authenticate=client";
	  });
	  
	  document.getElementById("inlineRadio3").addEventListener("click", function(){
	    form.action = "contProf?act=authentification";
	  });
	});

document.addEventListener("DOMContentLoaded", function(){
	  let form = document.getElementById("myForm2");
	  document.getElementById("profes").addEventListener("click", function(){
	    form.action = "AuthControll?authenticate=clientSignup";
	  });

	  document.getElementById("professionnel12").addEventListener("click", function(){
	    form.action = "AuthControll?authenticate=profSignup";
	  });
	  
	
	});


</script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Rubik+Vinyl&display=swap"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Russo+One&display=swap"
	rel="stylesheet">

<style>
body, html {
	margin: 0;
	height: 100%;
}

.card {
	width: 30%;
	border: none;
	height: auto;
}

.btr {
	border-top-right-radius: 5px !important;
}

.btl {
	border-top-left-radius: 5px !important;
}

.btn-dark {
	color: #fff;
	background-color: #0d6efd;
	border-color: #0d6efd;
}

.btn-dark:hover {
	color: #fff;
	background-color: #0d6efd;
	border-color: #0d6efd;
}

.nav-pills {
	display: table !important;
	width: 100%;
}

.nav-pills .nav-link {
	border-radius: 0px;
	border-bottom: 1px solid #0d6efd40;
}

.nav-item {
	display: table-cell;
	background: #0d6efd2e;
}

.form {
	padding: 10px;
	height: auto;
}

.form input {
	margin-bottom: 12px;
	border-radius: 3px;
}

.form input:focus {
	box-shadow: none;
}

.form button {
	margin-top: 20px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}

.bg {
	background-image: url("bg.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

</style>


</head>
<div class="d-flex justify-content-center align-items-center bg">


	<div class="card">

		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item text-center"><a class="nav-link active btl"
				id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
				aria-controls="pills-home" aria-selected="true">Connexion</a></li>
			<li class="nav-item text-center"><a class="nav-link btr"
				id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
				role="tab" aria-controls="pills-profile" aria-selected="false">Inscription</a>
			</li>

		</ul>
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-home"
				role="tabpanel" aria-labelledby="pills-home-tab">


				<div class="form px-4 pt-3">

					<form method="POST" action="" id="myForm">
					
					<div class="d-flex justify-content-center align-items-center"><img alt="" src="ClientViews/assets/sssss.png" width="100px"></div>

						<div class="d-flex justify-content-center align-items-center"
							style="margin-bottom: 15px; margin-top : 15px;">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="choixUtilisateur" id="inlineRadio1" value="admin">
								<label class="form-check-label" for="inlineRadio1" >Admin</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="choixUtilisateur" id="inlineRadio2" value="client">
								<label class="form-check-label" for="inlineRadio2" >Client</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="choixUtilisateur" id="inlineRadio3" value="professionnel">
								<label class="form-check-label" for="inlineRadio2" >Professionnel</label>
							</div>
						</div>
						<input type="email" name="login" class="form-control"
							placeholder="Email" required> <input type="password" name="pwd"
							class="form-control" placeholder="mot de passe" required>
						<button class="btn btn-dark btn-block">Se connecter</button>
					</form>
				</div>




			</div>
			<div class="tab-pane fade" id="pills-profile" role="tabpanel"
				aria-labelledby="pills-profile-tab">


				<div class="form px-4">

					<form method="POST" action="" id="myForm2">
					
					<div class="d-flex justify-content-center align-items-center"><img alt="" src="ClientViews/assets/sssss.png" width="100px"></div>
					
						<div class="d-flex justify-content-center align-items-center" style=" margin-top : 15px;">
						
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="choixUtilisateur1" id="profes" value="client">
								<label class="form-check-label" for="profes">Client</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="choixUtilisateur1" id="professionnel12" value="professionnel">
								<label class="form-check-label" for="professionnel12">Professionnel</label>
							</div>
						</div>

						<input type="text" name="cin" class="form-control"
							placeholder="cin"> <input type="text" name="nom"
							class="form-control" placeholder="nom"> <input
							type="text" name="prenom" class="form-control"
							placeholder="prenom"> 
							<input type="email" name="login"
							class="form-control" placeholder="Email"> <input
							type="password" name="pwd" class="form-control" placeholder="mot de passe">
							<input type="text" name="ville" class="form-control"
							placeholder="Ville">
								<input type="text" name="adresse" class="form-control"
							placeholder="Adresse">
								<input type="text" name="sexe" class="form-control"
							placeholder="Sexe">
							<input type="text" name="numTel" class="form-control"
							placeholder="Numero de Telephone">
								<input type="text" name="emploie" id="professionnelEmploie" style="display:none;" class="form-control"
							placeholder="Emploie">
							<textarea  name="surmoi" id="professionnelEmploie1" style="display:none;" class="form-control"
							placeholder="Decrivez vous en quelque lignes .."></textarea>
						<button class="btn btn-dark btn-block">S'inscrire</button>
					</form>

				</div>



			</div>

		</div>




	</div>


</div>
<!-- Section: Design Block -->
</body>
</html>