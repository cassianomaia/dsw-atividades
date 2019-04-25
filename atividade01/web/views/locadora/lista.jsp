<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />
<body>
<center>
    <h1>Gerenciamento de Locadoras</h1>
    <h2>
        <a href="cadastro">Adicionar nova Locadora</a>
        &nbsp;&nbsp;&nbsp;
        <a href="lista">Lista de Locadoras</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Locadoras</h2></caption>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Telefone</th>
            <th>Sexo</th>
            <th>CPF</th>
            <th>Ativo</th>
        </tr>
        <c:forEach var="usuario" items="${requestScope.listaUsuario}">
            <tr>
                <td><c:out value="${usuario.id}" /></td>
                <td><c:out value="${usuario.nome}" /></td>
                <td><c:out value="${usuario.email}" /></td>
                <td><c:out value="${usuario.senha}" /></td>
                <td><c:out value="${usuario.telefone}" /></td>
                <td><c:out value="${usuario.sexo}" /></td>
                <td><c:out value="${usuario.cpf}" /></td>
                <td><c:out value="${usuario.ativo}" /></td>
                <td>
                    <a href="edicao?id=<c:out value='${usuario.id}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="remocao?id=<c:out value='${usuario.id}' />"
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