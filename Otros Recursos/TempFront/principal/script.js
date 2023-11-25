document.addEventListener('DOMContentLoaded', function () {
    let currentIndex = 0;
    const slides = document.querySelectorAll('.carousel-slide');

    function showSlide(index) {
        slides.forEach((slide, i) => {
            slide.style.display = i === index ? 'block' : 'none';
        });
    }

    function nextSlide() {
        currentIndex = (currentIndex + 1) % slides.length;
        showSlide(currentIndex);
    }

    function startCarousel() {
        setInterval(nextSlide, 3000); // Cambia la imagen cada 3 segundos (ajusta según tus necesidades)
    }

    showSlide(currentIndex);
    startCarousel();
});
