<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />

<style>
    <%@include file="../css/estilo.css"%>
</style>

<body>
    <section class="OpcoesIndex">
        <div class="container-sessoes-index">
            <h2 class="titulo-sessoes-index">Gerenciamento de Locadoras</h2>
            <ul>
                <li class="itemestaticomenu">Gerenciamento</li>
                <li><a class="button" href="/atividade01/"> Inicio</a></li>
                <li><a class="button" href="cadastro">Adicionar nova locadora</a></li>
                <li><a class="button" href="lista">Lista de locadoras</a></li>
            </ul>
        </div>
    </section>

    <div align="center">
        <table border="1" cellpadding="5">
            <h2>Lista de Locadoras</h2>

            <form action="busca" method="post">
                <label for="cidade">Pesquisar por cidade: </label>
                <input type="search" id="cidade" name="cidade">
                <button type="submit">OK</button>
            </form>
            <br></br>

            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>CNPJ</th>
                <th>Cidade</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="locadora" items="${requestScope.listaLocadoras}">
                <tr>


                    <td><c:out value="${locadora.id}" /></td>
                    <td><c:out value="${locadora.nome}" /></td>
                    <td><c:out value="${locadora.email}" /></td>
                    <td><c:out value="${locadora.cnpj}" /></td>
                    <td><c:out value="${locadora.cidade}" /></td>


                    <td>
                        <a href="edicao?id=<c:out value='${locadora.id}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?id=<c:out value='${locadora.id}' />"
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