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
            <ul>
                <li><a href="/atividade01/usuario/"> Usuários </a></li>
                <li> <a href="/atividade01/locadora/"> Locadora </a></li>
                <li> <a href="/atividade01/locacao/"> Locacao </a></li>
            </ul>

        </div>

    </section>
        <div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Locadoras</h2></caption>
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>CNPJ</th>
            <th>Cidade</th>
        </tr>
        <c:forEach var="locadora" items="${requestScope.listaLocadora}">
            <tr>
                <td><c:out value="${locadora.nome}" /></td>
                <td><c:out value="${locadora.email}" /></td>
                <td><c:out value="${locadora.cnpj}" /></td>
                <td><c:out value="${locadora.cidade}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
