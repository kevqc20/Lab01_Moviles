/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// All onload functions
window.onload = function () {

// Reset modals
    $(".modal").on("hidden.bs.modal", function () {
        $(this).find('form').trigger("reset");
    });

// Hide previous modal
    $('#reMod').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#reMod2').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#logMod').on('click', function () {
        $('.modal').modal('hide')
    });



// Enter key
    $("#loginModal").keypress(function (e) {
        if (e.which == 13) {
            $("#login").click();
        }
    });
    $("#registerModal").keypress(function (e) {
        if (e.which == 13) {
            $("#register").click();
        }
    });

// Add header
    document.getElementById("navbar").innerHTML = "   <nav class='navbar navbar-expand-lg navbar-light fixed-top' id='mainNav'>" +
            "       <div class='container'>" +
            "           <a class='navbar-brand js-scroll-trigger' href='#page-top'>Abeona&Adiona</a>" +
            "           <button class='navbar-toggler navbar-toggler-right' type='button' data-toggle='collapse' data-target='#navbarResponsive' aria-controls='navbarResponsive' aria-expanded='false' aria-label='Toggle navigation'>" +
            "               Menu" +
            "               <i class='fas fa-bars'></i>" +
            "           </button>" +
            "           <div class='collapse navbar-collapse' id='navbarResponsive'>" +
            "               <ul class='navbar-nav ml-auto'>" +
            "                   <li class='nav-item'><a class='nav-link js-scroll-trigger' href='#about'>Acerca de</a></li>" +
            "                   <li class='nav-item'><a class='nav-link js-scroll-trigger' href='#signup'>Contacto</a></li>" +
            "                   <li class='nav-item'>" +
            (
                    window.sessionStorage.user === undefined ?
                    "                       <a class='nav-link js-scroll-trigger'  href='#registerModal'data-toggle='modal'>Registro</a></li>" :
                    "                       <a class='nav-link js-scroll-trigger'  href='#updateModal'data-toggle='modal'>Perfil</a></li>"
                    ) +
            (
                    window.sessionStorage.role === '0' ?
                    "                   <li class='nav-item dropdown'>" +
                    "                       <a class='nav-link dropdown-toggle' id='navbarDropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Herramientas de usuario</a>" +
                    "                       <div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>" +
                    "                           <a class='dropdown-item' href='#flightsSearchModal' class='trigger-btn' data-toggle='modal' onclick=''>Comprar ticket de vuelo</a>" +
                    "                       </div>" +
                    "                   </li>"
                    :
                    "") +
            (
                    window.sessionStorage.role === '1' ?
                    "                   <li class='nav-item dropdown'>" +
                    "                       <a class='nav-link dropdown-toggle' id='navbarDropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Herramientas de administrador</a>" +
                    "                       <div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>" +
                    "                           <a class='dropdown-item' href='#flightsAdminFlights' class='trigger-btn' data-toggle='modal' onclick='showListFlightsAdmin()'>Administrar vuelos</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminRoutes' class='trigger-btn' data-toggle='modal' onclick='showListRoutesAdmin()'>Administrar rutas</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminAirplanes' class='trigger-btn' data-toggle='modal' onclick=''>Administrar aviones</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminSchedules' class='trigger-btn' data-toggle='modal' onclick=''>Administrar horarios</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminPassangers' class='trigger-btn' data-toggle='modal' onclick=''>Administrar pasajeros</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminTickets' class='trigger-btn' data-toggle='modal' onclick=''>Administrar ticketes</a>" +
                    "                       </div>" +
                    "                   </li>"
                    :
                    "") +
            "                   <li class='nav-item'>" +
            (
                    window.sessionStorage.user === undefined ?
                    "<a class='nav-link js-scroll-trigger' href='#loginModal' class='trigger-btn' data-toggle='modal'>Ingresar</a></li>" :
                    "<a class='nav-link js-scroll-trigger' onclick='logout()' class='trigger-btn'>Cerrar sesión</a></li>"
                    ) +
            "               </ul>" +
            "           </div>" +
            "       </div>" +
            "   </nav>"


    $('#fligthsSearch').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })
    $('#flightsAdminRoutesTable').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })
    $('#flightsAdminAirplanesTable').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })
    $('#flightsAdminSchedulesTable').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })
    $('#flightsAdminPassangersTable').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })
    $('#flightsAdminTicketsTable').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        retrieve: true
    })


    if ($("#registerModal").length > 0) {
        $("#registerModal").on("click", function () {
            bootstrapValidate(
                    '#email_rm',
                    'email:Formato de e-mail incorrecto.'
                    );
            bootstrapValidate(
                    ['#name_rm', '#lastname_rm'],
                    'alpha:Solo se permiten letras.'
                    );
            bootstrapValidate(
                    '#password_rm',
                    'min:8:Contraseña debe tener al menos 8 caracteres.'
                    );
            bootstrapValidate(
                    ['#work_phone_rm'],
                    'max:8:No puede exeder los 8 caracteres.'
                    );
            bootstrapValidate(
                    ['#work_phone_rm'],
                    'min:8:No puede tener menos de 8 caracteres.'
                    );
            bootstrapValidate(
                    ['#cell_phone_rm'],
                    'max:8:No puede exeder los 8 caracteres.'
                    );
            bootstrapValidate(
                    ['#cell_phone_rm'],
                    'min:8:No puede tener menos de 8 caracteres.'
                    );
        });

        if ($("#loginModal").length > 0) {
            $("#loginModal").on("click", function () {
                bootstrapValidate(
                        '#password',
                        'min:8:Contraseña debe tener al menos 8 caracteres.'
                        );
            });
        }
    }
}


