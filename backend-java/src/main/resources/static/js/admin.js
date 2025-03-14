   // Función para aplicar los filtros
   function filtrarCausas() {
    const fechaDesde = document.getElementById("fechaDesde").value;
    const fechaHasta = document.getElementById("fechaHasta").value;
    const requerimiento = document.getElementById("requerimiento").value.toLowerCase();
    const expediente = document.getElementById("expediente").value.toLowerCase();
    const estado = document.getElementById("estadoCausa").value.toLowerCase();
    const usuario = document.getElementById("usuario").value.toLowerCase();
    const filas = document.querySelectorAll("#tablaCausas tr");

    filas.forEach(fila => {
        const fechaFila = fila.cells[0].innerText;
        const expedienteFila = fila.cells[1].innerText;
        const estadoFila = fila.cells[2].innerText.toLowerCase().replace(' ', '');
        const usuarioFila = fila.cells[3].innerText.toLowerCase();
        const requerimientoFila = fila.cells[4].innerText.toLowerCase();

        // Convertir las fechas a objetos Date para comparación
        const fechaFilaDate = new Date(fechaFila);
        const fechaDesdeDate = fechaDesde ? new Date(fechaDesde) : null;
        const fechaHastaDate = fechaHasta ? new Date(fechaHasta) : null;

        const coincideFecha = (!fechaDesdeDate || fechaFilaDate >= fechaDesdeDate) &&
            (!fechaHastaDate || fechaFilaDate <= fechaHastaDate);
        const coincideEstado = !estado || estadoFila === estado;
        const coincideExpediente = !expediente || expedienteFila.toLowerCase().includes(expediente);
        const coincideUsuario = !usuario || usuarioFila.includes(usuario);
        const coincideRequerimiento = !requerimiento || requerimientoFila.toLowerCase().includes(requerimiento);


        fila.style.display = (coincideFecha && coincideEstado && coincideUsuario && coincideRequerimiento && coincideExpediente) ? "" : "none";
    });
}


// Función para borrar filtros y mostrar toda la grilla
function borrarFiltros() {
    const filtros = document.querySelectorAll('.filtro');

    filtros.forEach(filtro => {
        if (filtro.tagName === 'SELECT') {
            filtro.selectedIndex = 0;
        } else if (filtro.tagName === 'INPUT') {
            filtro.value = '';
        }
    });

    // Mostrar todas las filas de la tabla
    const filas = document.querySelectorAll("#tablaCausas tr");
    filas.forEach(fila => {
        fila.style.display = "";
    });
  //  cargarGrillaCompleta(); // Vuelve a mostrar todos los datos
}
// Función para cargar todos los datos en la tabla
/*
function cargarGrillaCompleta() {
    const tabla = document.getElementById('tablaCausas');
    tabla.innerHTML = '';

    const datosCausas = [
        { fecha: '2024-11-01', expediente: '121/TO1', estado: 'Procesado', usuario: 'Juzgado 1', requerimiento:'GAFI' },
        { fecha: '2024-11-28', expediente: '321654/2020', estado: 'En Revision', usuario: 'Juzgado 2', requerimiento:'GAFI' },
        { fecha: '2024-09-12', expediente: '321/2019', estado: 'Para Procesar', usuario: 'Juzgado 3', requerimiento:'OCDE' },
    ];

    datosCausas.forEach(causa => {
        const fila = document.createElement('tr');

        // Asignación dinámica de clase según el estado
        const estadoClase = causa.estado.toLowerCase().replace(' ', '');

        fila.innerHTML = `
    <td>${causa.fecha}</td>
    <td>${causa.expediente}</td>
    <td><span class="estado ${estadoClase}">${causa.estado}</span></td>
    <td>${causa.usuario}</td>
    <td>${causa.requerimiento}</td>
    <td><button class="btn" onclick="visualizar()" id="visualizar">Visualizar</button></td>
`;
        tabla.appendChild(fila);
    });
}*/
function visualizar(){
    window.location.href="form.html";
}



// Cargar todos los datos al cargar la página
//window.onload = cargarGrillaCompleta;