<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="helpers/header.jsp" />
<style>
    <%@include file="css/estilo.css"%>
</style>

<body>
    <section class="OpcoesIndex">
        <div class="container-sessoes-index">
            <h2 class="titulo-sessoes-index">Bem-vindo</h2>
            <ul id="opcoes">
                <li class="itemestaticomenu">Gerenciamento</li>
                <li><a href="/atividade01/usuario/" class = "button"> Usuários </a></li>
                <li> <a href="/atividade01/locadora/" class = "button"> Locadora </a></li>
            </ul>

        </div>

    </section>
</body>
</html>
