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
    $('#updatePassangerAdmin').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#updateAirplaneB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#updateRouteB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#updateScheduleB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#updateTicketB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#updateFlightB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerPassangerAdmin').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerAirplaneB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerRouteB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerScheduleB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerTicketB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('#registerFlightB').on('click', function () {
        $('.modal').modal('hide')
    });
    $('.checkout-button').on('click', function () {
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
                    "                       <a class='nav-link js-scroll-trigger'  href='#updatePassangerModal'data-toggle='modal' onclick='getPassanger()'>Perfil</a></li>"
                    ) +
            (
                    window.sessionStorage.role === '0' ?
                    "                   <li class='nav-item dropdown'>" +
                    "                       <a class='nav-link dropdown-toggle' id='navbarDropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Herramientas de usuario</a>" +
                    "                       <div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>" +
                    "                           <a class='dropdown-item' href='#flightsSearchModal' class='trigger-btn' data-toggle='modal' onclick='showListFlightsClient()'>Comprar ticket de vuelo</a>" +
                    "                           <a class='dropdown-item' href='#flightsClientTickets' class='trigger-btn' data-toggle='modal' onclick='showListTicketsClient()'>Tiquetes comprados</a>" +
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
                    "                           <a class='dropdown-item' href='#flightsAdminAirplanes' class='trigger-btn' data-toggle='modal' onclick='showListAirplanesAdmin()'>Administrar aviones</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminSchedules' class='trigger-btn' data-toggle='modal' onclick='showListSchedulesAdmin()'>Administrar horarios</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminPassangers' class='trigger-btn' data-toggle='modal' onclick='showListPassangersAdmin()'>Administrar pasajeros</a>" +
                    "                           <a class='dropdown-item' href='#flightsAdminTickets' class='trigger-btn' data-toggle='modal' onclick='showListTicketsAdmin()'>Administrar ticketes</a>" +
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


    $("#airplanesAdminTable").on('click', ".airplanesAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getAirplane(tr.cells[0].textContent);
    }));
    $("#passangersAdminTable").on('click', ".passangerAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getPassangerAdmin(tr.cells[0].textContent);
    }));
    $("#routesAdminTable").on('click', ".routesAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getRoute(tr.cells[0].textContent);
    }));
    $("#schedulesAdminTable").on('click', ".schedulesAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getSchedule(tr.cells[0].textContent);
        console.log(tr.cells[0].textContent)
    }));
    $("#ticketsAdminTable").on('click', ".ticketsAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getTicket(tr.cells[0].textContent);
        console.log(tr.cells[0].textContent)
    }));
    $("#flightsAdminTable").on('click', ".flightsAdminEdit", (function (ele) {
        var tr = ele.target.parentNode.parentNode;
        getFlight(tr.cells[0].textContent);
        console.log(tr.cells[0].textContent)
    }));

    addsession();
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

function showPassword() {
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
            if (data["user"] != undefined) {
                window.sessionStorage.main = JSON.stringify(data["user"])
                window.sessionStorage.user = data["user"]["username"]
                window.sessionStorage.password = data["user"]["password"]
                window.sessionStorage.role = data["user"]["rol"] ? "1" : "0"
                window.location.replace("presentation/idle.jsp");
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Contraseña incorrecta.</p>');
                jQuery("#errorModal").modal('show');
                $("#errorModal").on("hidden.bs.modal", function () {
                    $('#loginModal').find('form').trigger('reset');
                });
            }
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Ese usuario no existe.</p>');
            jQuery("#errorModal").modal('show');
            $("#errorModal").on("hidden.bs.modal", function () {
                $('#loginModal').find('form').trigger('reset');
            });
        }
    }
    );
}
// Logout of system
function logout() {
    window.sessionStorage.removeItem("main");
    window.sessionStorage.removeItem("user");
    window.sessionStorage.removeItem("password");
    window.sessionStorage.removeItem("role");
    window.location.replace("/lab01_frontend1");
}


