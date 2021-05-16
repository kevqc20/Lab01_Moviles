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
    var id = document.getElementById("ap_id_em").value;
    var year = document.getElementById("ap_year_em").value;
    var model = document.getElementById("ap_model_em").value;
    var brand = document.getElementById("ap_brand_em").value;
    var cant = document.getElementById("ap_cantmax_em").value;
    var type = document.getElementById("ap_type_em").value;

    var jsonUser = {
        "id": id,
        "year": year,
        "model": model,
        "brand": brand,
        "cant": cant,
        "type": type
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/avion",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">avion agregado con exito.</p>');
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
// Register new rute 
function addNewRute() {
    var id = document.getElementById("rt_id_em").value;
    var origin = document.getElementById("rt_origin_em").value;
    var destination = document.getElementById("rt_destination_em").value;
    var duration = document.getElementById("rt_duration_phone_em").value;

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
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">ruta de vuelo agregada con exito.</p>');
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
    var id = document.getElementById("sh_id_em").value;
    var date = document.getElementById("sh_datetime_em").value;

    var jsonUser = {
        "id": id,
        "date": date
    }

    $.ajax({
        url: "/lab01_frontend1/servletInsert/horario",
        method: "POST",
        data: jsonUser,
        success: function (data) {
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">horario de vuelo agregado con exito.</p>');
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

function addNewTicketArray(flight_id, discount, array) {

    var flight_id = flight_id;
    var discount = discount;
    var seatList = array;
    var user_usuario = window.sessionStorage.user;
    seatList.forEach(function (data) {
        var jsonUser = {
            "id": flight_id+"_"+data.id,
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
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">compra realizada con exito.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#registerModal').modal('hide')
                });
            },
            error: function () {
                alert("algo salio mal");
            }
        });
    });

}

function addNewTicket() {
    var id = document.getElementById("tk_id_em").value;
    var flight_id = document.getElementById("tk_fid_em").value;
    var price = document.getElementById("tk_price_phone_em").value;
    var discount = document.getElementById("tk_discount_phone_em").value;
    var seat = document.getElementById("tk_seat_em").value;
    var user_usuario = document.getElementById("tk_id_user_em").value;


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
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">horario de vuelo agregado con exito.</p>');
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
    var id = document.getElementById("f_id_em").value;
    var rute_id = document.getElementById("f_rid_em").value;
    var airplane_id = document.getElementById("f_apid_em").value;
    var shedule_id = document.getElementById("f_schid_em").value;

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
            jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">horario de vuelo agregado con exito.</p>');
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
function getAirplane() {
    var user = JSON.parse(window.sessionStorage.user);
    if (window.sessionStorage.role === "1") {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/lab01_frontend1/servletList/userList/" + user.username,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    } else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/smartmsphv2/api/v1/officials/" + user.email,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    }
}
// Update Airplane
function updateAirplane() {
    var email = document.getElementById("userU").value;
    var pass = document.getElementById("passwordU").value;
    var name = document.getElementById("nameU").value;
    var lastname = document.getElementById("lastnameU").value;
    var cel = document.getElementById("celU").value;

    if (validateAll()) {
        var lat = markersArray[0].getPosition().toJSON()["lat"];
        var longi = markersArray[0].getPosition().toJSON()["lng"];
        var jsonUser = {
            "email": email,
            "password": pass,
            "role_id_role": window.sessionStorage.role
        }
        var jsonCitizen = {
            "email": email,
            "firstName": name,
            "lastName": lastname,
            "cel_Num": cel,
            "lat": lat,
            "longi": longi
        }

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/users/" + email,
            method: "PUT",
            data: JSON.stringify(jsonUser),
            dataType: 'json',
            contentType: "application/json",
            fail: function (xhr, textStatus, erarorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/citizens/" + email,
            method: "PUT",
            data: JSON.stringify(jsonCitizen),
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#updateModal').modal('hide')
                });
                window.sessionStorage.pass = pass;
                window.sessionStorage.name = name;

            }
        });

    } else {
        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Datos faltantes o incorrectos.</p>');
        jQuery("#errorModal").modal('show');
    }
}
// Get Rute
function getRute() {
    var user = JSON.parse(window.sessionStorage.user);
    if (window.sessionStorage.role === "1") {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/lab01_frontend1/servletList/userList/" + user.username,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    } else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/smartmsphv2/api/v1/officials/" + user.email,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    }
}
// Update Rute
function updateRute() {
    var email = document.getElementById("userU").value;
    var pass = document.getElementById("passwordU").value;
    var name = document.getElementById("nameU").value;
    var lastname = document.getElementById("lastnameU").value;
    var cel = document.getElementById("celU").value;

    if (validateAll()) {
        var lat = markersArray[0].getPosition().toJSON()["lat"];
        var longi = markersArray[0].getPosition().toJSON()["lng"];
        var jsonUser = {
            "email": email,
            "password": pass,
            "role_id_role": window.sessionStorage.role
        }
        var jsonCitizen = {
            "email": email,
            "firstName": name,
            "lastName": lastname,
            "cel_Num": cel,
            "lat": lat,
            "longi": longi
        }

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/users/" + email,
            method: "PUT",
            data: JSON.stringify(jsonUser),
            dataType: 'json',
            contentType: "application/json",
            fail: function (xhr, textStatus, erarorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/citizens/" + email,
            method: "PUT",
            data: JSON.stringify(jsonCitizen),
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#updateModal').modal('hide')
                });
                window.sessionStorage.pass = pass;
                window.sessionStorage.name = name;

            }
        });

    } else {
        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Datos faltantes o incorrectos.</p>');
        jQuery("#errorModal").modal('show');
    }
}
// Get Shedule
function getShedule() {
    var user = JSON.parse(window.sessionStorage.user);
    if (window.sessionStorage.role === "1") {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/lab01_frontend1/servletList/userList/" + user.username,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    } else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/smartmsphv2/api/v1/officials/" + user.email,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    }
}
// Update Shedule
function updateShedule() {
    var email = document.getElementById("userU").value;
    var pass = document.getElementById("passwordU").value;
    var name = document.getElementById("nameU").value;
    var lastname = document.getElementById("lastnameU").value;
    var cel = document.getElementById("celU").value;

    if (validateAll()) {
        var lat = markersArray[0].getPosition().toJSON()["lat"];
        var longi = markersArray[0].getPosition().toJSON()["lng"];
        var jsonUser = {
            "email": email,
            "password": pass,
            "role_id_role": window.sessionStorage.role
        }
        var jsonCitizen = {
            "email": email,
            "firstName": name,
            "lastName": lastname,
            "cel_Num": cel,
            "lat": lat,
            "longi": longi
        }

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/users/" + email,
            method: "PUT",
            data: JSON.stringify(jsonUser),
            dataType: 'json',
            contentType: "application/json",
            fail: function (xhr, textStatus, erarorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/citizens/" + email,
            method: "PUT",
            data: JSON.stringify(jsonCitizen),
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#updateModal').modal('hide')
                });
                window.sessionStorage.pass = pass;
                window.sessionStorage.name = name;

            }
        });

    } else {
        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Datos faltantes o incorrectos.</p>');
        jQuery("#errorModal").modal('show');
    }
}
// Get Ticket
function getTicket() {
    var user = JSON.parse(window.sessionStorage.user);
    if (window.sessionStorage.role === "1") {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/lab01_frontend1/servletList/userList/" + user.username,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    } else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/smartmsphv2/api/v1/officials/" + user.email,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    }
}
// Update Ticket
function updateTicket() {
    var email = document.getElementById("userU").value;
    var pass = document.getElementById("passwordU").value;
    var name = document.getElementById("nameU").value;
    var lastname = document.getElementById("lastnameU").value;
    var cel = document.getElementById("celU").value;

    if (validateAll()) {
        var lat = markersArray[0].getPosition().toJSON()["lat"];
        var longi = markersArray[0].getPosition().toJSON()["lng"];
        var jsonUser = {
            "email": email,
            "password": pass,
            "role_id_role": window.sessionStorage.role
        }
        var jsonCitizen = {
            "email": email,
            "firstName": name,
            "lastName": lastname,
            "cel_Num": cel,
            "lat": lat,
            "longi": longi
        }

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/users/" + email,
            method: "PUT",
            data: JSON.stringify(jsonUser),
            dataType: 'json',
            contentType: "application/json",
            fail: function (xhr, textStatus, erarorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/citizens/" + email,
            method: "PUT",
            data: JSON.stringify(jsonCitizen),
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#updateModal').modal('hide')
                });
                window.sessionStorage.pass = pass;
                window.sessionStorage.name = name;

            }
        });

    } else {
        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Datos faltantes o incorrectos.</p>');
        jQuery("#errorModal").modal('show');
    }
}
// Get Flight
function getFlight() {
    var user = JSON.parse(window.sessionStorage.user);
    if (window.sessionStorage.role === "1") {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/lab01_frontend1/servletList/userList/" + user.username,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    } else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/smartmsphv2/api/v1/officials/" + user.email,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                window.sessionStorage.citizen = JSON.stringify(data);
                fill(user, data);
            },
            error: function (status) {
                document.getElementById("user").setAttribute('class', 'form-control is-invalid');
                document.getElementById("user").setAttribute('title', 'Usuario no existente');
            },
            fail: function (xhr, textStatus, errorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });
    }
}
// Update Flight
function updateFlight() {
    var email = document.getElementById("userU").value;
    var pass = document.getElementById("passwordU").value;
    var name = document.getElementById("nameU").value;
    var lastname = document.getElementById("lastnameU").value;
    var cel = document.getElementById("celU").value;

    if (validateAll()) {
        var lat = markersArray[0].getPosition().toJSON()["lat"];
        var longi = markersArray[0].getPosition().toJSON()["lng"];
        var jsonUser = {
            "email": email,
            "password": pass,
            "role_id_role": window.sessionStorage.role
        }
        var jsonCitizen = {
            "email": email,
            "firstName": name,
            "lastName": lastname,
            "cel_Num": cel,
            "lat": lat,
            "longi": longi
        }

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/users/" + email,
            method: "PUT",
            data: JSON.stringify(jsonUser),
            dataType: 'json',
            contentType: "application/json",
            fail: function (xhr, textStatus, erarorThrown) {
                jQuery("#errorModal").modal('show');
            }
        });

        $.ajax({
            url: "http://localhost:8081/smartmsphv2/api/v1/citizens/" + email,
            method: "PUT",
            data: JSON.stringify(jsonCitizen),
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
                jQuery("#success-text").html('<p style="font-size:25px;" class="text-center">Perfil actualizado.</p>');
                jQuery("#successModal").modal('show');
                $("#successModal").on("hidden.bs.modal", function () {
                    $('#updateModal').modal('hide')
                });
                window.sessionStorage.pass = pass;
                window.sessionStorage.name = name;

            }
        });

    } else {
        jQuery("#error-text").html('<p style="font-size:25px;" class="text-center">Datos faltantes o incorrectos.</p>');
        jQuery("#errorModal").modal('show');
    }
}



