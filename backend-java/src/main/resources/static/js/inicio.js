//Muestra el segmento de Contacto
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('extension').addEventListener('click', function () {
        const contacto = document.getElementById('contacto');
        const extension = document.getElementById('extension');
        if (contacto.style.display === 'none') {
            contacto.style.display = 'block';
            extension.textContent = 'Cerrar';
        } else {
            contacto.style.display = 'none';
            extension.textContent = 'Contacto';
        }
    });
});

//Acceder a la interfaz grilla
function validarContrasena() {
    // Obtener el valor ingresado en el campo de contraseña
    var usuario = document.getElementById('usuario').value
    var contrasena = document.getElementById('contrasena').value;

    
    // Verificar de credenciales
    if (usuario === 'test'){
        if (contrasena === '1234') {
        // Redirigir a la página si la contraseña es correcta
        window.location.href = 'principal';
    }
    else{
        alert('Contraseña incorrecto. Inténtelo de nuevo.')
    }
    
    }else if (usuario === 'admin'){
        if (contrasena === '1234') {
        // Redirigir a la página si la contraseña es correcta
        window.location.href = 'admin';
    }
    else{
        alert('Contraseña incorrecto. Inténtelo de nuevo.')
    }
    
    } else {
        // Mostrar un mensaje de error si la contraseña es incorrecta
        alert('Usuario incorrecta. Inténtelo de nuevo.');
    }
}
