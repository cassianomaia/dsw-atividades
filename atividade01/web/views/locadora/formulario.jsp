<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />
<script>
    function formatar(mascara, documento) {
        var i = documento.value.length;
        var saida = mascara.substring(0, 1);
        var texto = mascara.substring(i)
        if (texto.substring(0, 1) != saida) {
            documento.value += texto.substring(0, 1);
        }
        onlynumber();
    }
    function onlynumber(evt) {
        var theEvent = evt || window.event;
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
        var regex = /^[0-9.]+$/;
        if (!regex.test(key)) {
            theEvent.returnValue = false;
            if (theEvent.preventDefault)
                theEvent.preventDefault();
        }
    }
</script>

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
                <h2>
                    <c:if test="${locadora != null}">
                        Edição
                    </c:if>
                    <c:if test="${locadora == null}">
                        Cadastro
                    </c:if>
                </h2>
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
                        <input type="text" name="email"  size="50" required
                               value="<c:out value='${locadora.email}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Senha: </th>
                    <td>
                        <input type="password" name="senha" required
                               value="<c:out value='${locadora.senha}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>CNPJ: </th>
                    <td>
                        <input type="text" name="cnpj" maxlength="18" OnKeyPress="formatar('##.###.###/####-## ', this)"
                               required value="<c:out value='${locadora.cnpj}'/>"/>
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