<%@page import="com.google.gson.Gson"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Lab01 Idle</title>
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/r-2.2.6/sc-2.0.3/datatables.min.js"></script>
        <script src="https://cdn.rawgit.com/PascaleBeier/bootstrap-validate/v2.2.0/dist/bootstrap-validate.js" ></script>
        <link href="../css/default.css" rel="stylesheet" type="text/css"/>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/script.js" type="text/javascript"></script>


    </head>


    <body id="page-top">

        <div id="navbar"></div>


        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active" style="background-image: url('../assets/img/car01.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="display-4">Nada desarrolla tanto</h3>
                        <p class="display-5">la inteligencia como viajar.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: url('../assets/img/car02.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="display-4">Se tiene que viajar</h3>
                        <p class="display-5">para aprender.</p>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: url('../assets/img/car03.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="display-4">La vida, o es una aventura</h3>
                        <p class="display-5">o no es nada.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <!-- Page Content -->
        <section class="py-5" id="about">
            <div class="container">
                <h1 class="font-weight-light" style="color:white; text-align: center;">No olvidaras este viaje.</h1>
            </div>
        </section>



        <!-- Contact-->
        <section class="contact-section bg-black" id="signup">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-graduation-cap text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Diseño y Programación de Plataformas Móviles</h4>
                                <hr class="my-4" />
                                <h5 class="text-uppercase m-0">Lab01</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-envelope text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Kevin Quesada Campos</h4>
                                <hr class="my-4" />
                                <div class="small text-black-50"><a href="#!">kevin.quesada.campos@est.una.ac.cr</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-envelope text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Mariana Mora Valverde</h4>
                                <hr class="my-4" />
                                <div class="small text-black-50"><a href="#!">mariana.valverde.mora@est.una.ac.cr</a></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="social d-flex justify-content-center">
                    <a class="mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                    <a class="mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                    <a class="mx-2" href="#!"><i class="fab fa-github"></i></a>
                </div>
            </div>
        </section>

        <div class="content"> 


        </div>


        <!-- Modals-->
        <%@ include file="../presentation/modals.jsp" %>



    </body>
</html>


