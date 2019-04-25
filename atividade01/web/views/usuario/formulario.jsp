<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />
<body>
<center>
    <h1>Gerenciamento de Usuarios</h1>
    <h2>
        <a href="new">Adicionar novo Usuario</a>
        &nbsp;&nbsp;&nbsp;
        <a href="lista">Lista de Usuarios</a>

    </h2>
</center>


<div align="center">
    <c:if test="${usuario != null}">
        <form action="atualizacao" method="post">
        </c:if>
        <c:if test="${usuario == null}">
            <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${usuario != null}">
                            Edição
                        </c:if>
                        <c:if test="${usuario == null}">
                            Cadastro
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${usuario != null}">
                    <input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
                </c:if>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="nome" size="50" required
                               value="<c:out value='${usuario.nome}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="50" required
                               value="<c:out value='${usuario.email}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Senha: </th>
                    <td>
                        <input type="text" name="senha" size="50" required
                               value="<c:out value='${usuario.senha}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Telefone: </th>
                    <td>
                        <input type="number" name="telefone" required
                               min="0.01" step="any" size="5"
                               value="<c:out value='${usuario.telefone}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Sexo: </th>
                    <td>
                        <input type="text" name="sexo" size="50" required
                               value="<c:out value='${usuario.sexo}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>CPF: </th>
                    <td>
                        <input type="text" name="cpf" size="50" required
                               value="<c:out value='${usuario.cpf}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Ativo: </th>
                    <td>
                        <input type="text" name="ativo" size="50" required
                               value="<c:out value='${usuario.ativo}' />"
                               />
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Salva" />
                    </td>
                </tr>
            </table>
        </form>
</div>
<c:if test="${!empty requestScope.mensagens}">
    <ul class="erro">
        <c:forEach items="${requestScope.mensagens}" var="mensagem">
            <li>${mensagem}</li>
            </c:forEach>
    </ul>
</c:if>
</body>
</html>