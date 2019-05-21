<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />

<style>
    <%@include file="../css/estilo.css"%>
</style>

<body>
<center>
    <section class="OpcoesIndex">
        <div class="container-sessoes-index">
            <h2 class="titulo-sessoes-index">Gerenciamento de Locadoras</h2>
            <ul>
                <li class="itemestaticomenu">Menu locação</li>
                <li><a class="button" href="/atividade01/">Inicio</a></li>
                <li><a class="button" href="cadastro">Adicionar nova locação</a></li>
                <li><a class="button" href="lista">Lista de Locações</a></li>
            </ul>
        </div>
    </section>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Locações</h2></caption>
        <tr>
            <th>CPF</th>
            <th>CNPJ</th>
            <th>Data</th>
            <th>Hora</th>
        </tr>
        <c:forEach var="locacao" items="${requestScope.listaLocacao}">
            <tr>


                <td><c:out value="${locacao.cpf}" /></td>
                <td><c:out value="${locacao.cnpj}" /></td>
                <td><c:out value="${locacao.data}" /></td>
                <td><c:out value="${locacao.hora}" /></td>

                <td>
                    <a href="edicao?id=<c:out value='${locacao.id}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id=<c:out value='${locacao.id}' />"
                       onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>