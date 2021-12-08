
$(document).ready(function() {

	$("#btn_enviar").click(function(e) {
		e.preventDefault();
		validar();
	});
	
	$('#correo').blur(function () {
            $('#info').html("");
            var correo = $(this).val();
            var correo_actaul = $("#correo_actual").text();
            var dataString = 'correo=' + correo + "&peticion=correo";
            var cont = "";

            if (correo.indexOf('@', 0) === -1 || correo.indexOf('.', 0) === -1) {
                cont = '<small>El correo introducido no es valido.</small>';
                $('#info').fadeIn(1000).html(cont);
                $("#flag").text("1");
                return false;
            }else{
                $("#flag").text("0");
            }

            if (correo !== "" && correo_actaul !== correo) {
               // $('#info').html('<img style = "width: 25%" src="../img/cargando.gif" alt="" />').fadeOut(1000);
                $.ajax({
                    type: "POST",
                    url: "FrontController",
                    data: dataString + "&comando=Registro",
                    success: function (data) {
                        var cont = "";
                        data === "1" ? cont = "<span><small>Correo en uso </small><i class='glyphicon glyphicon-remove'></i></span>" :
                            cont = "<span class='green-text'><small>Correo valido </small><i class='glyphicon glyphicon-ok'></i></span>";
                        $('#info').fadeIn(1000).html(cont);
                        $("#flag").text(data);
                    }
                });
            }
        });


	
	$('#usuario').blur(function () {
            $('#info_usuario').html("");
            var usuario = $(this).val();
            var dataString = 'usuario=' + usuario + "&peticion=usuario";
            var cont = "";
            var usuarioActual = $("#usuario_actual").text();

           if(usuario !== "" && usuarioActual !== usuario){
            $.ajax({
                type: "POST",
                url: "FrontController",
                data: dataString+"&comando=Registro",
                success: function (data) {
                    var cont = "";
                    data === "1" ? cont = "<span><small>Usuario en uso </small><i class='glyphicon glyphicon-remove'></i></span>" :
                            cont = "<span class='green-text'><small>Usuario valido </small><i class='glyphicon glyphicon-ok'></i></span>";
                    $("#validacion_usuario").text(data);
                    $('#info_usuario').html(cont);

                }
            });
           }
        });

});

function validar() {

	var nombre = $("#nombre").val();
	var ap_paterno = $("#ap_paterno").val();
	var ap_materno = $("#ap_materno").val();
	var correo = $("#correo").text();
	var idioma = 0;
	var flag = $("#flag").text();
	var validacionUsuario = $("#validacion_usuario").text();
	var usuario = $("#usuario").val();
	var contrasenia = $("#password").val();
	var repiteContrasenia = $("#confirmarpass").val();


	if ((nombre && ap_paterno && ap_materno && usuario && contrasenia && repiteContrasenia).length !== 0
			&& flag !== "1" && validacionUsuario !== "1" && (contrasenia === repiteContrasenia)) {
		$("#datos").submit();
	} else {
		$("#aviso").text("Por favor verifica tus datos");
	}

}