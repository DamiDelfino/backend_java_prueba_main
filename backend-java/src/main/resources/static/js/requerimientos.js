document.addEventListener('DOMContentLoaded', () => {
    const checkAll = document.getElementById('checkAll');
    if (checkAll) {
      checkAll.addEventListener('click', () => seleccionarTodos(checkAll));
    }
  });
  
  
  // Función para seleccionar/deseleccionar todos los checkboxes
  function seleccionarTodos(source) {
    const checkboxes = document.querySelectorAll('.individual-checkbox');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = source.checked; // Marca/desmarca según el estado del checkbox "Todos"
    });
  }
  
  // Función para actualizar el estado del checkbox "Todos"
  function actualizarCheckTodos() {
    const checkboxes = document.querySelectorAll('.individual-checkbox');
    const checkAll = document.getElementById('checkAll');
  
    // Si todos los checkboxes individuales están marcados, marca "Todos"
    const allChecked = Array.from(checkboxes).every((checkbox) => checkbox.checked);
    
    // Si alguno está sin marcar, desmarca "Todos"
    checkAll.checked = allChecked;
  }
  