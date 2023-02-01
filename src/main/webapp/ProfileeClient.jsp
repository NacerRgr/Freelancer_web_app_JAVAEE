<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">
body{

	background-color: #f7f6f6;
}

.card{

	width: 500px;
	border: none;
	box-shadow: 5px 6px 6px 2px #e9ecef;
	border-radius: 12px;
}

.circle-image img{

	border: 6px solid #fff;
    border-radius: 100%;
    padding: 0px;
    top: -28px;
    position: relative;
    width: 90px;
    height: 90px;
    border-radius: 100%;
    z-index: 1;
    background: white;
    cursor: pointer;

}


.dot {
      height: 18px;
    width: 18px;
    background-color: blue;
    border-radius: 50%;
    display: inline-block;
    position: relative;
    border: 3px solid #fff;
    top: -48px;
    left: 261px;
    z-index: 1000;
}

.name{
	margin-top: -21px;
	font-size: 18px;
}


.fw-500{
	font-weight: 500 !important;
}


.start{

	color: green;
}

.stop{
	color: red;
}


.rate{

	border-bottom-right-radius: 12px;
	border-bottom-left-radius: 12px;

}



.rating {
    display: flex;
    flex-direction: row-reverse;
    justify-content: center
}

.rating>input {
    display: none
}

.rating>label {
    position: relative;
    width: 1em;
    font-size: 30px;
    font-weight: 300;
    color: #FFD600;
    cursor: pointer
}

.rating>label::before {
    content: "\2605";
    position: absolute;
    opacity: 0
}

.rating>label:hover:before,
.rating>label:hover~label:before {
    opacity: 1 !important
}

.rating>input:checked~label:before {
    opacity: 1
}

.rating:hover>input:checked~label:before {
    opacity: 0.4
}


.buttons{
	
    position: relative;
}


.rating-submit{
	border-radius: 20px;
	color: #fff;
	    height: 49px;
	    
}


.rating-submit:hover{
	
	color: #fff;
}
.btn{
	width:300px;
}



</style>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="#">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Bricoli liya
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="contProf?act=clientBesoins"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link" href="contProf?act=afficherProfessionnel"> <i
					class="fas fa-solid fa-user"></i> <span>Mon profil</span>
			</a></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link" href="contProf?act=afficherCvProffesionnel"> <i
					class="fas fa-solid fa-file"></i> <span>Mon cv</span>
			</a></li>


			<li class="nav-item"><a class="nav-link" href="contProf?act=afficherServices"> <i
					class="fas fa-solid fa-list-ul"></i> <span>Mes services</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="contProf?act=afficherOffreClientP"> 
			<i class="fas fa-solid fa-user-plus"></i> <span>Mes offres</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="contProf?act=mesClients"> 
			<i class="fas fa-solid fa-users"></i><span>Mes Clients </span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fa-solid fa-map-location"></i> <i
					class="fas fa-solid fa-map"></i> <span>Maps</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Divider -->


			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>
		<!-- End of Sidebar -->



		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->



						<!-- Nav Item - Messages -->

						<div class="topbar-divider d-none d-sm-block"></div>


						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"> <c:forEach
										items="${ sessionScope.unProf }" var="unprof" varStatus="boucle">
										<span> ${ unprof.getNom() } ${ unprof.getPrenom() } </span>
									</c:forEach>
							</span> <img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profil
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Paramètre
								</a>

								<div class="dropdown-divider"></div>
								<a href="loginP.jsp" class="dropdown-item"  data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									se déconnecter
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">




	<!-- Affichage l'alert d'evaluation par succès -->
   <c:if test="${not empty demandeSucces}">
      <div class="alert alert-primary alert-dismissible fade show" role="alert">
      <b> <c:out value="${demandeSucces}" /></b>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
       <span aria-hidden="true">&times;</span>
        </button>
      </div>
   </c:if>
