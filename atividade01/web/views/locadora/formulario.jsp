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
    <c:if test="${locadora != null}">
        <form action="atualizacao" method="post">
        </c:if>
        <c:if test="${locadora == null}">
            <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${locadora != null}">
                            Edição
                        </c:if>
                        <c:if test="${locadora == null}">
                            Cadastro
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${locadora != null}">
                    <input type="hidden" name="id" value="<c:out value='${locadora.id}' />" />
                </c:if>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="nome" size="50" required
                               value="<c:out value='${locadora.nome}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="50" required
                               value="<c:out value='${locadora.email}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Senha: </th>
                    <td>
                        <input type="text" name="senha" size="50" required
                               value="<c:out value='${locadora.senha}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>CNPJ: </th>
                    <td>
                        <input type="number" name="cnpj" required
                               min="0.01" step="any" size="5"
                               value="<c:out value='${locadora.cnpj}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Cidade: </th>
                    <td>
                        <input type="text" name="cidade" size="50" required
                               value="<c:out value='${locadora.cidade}' />"
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