// Email verification
function isEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}

/*!
 * Start Bootstrap - Grayscale v6.0.3 (https://startbootstrap.com/theme/grayscale)
 * Copyright 2013-2020 Start Bootstrap
 * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-grayscale/blob/master/LICENSE)
 */
(function ($) {
    "use strict"; // Start of use strict

    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function () {
        if (
                location.pathname.replace(/^\//, "") ==
                this.pathname.replace(/^\//, "") &&
                location.hostname == this.hostname
                ) {
            var target = $(this.hash);
            target = target.length
                    ? target
                    : $("[name=" + this.hash.slice(1) + "]");
            if (target.length) {
                $("html, body").animate(
                        {
                            scrollTop: target.offset().top - 70,
                        },
                        1000,
                        "easeInOutExpo"
                        );
                return false;
            }
        }
    });

    // Closes responsive menu when a scroll trigger link is clicked
    $(".js-scroll-trigger").click(function () {
        $(".navbar-collapse").collapse("hide");
    });

    // Activate scrollspy to add active class to navbar items on scroll
    $("body").scrollspy({
        target: "#mainNav",
        offset: 100,
    });

    // Collapse Navbar
    var navbarCollapse = function () {
        if ($("#mainNav").offset().top > 100) {
            $("#mainNav").addClass("navbar-shrink");
        } else {
            $("#mainNav").removeClass("navbar-shrink");
        }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
})(jQuery); // End of use strict

function showPassword()
{
    var x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function showPasswordRM() {
    var x = document.getElementById("password_rm");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

/*-------------------------------------------------------*/

/* Ajax functions */
// Login to system
function logIn() {
    var user = document.getElementById("user").value;
    var password = document.getElementById("password").value;

    var jsonUser = {
        "user": user,
        "password": password,
    }


    $.ajax({
        url: 'servletLogin/in',
        data: jsonUser,
        type: 'post',
        cache: false,
        success: function (data) {
            window.sessionStorage.user = data["user"]["username"]
            window.sessionStorage.password = data["user"]["password"]
            window.sessionStorage.role = data["user"]["rol"] ? "1" : "0"
            window.location.replace("presentation/idle.jsp");
        },
        error: function () {
            alert('error');
        }
    }
    );
}

// Logout of system
function logout() {
    window.sessionStorage.removeItem("user");
    window.sessionStorage.removeItem("password");
    window.sessionStorage.removeItem("role");
    window.location.replace("/lab01_frontend1");
}


// List
// Get all campaigns
function showListFlightsAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/flightList',
        cache: false,
        success: function (data) {
            list(data);
            $(document).ready(function () {
                $('#flightsAdminFlightsTable').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    },
                    retrieve: true
                })
            });
        },
        error: function () {
            alert('error');
        },
        fail: function () {
            alert("fail")
        }
    })
}

function showListRoutesAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/routeList',
        cache: false,
        success: function (data) {
            //alert(JSON.stringify(data));
            list(data);
            $(document).ready(function () {
                $('#flightsAdminRoutesTable').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    },
                    retrieve: true
                })
            });
        },
        error: function () {
            alert('error');
        },
        fail: function () {
            alert("fail")
        }
    })
}

//Create list
function list(data) {
    //alert(JSON.stringify(data));
    if ($("#flightsAdminFlights").length > 0) {
        console.log("flightsAdminFlights");
        var listado = document.getElementById("flightsAdminTable");
        listado.innerHTML = "";
        data["flightList"].forEach((u) => {
            row(u);
        });

    } else if ($("#flightsAdminRoutes").length > 0) {
        alert("hi n.n");
        console.log("flightsAdminRoutes");
        var listado = document.getElementById("flightsAdminRoutesTable");
        listado.innerHTML = "";
        data["routeList"].forEach((u) => {
            row(u);
        });
    }

//    } else if ($("#listModalCampaigns").is(':visible')) {
//        console.log("listModalCampaigns");
//        var listado = document.getElementById("listadoC");
//        listado.innerHTML = "";
//        data.forEach((u) => {
//            row(u);
//        });
//    }
}
// Add rows to table
function row(data) {
    if (data) {
        var tr = '<tr>';
        if ($("#flightsAdminFlights").length > 0) {
            console.log("#flightsAdminFlights")
            tr += '<td>' + data.id + '</td>';
            tr += '<td>' + data.route_id + '</td>';
            tr += '<td>' + data.airplaine_id + '</td>';
            tr += '<td>' + data.schedule_id + '</td>';
            tr += '<td><button class="flightsAdminEdit" href="#updateFlightModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
            tr += '<td><button class="flightsAdminDelete" href="#flightDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
            tr += '</tr>';
            $('#flightsAdminTable').append(tr);

        } else if ($("#flightsAdminRoutes").length > 0) {
            console.log("#flightsAdminRoutes")
            tr += '<td>' + data.id + '</td>';
            tr += '<td>' + data.origin + '</td>';
            tr += '<td>' + data.destination + '</td>';
            tr += '<td>' + data.duration + '</td>';
            tr += '<td><button class="routesAdminEdit" href="#updateRouteModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
            tr += '<td><button class="routesAdminDelete" href="#routeDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
            tr += '</tr>';
            $('#flightsAdminRoutesTable').append(tr);
        }
//        else if ($("#listModalCampaigns").is(':visible')) {
//            console.log("listModalCampaigns")
//            tr += '<td>' + data.id_campaign + '</td>';
//            tr += '<td>' + data.name + '</td>';
//            tr += '<td>' + data.instructor + '</td>';
//            tr += '<td>' + data.target + '</td>';
//            tr += '<td>' + data.location + '</td>';
//            tr += '<td>' + data.max + '</td>';
//            tr += '<td><button class="editC" href="#updateModalCampaign" class="trigger-btn" data-toggle="modal">Editar</button> <button class="editC" href="#" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
//            tr += '</tr>';
//            $('#listadoC').append(tr);
//        } 
    }
}