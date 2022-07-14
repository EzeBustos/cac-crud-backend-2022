<div class="modal fade" id="modalAgregarAlumno" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Convocar jugador</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formAgregarAlumno" action="${pageContext.request.contextPath}/app?accion=add"
                  method="post" class="was-validated">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="apellido" class="form-label">Apellido</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" required>
                        </div>
                        <div class="row  mb-3 align-items-center">
                            <div class="col-sm-4">
                              <label for="edad" class="col-form-label">Edad</label>
                              <input type="number" id="edad" min="18" class="form-control" name="edad" required>
                            </div>
                        
                            <div class="col-sm-4">
                              <label for="estatura" class="col-form-label">Estatura</label>
                              <input type="text" id="estatura" class="form-control" name="estatura" required>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 mb-3">
                            <label for="posicion" class="form-label">Pocisión</label>
                            <select class="form-select is-invalid" id="posicion" name="posicion" required aria-label="select example" >
                                <option selected value="">Seleccionar posición</option>
                                <option value="Arquero">Arquero</option>
                                <option value="Defensor">Defensor</option>
                                <option value="Mediocampista">Mediocampista</option>
                                <option value="Delantero">Delantero</option>
                            </select>
                        </div>
                        
                        <div class="col-sm-6 mb-3">
                            <label for="equipo" class="form-label">Equipo actual</label>
                            <input type="text" class="form-control" id="equipo" name="equipo" required>
                        </div>                        
                        <div class="col-12 mb-3">
                            <label for="foto" class="form-label">Cargar foto</label>
                            <input type="file" class="form-control" id="inputFoto" name="foto">
                            <input type="hidden" id="fotoBase64" name="fotoBase64">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-success">Fichar</button>
                </div>
            </form>
        </div>
    </div>
</div>