document.addEventListener("DOMContentLoaded", function () {
    const colorOptions = document.querySelectorAll(".color");

    colorOptions.forEach(color => {
        color.addEventListener("click", function () {
            // Remover la clase 'active' de todos los puntos de color
            colorOptions.forEach(c => c.classList.remove("active"));
            
            // Agregar la clase 'active' solo al color seleccionado
            this.classList.add("active");
        });
    });
});
