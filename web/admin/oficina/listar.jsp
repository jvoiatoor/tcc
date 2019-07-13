<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="card ">
    <div class="card-header">
        <h4 class="card-title">Serviços</h4>
    </div>
    <div class="card-body">
                 
        <div class="row">
            <c:forEach items="${lista}" var="obj">
            <div class="col-md-4">

                                    
    <div class="card" style="width: 10rem;">
    <img class="card-img-top" src="../../arquivos/${obj.endFoto}">
    <div class="card-body">
    <p class="card-text">${obj.nome}</p>
    </div>
    </div>

    </div>
            </c:forEach>
            </div>
    <div class="card-footer">
        <c:if test = "${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="tim-icons icon-simple-remove"></i>
                </button>
            </div>
        </c:if>
    </div>
</div>

<%@include file="../rodape.jsp" %>