<!-- Affichage d'evaluation par succès -->

					<!-- Page Heading -->


					<!-- Content Row -->
					<div class="row">

						<!-- Earnings (Monthly) Card Example -->

						<!-- Earnings (Monthly) Card Example -->


						<!-- Earnings (Monthly) Card Example -->

						<!-- Pending Requests Card Example -->

					</div>

					<!-- Content Row -->

					<div class="row">

						<!-- Area Chart -->


						<!-- Pie Chart -->

					</div>

					<!-- Content Row -->


					<!-- Content Column -->

					<!-- Topbar Search -->
					
					<!-- endbar Search -->
					<br> <br> <br>

					<!-- les cards -->
					
					
					
					
					
					<!-- 
					<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="assets/img.jpeg" width = "100px" height = "200px" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>

  <div class="card-body">
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>
 -->
 
 

 
					<div class="row ">
						<c:forEach items="${ listBesoins }" var="listebesoin"
							varStatus="boucle">
		<div class="container d-flex justify-content-center">

        <div class="card  mb-5">

            <div class="circle-image text-center">
                <img src="icon-user.svg" width="50">
            </div>

                <span class="dot text-center"></span>

            <span class="name mb-1 fw-500 text-center"><c:out value="${listebesoin.getNom()} ${listebesoin.getPrenom()}" /></span>
            <small class="text-black-50 font-weight-bold text-center"><c:out value="${listebesoin.getEmail()}" /></small>
            <small class="text-black-50 font-weight-bold text-center"><c:out value="${listebesoin.getNumTel()}" /></small>
            <small class="text-black-50 font-weight-bold text-center">Habite à <c:out value="${listebesoin.getAdresse()}" /> <c:out value="   ${listebesoin.getVille()}" /></small>
            
             
             <small class="text-black-50 font-weight-bold text-center">Recherche d'un(e) <c:out value="${listebesoin.getTitreBesoin()}" />,   <span><i class="fa fa-map-marker stop mt-2"></i> <c:out value="   ${listebesoin.getVille()}" /> </span></small>
            

          <div class="p-4">

            <div class="location mt-4 text-wrap container ">

               

                <span><c:out value="${listebesoin.getDescription()}" /> à <c:out value="   ${listebesoin.getVille()}" />, prix à payer est <c:out value="${listebesoin.getPrixApayer()}" /> Dhs</span>
                
            </div>
            </div>


            <div class="rate bg-primary py-3 text-white mt-3">

                
                <!--  <h6 class="mb-0 text-center">Evaluer le client</h6>
                 <form action="contProf?act=EvaluerClient&cinCli=${listebesoin.getCin()}&cinC=${listebesoin.getIdBesoin()}" method="post">-->
          
                 <!--
                 
                    <div class="rating">
      
                <input type="radio" name="rating" value="5" id="5" required><label for="5">☆</label> 
                <input type="radio" name="rating" value="4" id="4" required><label for="4">☆</label> 
                <input type="radio" name="rating" value="3" id="3"required><label for="3">☆</label> 
                <input type="radio" name="rating" value="2" id="2" required><label for="2">☆</label>
                <input type="radio" name="rating" value="1" id="1" required><label for="1">☆</label>
                </div>
                   -->
                   
              <form action="contProf?act=VoirAvis&cinCli=${listebesoin.getCin()}&idB=${listebesoin.getIdBesoin()}" method="post">
                <div class="buttons px-4 mt-0 text-center">
               <!--   <button class="btn btn-warning btn-block rating-submit">Evaluer</button>--> 
               <button type="submit" class="btn btn-warning  rating-submit  m-1"> Voir les avis</button> 
               </div>
               </form>
                   
                   
                   
               <c:if test="${empty demandeSucces}">
              <form action="contProf?act=DemandEmploi&cinCli=${listebesoin.getCin()}&idB=${listebesoin.getIdBesoin()}" method="post">
                <div class="buttons px-4 mt-0 text-center">

               <!--   <button class="btn btn-warning btn-block rating-submit">Evaluer</button>--> 
               <button type="submit" class="btn btn-warning  rating-submit  m-1">Demande </button>
                
            </div>
            </form>
             </c:if>
             
                 <c:if test="${not empty demandeSucces}">
              <form action="contProf?act=DemandEmploi&cinCli=${listebesoin.getCin()}&idB=${listebesoin.getIdBesoin()}" method="post">
                <div class="buttons px-4 mt-0 text-center">

               <!--   <button class="btn btn-warning btn-block rating-submit">Evaluer</button>--> 
               <button type="submit" class="btn btn-warning  rating-submit m-1" disabled>Demande envoyée</button>
                
            </div>
            </form>
             </c:if>

                
            </div>




            
            
        </div>
        


    </div>
						</c:forEach>

					</div>

					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white fixed-bottom">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Votre site 2022</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Prêt à partir?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Sélectionnez "Déconnexion" ci-dessous si vous êtes prêt à mettre fin à votre session en cours.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Annuler</button>
					<a class="btn btn-primary" href="loginP.jsp">Déconnexion</a>
				</div>
			</div>
		</div>
	</div>




		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="vendor/chart.js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="js/demo/chart-area-demo.js"></script>
		<script src="js/demo/chart-pie-demo.js"></script>
</body>

</html>