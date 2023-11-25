document.addEventListener('DOMContentLoaded', function () {
    // Realizar una solicitud AJAX para obtener los datos de productos
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'PRODUCTO', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Parsear la respuesta JSON
            var productos = JSON.parse(xhr.responseText);

            // Llenar el contenedor con los productos
            cargarProductos(productos);
        }
    };

    xhr.send();
});

function cargarProductos(productos) {
    var container = document.getElementById('productos-container');

    productos.forEach(function (producto) {
        var productCard = document.createElement('div');
        productCard.className = 'product-card';

        productCard.innerHTML = `
            <img src="${producto.imagen}" alt="${producto.nombre}">
            <h3 class="nombre_producto">${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p class="price">${producto.precio}</p>
            <button>Agregar al Carrito</button>
        `;

        container.appendChild(productCard);
    });
}
