// Obtener elementos del DOM
const volumeSlider = document.getElementById("volumeSlider");
const volumeValue = document.getElementById("volumeValue");
const volumeLevel = document.getElementById("volumeLevel");

// Evento para actualizar el volumen
volumeSlider.addEventListener("input", () => {
    const value = volumeSlider.value; // Obtener el valor del rango (0 a 100)
    volumeValue.textContent = value; // Mostrar el valor en el texto

    // Calcular el ángulo del gradiente según el valor
    const degree = (value / 100) * 360;

    // Actualizar el fondo de la capa de nivel de volumen
    volumeLevel.style.background = `conic-gradient(
        lime 0deg,
        yellow ${degree / 1.5}deg,
        red ${degree}deg,
        #222 ${degree}deg
    )`;
});
