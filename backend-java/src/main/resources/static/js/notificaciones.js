const data = {
     "2025": {
        tasks: [
            { title: "Proyecto nuevo - 15/03/2025", details: "Organizar reunión inicial con el equipo y definir tareas. Responsable: Ana." }
        ],
        file: "../imagenes/MODELO NOTA-Req2.pdf"
    },
     "2024": {
        tasks: [
            { title: "Notificación 09/10/2024", details: "Recordatorio actualización OCDE." },
            { title: "Notificación 08/10/2024", details: "Recuerde si existe una nueva causa, ingresarla mediante el botón Nueva Respuesta." },
            { title: "Notificación 28/09/2024", details: "Recordatorio actualización OCDE." },
            { title: "Notificación 02/08/2024", details: "Se habilitan las causas de OCDE para su edición." }
        ],
        file: "../imagenes/MODELO NOTA-Req1.pdf"
    }
};

function updateTasksAndFile() {
    const filter = document.getElementById("filter").value;
    const taskList = document.getElementById("taskList");
    const fileLink = document.getElementById("fileLink");

    // Actualizar lista de tareas
    taskList.innerHTML = "";
    data[filter].tasks.forEach(task => {
        const taskDiv = document.createElement("div");
        taskDiv.classList.add("task", "mb-3");

        const taskTitle = document.createElement("h5");
        taskTitle.classList.add("font-weight-bold");
        taskTitle.textContent = task.title;

        const taskDetails = document.createElement("p");
        taskDetails.textContent = task.details;

        taskDiv.appendChild(taskTitle);
        taskDiv.appendChild(taskDetails);
        taskList.appendChild(taskDiv);
    });

    // Actualizar archivo
    fileLink.href = data[filter].file;
    fileLink.textContent = data[filter].file.split("/").pop(); // Mostrar solo el nombre del archivo
}

// Inicializar la página con las tareas y el archivo por defecto
updateTasksAndFile();