// Register new user 
function addNewUser() {
    var user_username_rm = document.getElementById("user_username_rm").value;
    var email_rm = document.getElementById("email_rm").value;
    var password_rm = document.getElementById("password_rm").value;
    var name_rm = document.getElementById("name_rm").value;
    var lastname_rm = document.getElementById("lastname_rm").value;
    var work_phone_rm = document.getElementById("work_phone_rm").value;
    var cell_phone_rm = document.getElementById("cell_phone_rm").value;
    var address_rm = document.getElementById("address_rm").value;
    var dob_rm = document.getElementById("dob_rm").value;
    var jsonUser = {
        "user_name": user_username_rm,
        "password": password_rm,
        "name_": name_rm,
        "lastname": lastname_rm,
        "email": email_rm,
        "bob": dob_rm,
        "address": address_rm,
        "work_phone": work_phone_rm,
        "cell_phone": cell_phone_rm
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/registro",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil creado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new airplane 
function addNewAirplane() {
    var id = document.getElementById("ap_id_add").value;
    var year = document.getElementById("ap_year_add").value;
    var model = document.getElementById("ap_model_add").value;
    var brand = document.getElementById("ap_brand_add").value;
    var cant = document.getElementById("ap_cantmax_add").value;
    var type = document.getElementById("ap_type_add").value;
    var jsonUser = {
        "id": id,
        "year": year,
        "model": model,
        "brand": brand,
        "cant": cant,
        "type": (type == 1 ? true : false)
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/avion",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Avión agregado con exito.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new route 
function addNewRoute() {
    var id = document.getElementById("rt_id_add").value;
    var origin = document.getElementById("rt_origin_add").value;
    var destination = document.getElementById("rt_destination_add").value;
    var duration = document.getElementById("rt_duration_add").value;
    var jsonUser = {
        "id": id,
        "origin": origin,
        "destination": destination,
        "duration": duration
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/ruta",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ruta de vuelo agregada con exito.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new schedule 
function addNewShedule() {
    var id = document.getElementById("sh_id_add").value;
    var date = document.getElementById("sh_datetime_add").value;
    var a = new Date(date);
    a.setMinutes(a.getMinutes() - a.getTimezoneOffset());
    var jsonUser = {
        "id": id,
        "date": a.toISOString().substring(0, 19)
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/horario",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Horario de vuelo agregado con exito.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new ticket 
function addNewTicket() {
    var id = document.getElementById("tk_id_add").value;
    var flight_id = document.getElementById("tk_fid_add").value;
    var price = document.getElementById("tk_price_phone_add").value;
    var discount = document.getElementById("tk_discount_phone_add").value;
    var seat = document.getElementById("tk_seat_add").value;
    var user_usuario = document.getElementById("tk_user_add").value;
    var jsonUser = {
        "id": id,
        "flight_id": flight_id,
        "price": price,
        "discount": discount,
        "seat": seat,
        "user_usuario": user_usuario
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/tiquete",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ticket agregado con exito.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new flight 
function addNewFlight() {
    var id = document.getElementById("f_id_add").value;
    var rute_id = document.getElementById("f_rid_add").value;
    var airplane_id = document.getElementById("f_apid_add").value;
    var shedule_id = document.getElementById("f_schid_add").value;
    var jsonUser = {
        "id": id,
        "rute_id": rute_id,
        "airplane_id": airplane_id,
        "shedule_id": shedule_id
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/vuelo",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center"Vuelo agregado con exito.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register new user from admin 
function addNewUserAdmin() {
    var user_username_rm = document.getElementById("p_username_add").value;
    var email_rm = document.getElementById("p_addail_add").value;
    var password_rm = document.getElementById("p_password_add").value;
    var name_rm = document.getElementById("p_name_add").value;
    var lastname_rm = document.getElementById("p_lastname_add").value;
    var work_phone_rm = document.getElementById("p_work_phone_add").value;
    var cell_phone_rm = document.getElementById("p_cell_phone_add").value;
    var address_rm = document.getElementById("p_address_add").value;
    var dob_rm = document.getElementById("p_dob_add").value;
    var jsonUser = {
        "user_name": user_username_rm,
        "password": password_rm,
        "name_": name_rm,
        "lastname": lastname_rm,
        "email": email_rm,
        "bob": dob_rm,
        "address": address_rm,
        "work_phone": work_phone_rm,
        "cell_phone": cell_phone_rm
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/registro",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil creado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#registerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Register tickets from checkout
function addNewTicketArray(flight_id, discount, array) {

    var flight_id = flight_id;
    var discount = discount;
    var seatList = array;
    var user_usuario = window.sessionStorage.user;
    seatList.forEach(function (data) {
        var jsonUser = {
            "id": flight_id + "_" + data.id,
            "flight_id": flight_id,
            "price": data.price,
            "discount": discount,
            "seat": data.number,
            "user_usuario": user_usuario
        }

        $.ajax({
            url: "/lab01_frontend1/servletInsert/tiquete",
            method: "POST",
            data: jsonUser,
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">¡Muchas gracias por su compra!.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#registerModal').modal('hide')
                });
                notifyAll();
            },
            error: function () {
                alert("algo salio mal");
            }
        });
    });
}


// Get Passanger
function getPassanger() {
    var main = JSON.parse(window.sessionStorage.main);
    $.ajax({
        url: '/lab01_frontend1/servletSearch/passenger',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 1)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Get Passanger Admin
function getPassangerAdmin(data) {
    var main = {
        "username": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/passenger',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 1)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Passanger
function updatePassanger() {

    var user_username_rm = document.getElementById("p_username_em").value;
    var email_rm = document.getElementById("p_email_em").value;
    var password_rm = document.getElementById("p_password_em").value;
    var name_rm = document.getElementById("p_name_em").value;
    var lastname_rm = document.getElementById("p_lastname_em").value;
    var work_phone_rm = document.getElementById("p_work_phone_em").value;
    var cell_phone_rm = document.getElementById("p_cell_phone_em").value;
    var address_rm = document.getElementById("p_address_em").value;
    var dob_rm = document.getElementById("p_dob_em").value;
    var role_rm = window.sessionStorage.getItem("role");
    console.log(dob_rm)

    var jsonUser = {
        "user_name": user_username_rm,
        "password": password_rm,
        "name_": name_rm,
        "lastname": lastname_rm,
        "email": email_rm,
        "bob": dob_rm,
        "address": address_rm,
        "work_phone": work_phone_rm,
        "cell_phone": cell_phone_rm,
        "role": role_rm
    }

    $.ajax({
        url: "/lab01_frontend1/servletUpdate/registro",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updatePassangerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Get Airplane
function getAirplane(data) {
    var main = {
        "id": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/airplane',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 2)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Airplane
function updateAirplane() {
    var id = document.getElementById("ap_id_em").value;
    var year = document.getElementById("ap_year_em").value;
    var model = document.getElementById("ap_model_em").value;
    var brand = document.getElementById("ap_brand_em").value;
    var type = document.getElementById("ap_type_em").value == 1 ? true : false;
    var cant_max = document.getElementById("ap_cantmax_em").value;
    var jsonUser = {
        "id": id,
        "year": year,
        "model": model,
        "brand": brand,
        "type": type,
        "cant_max": cant_max
    }

    $.ajax({
        url: "/lab01_frontend1/servletUpdate/avion",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Avión actualizado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updatePassangerModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Get Airplane
function getRoute(data) {
    var main = {
        "id": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/route',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 3)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Airplane
function updateRoute() {
    var id = document.getElementById("rt_id_em").value;
    var origin = document.getElementById("rt_origin_em").value;
    var destination = document.getElementById("rt_destination_em").value;
    var duration = document.getElementById("rt_duration_em").value;
    var jsonUser = {
        "id": id,
        "origin": origin,
        "destination": destination,
        "duration": duration
    }


    $.ajax({
        url: "/lab01_frontend1/servletUpdate/ruta",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            console.log(JSON.stringify(data))
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ruta actualizada satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updateRouteModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Get Schedule
function getSchedule(data) {
    var main = {
        "id": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/schedule',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 4)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Schedule
function updateSchedule() {
    var id = document.getElementById("sh_id_em").value;
    var date_time = document.getElementById("sh_datetime_em").value;
    var a = new Date(date_time).toISOString().slice(0, 19).replace('T', ' ');
    var jsonUser = {
        "id": id,
        "date_time": a
    }

    console.log(jsonUser);
    $.ajax({
        url: "/lab01_frontend1/servletUpdate/horario",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Horario actualizado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updateRouteModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Get Ticket
function getTicket(data) {
    var main = {
        "id": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/ticket',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 5)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Ticket
function updateTicket() {
    var id = document.getElementById("tk_id_em").value;
    var flight_id = document.getElementById("tk_fid_em").value;
    var price = document.getElementById("tk_price_phone_em").value;
    var discount = document.getElementById("tk_discount_phone_em").value;
    var seat = document.getElementById("tk_seat_em").value;
    var user_username = document.getElementById("tk_user_em").value;
    var jsonUser = {
        "id": id,
        "flight_id": flight_id,
        "price": price,
        "discount": discount,
        "seat": seat,
        "user_username": user_username
    }

    console.log(jsonUser);
    $.ajax({
        url: "/lab01_frontend1/servletUpdate/tiquete",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ticket actualizado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updateRouteModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}
// Get Flight
function getFlight(data) {
    var main = {
        "id": data
    }
    $.ajax({
        url: '/lab01_frontend1/servletSearch/flight',
        data: main,
        type: 'post',
        cache: false,
        success: function (data) {
            fillWithInformation(data, 6)
        },
        error: function () {
            jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
            jQuery("#errorModal").modal('show');
        }
    }
    );
}
// Update Flight
function updateFlight() {
    var id = document.getElementById("f_id_em").value;
    var route_id = document.getElementById("f_rid_em").value;
    var airplaine_id = document.getElementById("f_apid_em").value;
    var schedule_id = document.getElementById("f_schid_em").value;
    var jsonUser = {
        "id": id,
        "route_id": route_id,
        "airplaine_id": airplaine_id,
        "schedule_id": schedule_id
    }

    console.log(jsonUser);
    $.ajax({
        url: "/lab01_frontend1/servletUpdate/vuelo",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Vuelo actualizado satisfactoriamente.</p>');
            jQuery("#successModal").modal('show');
            $("#successModal").on("hidden.bs.modal", function () {
                $('#updateRouteModal').modal('hide')
            });
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}


function flighTickets(id_fly, scMap) {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/ticketsList',
        cache: false,
        success: function (data) {
            data["ticketsLists"].forEach((x) => {
                if (x.flight_id == id_fly) {
                    var num = x.seat.toString();
                    num = num[0] + "_" + num[1];
                    set_unavailable(num);
                }
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



// Fill rows with info
function fillWithInformation(data, i) {
    switch (i) {
        case 1:
        {
// Passangers
            var a = new Date(data['passanger']['dob']);
            a.setDate(a.getDate() + 1)
            console.log(data['passanger']['dob']);
            document.getElementById("p_username_em").value = data['passanger']['user_username'];
            document.getElementById("p_email_em").value = data['passanger']['email'];
            document.getElementById("p_password_em").value = window.sessionStorage.getItem("password")
            document.getElementById("p_name_em").value = data['passanger']['name'];
            document.getElementById("p_lastname_em").value = data['passanger']['lastname'];
            document.getElementById("p_work_phone_em").value = data['passanger']['work_phone'];
            document.getElementById("p_cell_phone_em").value = data['passanger']['cell_phone'];
            document.getElementById("p_address_em").value = data['passanger']['address'];
            document.getElementById("p_dob_em").value = a.toISOString().substring(0, 10);
            break;
        }
        case 2:
        {
// Airplanes
            document.getElementById("ap_id_em").value = data['airplane']['id'];
            document.getElementById("ap_year_em").value = data['airplane']['year'];
            document.getElementById("ap_model_em").value = data['airplane']['model'];
            document.getElementById("ap_brand_em").value = data['airplane']['brand'];
            document.getElementById("ap_type_em").value = data['airplane']['type'] ? 1 : 0;
            document.getElementById("ap_cantmax_em").value = data['airplane']['cant_max'];
            break;
        }
        case 3:
        {
// Routes
            document.getElementById("rt_id_em").value = data['route']['id'];
            document.getElementById("rt_origin_em").value = data['route']['origin'];
            document.getElementById("rt_destination_em").value = data['route']['destination'];
            document.getElementById("rt_duration_em").value = data['route']['duration'];
            break;
        }
        case 4:
        {
// Shedules
            var a = new Date(data['schedule']['date_time']);
            a.setMinutes(a.getMinutes() - a.getTimezoneOffset());
            document.getElementById("sh_id_em").value = data['schedule']['id'];
            document.getElementById("sh_datetime_em").value = a.toISOString().substring(0, 19);
            break;
        }
        case 5:
        {
// Tickets
            var disc = parseInt(data['tickets']['price']) - (parseInt(data['tickets']['price']) * 1 / parseInt(data['tickets']['discount']));
            document.getElementById("tk_id_em").value = data['tickets']['id'];
            document.getElementById("tk_fid_em").value = data['tickets']['flight_id'];
            document.getElementById("tk_price_phone_em").value = data['tickets']['price'];
            document.getElementById("tk_discount_phone_em").value = data['tickets']['discount'];
            document.getElementById("tk_finalprice_em").value = disc.toString();
            document.getElementById("tk_seat_em").value = data['tickets']['seat'];
            document.getElementById("tk_user_em").value = data['tickets']['user_username'];
            break;
        }
        case 6:
        {
// Flights
            document.getElementById("f_id_em").value = data['flight']['id'];
            document.getElementById("f_rid_em").value = data['flight']['route_id'];
            document.getElementById("f_apid_em").value = data['flight']['airplaine_id'];
            document.getElementById("f_schid_em").value = data['flight']['schedule_id'];
            break;
        }
    }
}



// List
function showListFlightsAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/flightList',
        cache: false,
        success: function (data) {
            list(data, 1);
            $(document).ready(function () {
                $('#flightsAdminFlightsTable').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    },
                    retrieve: true
                })
            });
        }
    })
}

function showListFlightsClient() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/flightList',
        cache: false,
        success: function (data) {
            list(data, 7);
            $(document).ready(function () {
                $('#fligthsSearch').DataTable({
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
            list(data, 2);
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

function showListAirplanesAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/airplaneList',
        cache: false,
        success: function (data) {
            //alert(JSON.stringify(data));
            list(data, 3);
            $(document).ready(function () {
                $('#flightsAdminAirplanesTable').DataTable({
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

function showListSchedulesAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/scheduleList',
        cache: false,
        success: function (data) {
            //alert(JSON.stringify(data));
            list(data, 4);
            $(document).ready(function () {
                $('#flightsAdminSchedulesTable').DataTable({
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

function showListPassangersAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/passengerList',
        cache: false,
        success: function (data) {
            //alert(JSON.stringify(data));
            list(data, 5);
            $(document).ready(function () {
                $('#flightsAdminPassangersTable').DataTable({
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

function showListTicketsAdmin() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/ticketsList',
        cache: false,
        success: function (data) {
            //alert(JSON.stringify(data));
            list(data, 6);
            $(document).ready(function () {
                $('#flightsAdminTicketsTable').DataTable({
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

function showListTicketsClient() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/ticketsList',
        cache: false,
        success: function (data) {
            list(data, 8);
            $(document).ready(function () {
                $('#flightsClientTicketsTable').DataTable({
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
function list(data, i) {
    switch (i) {
        case 1:
        {
            var listado = document.getElementById("flightsAdminTable");
            listado.innerHTML = "";
            data["flightList"].forEach((u) => {
                row(u, 1);
            });
            break;
        }
        case 2:
        {
            var listado = document.getElementById("routesAdminTable");
            listado.innerHTML = "";
            data["routeList"].forEach((u) => {
                row(u, 2);
            });
            break;
        }
        case 3:
        {
            var listado = document.getElementById("airplanesAdminTable");
            listado.innerHTML = "";
            data["airplaneList"].forEach((u) => {
                row(u, 3);
            });
            break;
        }
        case 4:
        {
            var listado = document.getElementById("schedulesAdminTable");
            listado.innerHTML = "";
            data["scheduleList"].forEach((u) => {
                row(u, 4);
            });
            break;
        }
        case 5:
        {
            var listado = document.getElementById("passangersAdminTable");
            listado.innerHTML = "";
            data["passengerList"].forEach((u) => {
                row(u, 5);
            });
            break;
        }
        case 6:
        {
            var listado = document.getElementById("ticketsAdminTable");
            listado.innerHTML = "";
            data["ticketsLists"].forEach((u) => {
                row(u, 6);
            });
            break;
        }
        case 7:
        {
            var listado = document.getElementById("flightsAvailable");
            listado.innerHTML = "";
            data["flightList"].forEach((u) => {
                row(u, 7);
            });
            break;
        }
        case 8:
        {
            var listado = document.getElementById("ticketsClientTable");
            listado.innerHTML = "";
            data["ticketsLists"].forEach((u) => {
                if (u.user_username.toString() === window.sessionStorage.user.toString()) {
                    row(u, 8);
                }
            });
            break;
        }
    }
}

// Add rows to table
function row(data, i) {
    if (data) {
        var tr = '<tr>';
        switch (i) {
            case 1:
            {
                tr += '<td>' + data.id + '</td>';
                // Route data
                var route = {
                    "id": data.route_id
                }
                $.ajax({
                    url: '/lab01_frontend1/servletSearch/route',
                    data: route,
                    type: 'post',
                    cache: false,
                    async: false,
                    success: function (a) {
                        tr += '<td>' + a["route"]["destination"] + '</td>';
                        tr += '<td>' + a["route"]["origin"] + '</td>';
                    },
                    error: function () {
                        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
                        jQuery("#errorModal").modal('show');
                    }
                }
                );
                // Schedule data
                var schedule = {
                    "id": data.schedule_id
                }
                $.ajax({
                    url: '/lab01_frontend1/servletSearch/schedule',
                    data: schedule,
                    type: 'post',
                    cache: false,
                    async: false,
                    success: function (b) {
                        tr += '<td>' + b["schedule"]["date_time"] + '</td>';
                    },
                    error: function () {
                        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
                        jQuery("#errorModal").modal('show');
                    }
                }
                );
                tr += '<td><button class="flightsAdminEdit" href="#updateFlightModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="flightsAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deleteFlight(' + "\'" + data.id + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#flightsAdminTable').append(tr);
                break;
            }
            case 2:
            {
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.origin + '</td>';
                tr += '<td>' + data.destination + '</td>';
                tr += '<td>' + data.duration + '</td>';
                tr += '<td><button class="routesAdminEdit" href="#updateRouteModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="routesAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deleteRoute(' + "\'" + data.id + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#routesAdminTable').append(tr);
                break;
            }
            case 3:
            {
                console.log(data.id)
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.year + '</td>';
                tr += '<td>' + data.model + '</td>';
                tr += '<td>' + data.brand + '</td>';
                tr += '<td>' + (data.type ? "Grande" : "Pequeño") + '</td>';
                tr += '<td>' + data.cant_max + '</td>';
                tr += '<td><button class="airplanesAdminEdit" href="#updateAirplaneModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += ' <td><button class="airplanesAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deleteAirplane(' + "\'" + data.id + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#airplanesAdminTable').append(tr);
                break;
            }
            case 4:
            {
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.date_time + '</td>';
                tr += '<td><button class="schedulesAdminEdit" href="#updateScheduleModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="schedulesAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deleteSchedule(' + "\'" + data.id + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#schedulesAdminTable').append(tr);
                break;
            }
            case 5:
            {
                tr += '<td>' + data.user_username + '</td>';
                tr += '<td>' + data.name + '</td>';
                tr += '<td>' + data.lastname + '</td>';
                tr += '<td>' + data.email + '</td>';
                tr += '<td>' + data.dob + '</td>';
                tr += '<td>' + data.address + '</td>';
                tr += '<td>' + data.work_phone + '</td>';
                tr += '<td>' + data.cell_phone + '</td>';
                tr += '<td><button class="passangerAdminEdit" href="#updatePassangerModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="passangerAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deletePassanger(' + "\'" + data.user_username + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#passangersAdminTable').append(tr);
                break;
            }
            case 6:
            {
                console.log(data);
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.flight_id + '</td>';
                tr += '<td>' + data.price + '</td>';
                tr += '<td>' + data.seat + '</td>';
                tr += '<td>' + data.user_username + '</td>';
                tr += '<td><button class="ticketsAdminEdit" href="#updateTicketModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="ticketsAdminDelete" class="trigger-btn" data-toggle="modal" onclick="deleteTicket(' + "\'" + data.id + "\'" + ')">Borrar</button></td>';
                tr += '</tr>';
                $('#ticketsAdminTable').append(tr);
                break;
            }
            case 7:
            {
                tr += '<td>' + data.id + '</td>';
                // Route data
                var route = {
                    "id": data.route_id
                }
                $.ajax({
                    url: '/lab01_frontend1/servletSearch/route',
                    data: route,
                    type: 'post',
                    cache: false,
                    async: false,
                    success: function (a) {
                        tr += '<td>' + a["route"]["destination"] + '</td>';
                        tr += '<td>' + a["route"]["origin"] + '</td>';
                    },
                    error: function () {
                        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
                        jQuery("#errorModal").modal('show');
                    }
                }
                );
                // Schedule data
                var schedule = {
                    "id": data.schedule_id
                }
                $.ajax({
                    url: '/lab01_frontend1/servletSearch/schedule',
                    data: schedule,
                    type: 'post',
                    cache: false,
                    async: false,
                    success: function (b) {
                        tr += '<td>' + b["schedule"]["date_time"] + '</td>';
                    },
                    error: function () {
                        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Error con los datos.</p>');
                        jQuery("#errorModal").modal('show');
                    }
                }
                );
                tr += '<td><button class="checkout" href="#checkoutModal" class="trigger-btn" data-toggle="modal" onclick="flight_id_set(' + "\'" + data.id + "\'" + ')">Comprar ticket</button></td>';
                tr += '</tr>';
                $('#fligthsSearch').append(tr);
                break;
            }
            case 8:
            {
                console.log(data);
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.flight_id + '</td>';
                tr += '<td>' + data.price + '</td>';
                tr += '<td>' + data.discount + '</td>';
                tr += '<td>' + data.seat + '</td>';
                tr += '<td>' + data.user_username + '</td>';
                tr += '</tr>';
                $('#ticketsClientTable').append(tr);
                break;
            }
        }
    }
}


// Delete

function deleteFlight(id) {
    var jsonUser = {
        "id": id,
    }
    $.ajax({
        url: "/lab01_frontend1/servletDelete/vuelo",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Vuelo eliminado satisfactoriamente.</p>');
                $('#flightsAdminFlights').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Este vuelo tiene tickets asociados. No se puede eliminar.</p>');
                $('#flightsAdminFlights').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

function deleteRoute(id) {
    var jsonUser = {
        "id": id,
    }
    $.ajax({
        url: "/lab01_frontend1/servletDelete/ruta",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ruta eleminada satisfactoriamente.</p>');
                $('#flightsAdminRoutes').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Esta ruta tiene vuelos asociados. No se puede eliminar.</p>');
                $('#flightsAdminRoutes').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

function deleteAirplane(id) {
    var jsonUser = {
        "id": id,
    }

    console.log(jsonUser)
    $.ajax({
        url: "/lab01_frontend1/servletDelete/avion",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Avion eliminado satisfactoriamente.</p>');
                $('#flightsAdminAirplanes').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Esta avion tiene vuelos asociados. No se puede eliminar.</p>');
                $('#flightsAdminAirplanes').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

function deleteSchedule(id) {
    var jsonUser = {
        "id": id,
    }

    console.log(jsonUser)
    $.ajax({
        url: "/lab01_frontend1/servletDelete/horario",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Horario eliminado satisfactoriamente.</p>');
                $('#flightsAdminSchedules').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Este horario tiene vuelos asociados. No se puede eliminar.</p>');
                $('#flightsAdminSchedules').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

function deletePassanger(id) {
    var jsonUser = {
        "id": id,
    }

    console.log(jsonUser)
    $.ajax({
        url: "/lab01_frontend1/servletDelete/registro",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Pasajero eliminado satisfactoriamente.</p>');
                $('#flightsAdminPassangers').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Este pasajero tiene tickets asociados. No se puede eliminar.</p>');
                $('#flightsAdminPassangers').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

function deleteTicket(id) {
    var jsonUser = {
        "id": id,
    }

    console.log(jsonUser)
    $.ajax({
        url: "/lab01_frontend1/servletDelete/tiquete",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            if (data.delete) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Ticket eliminado satisfactoriamente.</p>');
                $('#flightsAdminTickets').modal('hide')
                jQuery("#successModal").modal('show');
            } else {
                jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Este ticket tiene pasajeros asociados. No se puede eliminar.</p>');
                $('#flightsAdminTickets').modal('hide')
                jQuery("#errorModal").modal('show');
            }
        },
        error: function () {
            alert("algo salio mal");
        }
    });
}

// Web Sockets
var socket = new WebSocket("ws://" + document.location.host + "/lab01_frontend1/" + "reload");

function addsession() {
    socket = new WebSocket("ws://" + document.location.host + "/lab01_frontend1/" + "reload");
    socket.addEventListener('open', function (evt) {
        console.dir('conectando');
    });
    socket.addEventListener('message', function (evt) {
        console.dir(evt.data);
        if (evt.data.toString() === 'actualizar') {
            window.location.reload();
        }
    });
}

function notifyAll() {
    setTimeout(function () {
        console.dir(socket);
        socket.send('actualizar');
    }, 1000);
}
