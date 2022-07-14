<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../comunes/inicioHTML.jsp"/>

<jsp:include page="../comunes/inicioHead.jsp"/>
<title>Editando a ${alumnoAEditar.nombreCompleto}</title>
<jsp:include page="../comunes/finHead.jsp"/>

<jsp:include page="../comunes/nav.jsp"/>

<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Editando jugador</h1>
            <p class="lead">Estás a punto de realizar cambios sobre ${alumnoAEditar.nombreCompleto}. No olvides "Confirmar cambios".</p>
        </div>
    </div>
    <div class="container px-4 mt-3">
        <div class="row align-items-center">
            <div class="col-md-5 col-lg-4" >
                <div class="card border p-4 rounded-3 bg-light">
                    <img class="card-img-top" src="${alumnoAEditar.foto}" alt="Foto de ${alumnoAEditar.nombreCompleto}" />
                    <div class="card-body pb-0">
                        <div class="text-center">
                            <h5 class="fw-bolder">${alumnoAEditar.nombreCompleto}</h5>
                            <p class="mb-1">${alumnoAEditar.edad} años ${alumnoAEditar.altura} mts</p>
                            <p class="mb-1">Posicion ${alumnoAEditar.posicion}</p> 
                            <p class="mb-1">Equipo ${alumnoAEditar.equipoActual}</p>                           
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-7 col-lg-8" >
                <form id="formAgregarAlumno" action="${pageContext.request.contextPath}/app?accion=update&id=${alumnoAEditar.id}"
                      method="post" class="was-validated border p-4 rounded-3 bg-light">
                    <div class="row">
                        <div class="col-sm-6 mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value="${alumnoAEditar.nombre}" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="apellido" class="form-label">Apellido</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" value="${alumnoAEditar.apellido}" required>
                        </div>
                        <div class="row  mb-3 align-items-center">
                            <div class="col-sm-4">
                              <label for="edad" class="col-form-label">Edad</label>
                              <input type="number" id="edad" min="18" class="form-control" name="edad" value="${alumnoAEditar.edad}" required>
                            </div>
                        
                            <div class="col-sm-4">
                              <label for="estatura" class="col-form-label">Estatura</label>
                              <input type="text" id="estatura" class="form-control" name="estatura" value="${alumnoAEditar.altura}" required>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 mb-3">
                            <label for="posicion" class="form-label">Pocisión</label>
                            <select class="form-select is-invalid" id="posicion" name="posicion" required aria-label="select example" >
                                <option selected value="${alumnoAEditar.posicion}">${alumnoAEditar.posicion}</option>
                                <option value="Arquero">Arquero</option>
                                <option value="Defensor">Defensor</option>
                                <option value="Mediocampista">Mediocampista</option>
                                <option value="Delantero">Delantero</option>
                            </select>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="equipo" class="form-label">Equipo actual</label>
                            <input type="text" class="form-control" id="equipo" name="equipo" value="${alumnoAEditar.equipoActual}"required>
                        </div>                        

                        <div class="col-12 mb-3">
                            <label for="foto" class="form-label">
                                <c:choose>
                                    <c:when test="${yaTieneFoto}">Modificar</c:when>
                                    <c:otherwise>Agregar</c:otherwise>
                                </c:choose>
                                foto
                            </label>
                            <input type="file" class="form-control" id="inputFoto" name="foto">
                            <input type="hidden" id="fotoBase64" name="fotoBase64" value="${alumnoAEditar.foto}}">
                        </div>
                    </div>
                    <div class="row justify-content-end mt-2">
                        <div class="col-12">
                            <div class="float-end">
                                <a href="${pageContext.request.contextPath}/app" class="btn btn-secondary">Volver atrás</a>
                                <button type="submit" class="btn btn-warning">Confirmar cambios</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script src="scripts/fotobase64.js"></script>
<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>


