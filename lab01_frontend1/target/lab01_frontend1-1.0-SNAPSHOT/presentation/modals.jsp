<%-- 
    Document   : modals
    Author     : KEVIN
--%>


<!-- Modal Login -->
<div id="loginModal" class="modal fade">
    <div class="modal-dialog modal-login">
        <div class="modal-content">
            <div class="modal-header">				
                <h4 class="modal-title">Iniciar Sesión</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" class="form-control" id="user" placeholder="Correo electrónico" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input class="form-check-input" type="checkbox" onclick="showPassword()">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="password" class="form-control" id="password" placeholder="Contraseña" required="required" autocomplete="on">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary btn-block btn-lg" id='login'>Acceder</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">¿No tienes cuenta? <a href='#registerModal' data-toggle='modal' id="reMod2">Regístrate</a></div>
        </div>
    </div>
</div>


<!-- Modal Register -->
<div id="registerModal" class="modal fade">
    <div class="modal-dialog modal-login">
        <div class="modal-content">
            <div class="modal-header">				
                <h4 class="modal-title">Registro</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="email" class="form-control" id="user_username_rm" placeholder="Usuario" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input class="form-check-input" type="checkbox" onclick="showPasswordRM()">
                            <input type="password" class="form-control" id="password_rm" placeholder="Contraseña" required="required" autocomplete="on">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" id="name_rm" placeholder="Nombre" required="required">
                            <input type="text" class="form-control" id="lastname_rm" placeholder="Apellido" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="number" class="form-control" id="work_phone_rm" placeholder="Teléfono de trabajo" required="required">
                            <input type="number" class="form-control" id="cell_phone_rm" placeholder="Teléfono personal" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" id="address_rm" placeholder="Dirección" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="date" class="form-control" id="dob_rm" placeholder="Fecha de nacimiento" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary btn-block btn-lg" id='register'>Registrarse</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">¿Ya tienes cuenta? <a href='#loginModal' data-toggle='modal' id="logMod">Inicia sesión</a></div>
        </div>
    </div>
</div>