// Fill rows with info
function fillWithInformation(data, i) {
    switch (i) {
        case 1:
        {
            // Passangers
            var a = new Date(data['passanger']['dob']);
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
            document.getElementById("userU").value = data1.email;
            document.getElementById("passwordU").value = data1.password;
            document.getElementById("nameU").value = data2['firstName'];
            document.getElementById("lastnameU").value = data2['lastName'];
            document.getElementById("celU").value = data2['cel_Num'];
            break;
        }
        case 3:
        {
            // Rutes
            document.getElementById("userU").value = data1.email;
            document.getElementById("passwordU").value = data1.password;
            document.getElementById("nameU").value = data2['firstName'];
            document.getElementById("lastnameU").value = data2['lastName'];
            document.getElementById("celU").value = data2['cel_Num'];
            break;
        }
        case 4:
        {
            // Shedules
            document.getElementById("userU").value = data1.email;
            document.getElementById("passwordU").value = data1.password;
            document.getElementById("nameU").value = data2['firstName'];
            document.getElementById("lastnameU").value = data2['lastName'];
            document.getElementById("celU").value = data2['cel_Num'];
            break;
        }
        case 5:
        {
            // Tickets
            document.getElementById("userU").value = data1.email;
            document.getElementById("passwordU").value = data1.password;
            document.getElementById("nameU").value = data2['firstName'];
            document.getElementById("lastnameU").value = data2['lastName'];
            document.getElementById("celU").value = data2['cel_Num'];
            break;
        }
        case 6:
        {
            // Flights
            document.getElementById("userU").value = data1.email;
            document.getElementById("passwordU").value = data1.password;
            document.getElementById("nameU").value = data2['firstName'];
            document.getElementById("lastnameU").value = data2['lastName'];
            document.getElementById("celU").value = data2['cel_Num'];
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
                $('#flightsAdminTable').DataTable({
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
function showListFlightsClient() {
    $.ajax({
        type: 'GET',
        url: '/lab01_frontend1/servletList/flightList',
        cache: false,
        success: function (data) {
            list(data, 11);
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
        case 11:
        {
            var listado = document.getElementById("fligthsSearch");
            listado.innerHTML = "";
            data["flightList"].forEach((u) => {
                row(u, 11);
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
                tr += '<td>' + data.route_id + '</td>';
                tr += '<td>' + data.airplaine_id + '</td>';
                tr += '<td>' + data.schedule_id + '</td>';
                tr += '<td><button class="flightsAdminEdit" href="#updateFlightModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="flightsAdminDelete" href="#flightDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
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
                tr += '<td><button class="routesAdminDelete" href="#routeDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
                tr += '</tr>';
                $('#routesAdminTable').append(tr);
                break;
            }
            case 3:
            {
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.year + '</td>';
                tr += '<td>' + data.model + '</td>';
                tr += '<td>' + data.brand + '</td>';
                tr += '<td>' + data.type + '</td>';
                tr += '<td>' + data.cant_max + '</td>';
                tr += '<td><button class="airplanesAdminEdit" href="#updateAirplaneModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += ' <td><button class="airplanesAdminDelete" href="#airplaneDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
                tr += '</tr>';
                $('#airplanesAdminTable').append(tr);
                break;
            }
            case 4:
            {
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.date_time + '</td>';
                tr += '<td><button class="schedulesAdminEdit" href="#updateScheduleModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="schedulesAdminDelete" href="#scheduleDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
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
                tr += '<td><button class="passangerAdminDelete" href="#passangerDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
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
                tr += '<td>' + data.discount + '</td>';
                tr += '<td>' + data.seat + '</td>';
                tr += '<td>' + data.user_username + '</td>';
                tr += '<td><button class="ticketsAdminEdit" href="#updateTicketModal" class="trigger-btn" data-toggle="modal">Editar</button></td>';
                tr += '<td><button class="ticketsAdminDelete" href="#ticketDeleteModal" class="trigger-btn" data-toggle="modal">Borrar</button></td>';
                tr += '</tr>';
                $('#ticketsAdminTable').append(tr);
                break;
            }
            case 11:
            {
                tr += '<td>' + data.id + '</td>';
                tr += '<td>' + data.route_id + '</td>';
                tr += '<td>' + data.airplaine_id + '</td>';
                tr += '<td>' + data.schedule_id + '</td>';
                tr += '<td><button class="checkout" href="#checkoutModal" class="trigger-btn" data-toggle="modal" onclick="flight_id_set(' + data.id + ')">Comprar ticket</button></td>';
                tr += '</tr>';
                $('#fligthsSearch').append(tr);
                break;
            }
        }
    }
}



// Web Sockets
var socket = new WebSocket("ws://localhost:8080/ProgressWebSocket-1.0-SNAPSHOT/progress");
socket.onmessage = onMessage;

function onMessage(event) {
    var btnSubmit = document.getElementById("btnSubmit");
    btnSubmit.disabled = true;

    var progress = document.getElementById("progress");
    var data = JSON.parse(event.data);
    progress.value = data.value;

    var lblProgress = document.getElementById("lblProgress");
    if (data.value < 100) {
        lblProgress.innerHTML = 'Progress: ' + data.value + '%';
    } else {
        btnSubmit.disabled = false;
        lblProgress.innerHTML = "Finish";
    }

}

function formSubmit() {
    socket.send("{\"start\":\"true\"}");
}