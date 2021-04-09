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
            "                   <li class='nav-item'><a class='nav-link js-scroll-trigger'  href='#registerModal'data-toggle='modal'>Registro</a></li>" +
            "                   <li class='nav-item'><a class='nav-link js-scroll-trigger' href='#loginModal' class='trigger-btn' data-toggle='modal'>Ingresar</a></li>" +
            "               </ul>" +
            "           </div>" +
            "       </div>" +
            "   </nav>"
}

// Logout of system
function logout() {
    window.sessionStorage.removeItem("user");
    window.sessionStorage.removeItem("name");
    window.sessionStorage.removeItem("role");
    window.location.reload();
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

document.addEventListener("DOMContentLoaded", loaded);