<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Ocurrió un error</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />
<jsp:include page="WEB-INF/pages/comunes/nav.jsp" />

<section class="py-3">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-6" >
                <img class="card-img-top" src="assets/higua-error.png" alt="Imagen de error" />
            </div>
            <div class="col-6" >
                <h1 class="h3 text-danger">Error 404: Recurso no encontrado</h1>
                <p class="lead">Parece que le erraste...</p>
            </div>
        </div>
    </div>
</section>

<jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp" />