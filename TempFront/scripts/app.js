const father = document.querySelector('.containerProducto');
const containerCategory = document.querySelector('.containerCategory');
const URLApi = "http://localhost:8082/api-proyecto/productos";
const URLImg = "http://localhost:8082/api-proyecto/img?imageRootName="
let botonFiltro = document.getElementById('categoryFilter')
let botonFiltroAll = document.getElementById('categoryFilterAll')
let btnSiguiente = document.getElementById('btnSiguiente')
let btnAnterior = document.getElementById('btnAnterior')
let pageIndicator = document.getElementById('pageIndicator')
let page = 0;
let totalPage;
let currentPage;
let categories;
let urlToFetch;

const requestOptions = {
    method: "GET",
    mode: "cors"
}



let cargarArticulos = async () => {

    await fetch(urlToFetch, requestOptions)
        .then(response => response.json())
        .then(datos => {
            totalPage = datos.totalPages
            currentPage = datos.number
            let articulos = datos.content
            const fragmento = document.createDocumentFragment();
            father.innerHTML = ''

            articulos.forEach(element => {
                const createElement = document.createElement('div');
                createElement.innerHTML = `
                <p>${element.nombre}</p>
                <p>${element.precio}</p>
                <p>${element.cantidad}</p>
                <p>${element.descripcion}</p>
                <img class="imgProducto" src="${URLImg + element.imagen}" alt="imagen">`;

                fragmento.appendChild(createElement);
            });

            father.appendChild(fragmento);
            pageIndicator.innerHTML = `Pagina ${currentPage + 1} de ${totalPage}`
        })
        .catch(error => {
            console.log(error)
        })


}

async function cargarCategories() {
    let urlCategories = URLApi + '/categories'
    await fetch(urlCategories, requestOptions)
        .then(response => response.json())
        .then(datos => {
            categories = datos;
            const fragment = document.createDocumentFragment();
            for (let index = 0; index < categories.length; index++) {
                let element = categories[index];
                let createElement = document.createElement('div');
                createElement.className = 'containerCategories'
                createElement.innerHTML = `
            <label for="${element}">${element}</label>
            <input type="checkbox" id="${element}" class="category" value="${element}">`
                fragment.appendChild(createElement);

            }
            containerCategory.appendChild(fragment)


        })
        .catch(error => {
            console.log(error)
        })

}


btnSiguiente.addEventListener('click', function () {
    if (currentPage + 1 < totalPage) {
        page++
        urlToFetch = URLApi + '?' + 'page=' + page;
        cargarArticulos()
        pageIndicator.innerHTML = `Pagina ${currentPage + 1} de ${totalPage}`

    } else { alert('Ha llegado a la ultima pagina') }
})

btnAnterior.addEventListener('click', function () {
    if (currentPage > 0) {
        page--
        urlToFetch = URLApi + '?' + 'page=' + page;
        cargarArticulos()
        pageIndicator.innerHTML = `Pagina ${currentPage + 1} de ${totalPage}`
    } else { alert('Ha llegado a la primera pagina') }
})


botonFiltro.addEventListener('click', function () {
    categories = [];
    let category = document.querySelectorAll('.category')

    category.forEach((e) => {
        if (e.checked == true) {
            categories.push(e.value)
            


        }
    })

    let params = new URLSearchParams({ categorias: categories });
    let urlFiltered = URLApi + '/filtered' + '?' + params.toString() + '&' + 'sort=categoria,asc' + '&' + 'page=' + page;
    urlToFetch = urlFiltered;

    cargarArticulos();
});

botonFiltroAll.addEventListener('click', function () {
    urlToFetch = URLApi + '?' + 'page=' + page;
    let category = document.querySelectorAll('.category')
    category.forEach((e) => {
        e.checked = true;
    })
    cargarArticulos();

})

cargarCategories()





/*
let cargarArticuloOld = async () => {

    try {
        let respuesta = await fetch('http://localhost:8082/articulos', {
            method: "GET",
            mode: "cors",
        })


        const datos = await respuesta.json();
        const fragmento = document.createDocumentFragment();

        datos.forEach(element => {
            const createElement = document.createElement('p');
            createElement.innerHTML = `Articulo: ${element.nombre}`;
            fragmento.appendChild(createElement);
        });

        father.appendChild(fragmento);

    } catch (error) {
        console.log(error)
    }



}

cargarArticuloOld();*/


