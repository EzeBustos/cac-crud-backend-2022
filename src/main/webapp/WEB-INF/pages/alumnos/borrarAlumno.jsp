<jsp:include page="../comunes/inicioHTML.jsp"/>

<jsp:include page="../comunes/inicioHead.jsp"/>
<title>Borrar a ${alumnoAEditar.nombreCompleto}</title>
<jsp:include page="../comunes/finHead.jsp"/>

<jsp:include page="../comunes/nav.jsp"/>

<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Eliminar jugador</h1>
            <p class="lead">Estás a punto quedarte si el jugador ${alumnoABorrar.nombreCompleto}</p>
        </div>        
    </div>
    <div class="container px-4 mt-3">
        <div class="row align-items-center justify-content-center">
            <div class="col-sm-7 col-md-6 col-lg-4" >
                <div class="card border p-4 rounded-3 bg-light">
                    <img class="card-img-top" src="${alumnoABorrar.foto}" alt="Foto de ${alumnoABorrar.nombreCompleto}" />
                    <div class="card-body pb-0">
                        <div class="text-center">
                            <h5 class="fw-bolder">${alumnoABorrar.nombreCompleto}</h5>
                            <p class="mb-1">${alumnoABorrar.edad} años ${alumnoABorrar.altura} mts</p>
                            <p class="mb-1">Posicion ${alumnoABorrar.posicion}</p> 
                            <p class="mb-1">Equipo ${alumnoABorrar.equipoActual}</p> 
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-5 col-md-6 col-lg-4">
                <form action="${pageContext.request.contextPath}/app?accion=delete&id=${alumnoABorrar.id}"
                      method="post" class="was-validated border p-2 rounded-3 bg-light">
                    <div class="row text-center">
                        <div class="col-12 mb-2">
                            <p class="lead m-0">¿Estás seguro de quedarte sin él?</p>
                        </div>
                        <div class="col-12">
                            <a href="${pageContext.request.contextPath}/app" class="btn btn-secondary">mmm... Mejor lo dejo</a>
                            <button type="submit" class="btn btn-danger">Sí, es malo el pobre</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>