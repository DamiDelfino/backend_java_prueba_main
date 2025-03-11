window.onload = function () {
    enableMedidas();
    enableLavado();
    enableJuridico();
    
};
// Ejemplo de validación de Bootstrap
(function () {
    'use strict';

    // Obtiene todos los formularios que necesitan ser validados
    var forms = document.querySelectorAll('.needs-validation');

    // Agrega el evento submit a cada formulario
    Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
})();




function enableLavado() {
    // Obtiene el valor del select
    const selectValue = document.getElementById("enableSelect").value;
    // Obtiene todos los inputs del segundo grupo
    const grupoMedidasInputs = document.querySelectorAll("#lavado");

    // Habilita los inputs del segundo grupo si no está seleccionada la primera opción del select
    if (selectValue === "Lavado") {
        grupoMedidasInputs.forEach(input => {
            input.disabled = false;
        });
    } else {
        // Deshabilita el segundo grupo si la primera opción está seleccionada
        grupoMedidasInputs.forEach(input => {
            input.disabled = true;
        });
    }
}
function enableSentencia() {
    // Obtiene el valor del select de sentencia
    const selectValue = document.getElementById("selectOption").value;
    // Obtiene todos los elementos con la clase textInput para habilitarlos o deshabilitarlos
    const inputs = document.querySelectorAll("#textInput");

    inputs.forEach(input => {
        input.disabled = selectValue === "NO"; // Deshabilita si es "NO", habilita si es "SI"
    });
}
function enableContadores() {
    // Obtiene el valor del select de sentencia
    const selectValue = document.getElementById("selectOptions").value;
    // Obtiene todos los elementos con la clase textInput para habilitarlos o deshabilitarlos
    const inputs = document.querySelectorAll("#textInputs");

    inputs.forEach(input => {
        input.disabled = selectValue === "NO"; // Deshabilita si es "NO", habilita si es "SI"
    });
}
function enableInputs() {
    // Obtiene el primer input
    const firstInput = document.getElementById("firstInput");
    // Obtiene todos los inputs adicionales
    const otherInputs = document.querySelectorAll("#additionalInput");

    // Habilita los otros inputs solo si el primero tiene valor
    if (firstInput.value.trim() !== "") {
        otherInputs.forEach(input => {
            input.disabled = false;
        });
    } else {
        // Si se borra el texto del primer input, se vuelven a deshabilitar
        otherInputs.forEach(input => {
            input.disabled = true;
        });
    }
}
function enableSecondTable() {
    // Selecciona todos los inputs de la primera tabla
    const firstTableInputs = document.querySelectorAll("#pf");

    // Selecciona los inputs de la segunda tabla
    const secondTableInputs = document.querySelectorAll("#desbloquear");

    // Verifica si algún input de la primera tabla tiene contenido
    let isAnyInputFilled = false;
    firstTableInputs.forEach(input => {
        if (input.value.trim() !== "") {
            isAnyInputFilled = true;
        }
    });

    // Habilita o deshabilita los inputs de la segunda tabla según el estado
    secondTableInputs.forEach(input => {
        input.disabled = !isAnyInputFilled;
    });
}
function enableVehiculoJuridica() {
    // Obtiene el valor del select de sentencia
    const selectValue = document.getElementById("selectOpt").value;
    // Obtiene todos los elementos con la clase textInput para habilitarlos o deshabilitarlos
    const inputs = document.querySelectorAll("#juridica");

    inputs.forEach(input => {
        input.disabled = selectValue === "NO"; // Deshabilita si es "NO", habilita si es "SI"
    });
}
function enableMedidas() {
    // Obtiene el valor del select
    const selectValue = document.getElementById("medidas").value;
    // Obtiene todos los inputs del segundo grupo
    const grupoMedidasInputs = document.querySelectorAll(".grupoMedidas");

    // Habilita los inputs del segundo grupo si no está seleccionada la primera opción del select
    if (selectValue !== "default") {
        grupoMedidasInputs.forEach(input => {
            input.disabled = false;
        });
    } else {
        // Deshabilita el segundo grupo si la primera opción está seleccionada
        grupoMedidasInputs.forEach(input => {
            input.disabled = true;
        });
    }
}
function enableJuridico() {
    // Obtiene el valor del select
    const selectValue = document.getElementById("juridico").value;
    // Obtiene todos los inputs del segundo grupo
    const grupoMedidasInputs = document.querySelectorAll(".grupoJuridico");

    // Habilita los inputs del segundo grupo si no está seleccionada la primera opción del select
    if (selectValue !== "default") {
        grupoMedidasInputs.forEach(input => {
            input.disabled = false;
        });
    } else {
        // Deshabilita el segundo grupo si la primera opción está seleccionada
        grupoMedidasInputs.forEach(input => {
            input.disabled = true;
        });
    }
}

function enableCooperacion(){
    const selectValue = document.getElementById("cooperacion").value;

    const grupoCooperacionInputs = document.querySelectorAll(".grupoCooperacion");

    if (selectValue !== "default"){
        grupoCooperacionInputs.forEach(input =>{
            input.disabled = false;
        });
    }else{
        grupoCooperacionInputs.forEach(input =>{
            input.disabled = true;
        });
    }
}
