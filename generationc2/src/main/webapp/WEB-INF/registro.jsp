<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
</head>
<body>
    <!--action= ruta donde se envian los parametros-->
    <!--Dos tipos de metodos: get y post-->
    <!--get muestra los parametros-->
    <!--post envia los parametros ocultos-->
    <form action="ruta" method="post">
        <label for="nombre"> >Nombre: </label>
    <input type="text" id="nombre" name="nombre"> <!--Las etiquetas de tipo input se le debe agregar un identificador unico (id)-->
                                                <!--el (name) sirve para capturar y traspasar la informacion hacia el backend, también debe ser único-->
    <br>
    <label for="apellido"> >Apellido:</label>
    <input type="text" id="apellido" name="apellido">

    <br>
    <label for="correo"> >Email:</label>
    <input type="email" id="correo" name="correo"> <!--Existe un tipo email que reconoce el formato del correo-->

    <br>
    <label for="pass"> >Password</label>
    <input type="password" id="pass" name="pass" placeholder="Ingrese password">
    
    <br>
    <input type="submit" value="Enviar">
    </form>

</body>
</html>