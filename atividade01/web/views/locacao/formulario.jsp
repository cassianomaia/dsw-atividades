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
    <h1>Gerenciamento de Locacoes</h1>
    <h2>
        <a href="cadastro">Adicionar nova Locacao</a>
        &nbsp;&nbsp;&nbsp;
        <a href="lista">Lista de Locacoes</a>

    </h2>
</center>
<div align="center">
    <c:if test="${locacao != null}">
        <form action="atualizacao" method="post">
        </c:if>
        <c:if test="${locacao == null}">
            <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <!--<caption>-->
                <h2>
                    <c:if test="${locacao != null}">
                        Edição
                        <input type="hidden" name="id" value="<c:out value='${locacao.id}'/>" /> 
                    </c:if>
                    <c:if test="${locacao == null}">
                        Cadastro
                    </c:if>
                </h2>
                
                <!--                </caption>-->
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" maxlength="18" 
                               required value="<c:out value='${locacao.email}'/>"/>
                    </td>
                </tr>
                <tr>
                    <th>CNPJ: </th>
                    <td>
                        <input type="text" name="cnpj" maxlength="18" OnKeyPress="formatar('##.###.###/####-##', this)"
                               required value="<c:out value='${locacao.cnpj}'/>"/>
                    </td>
                </tr>
                <tr>
                    <th>Data: </th>
                    <td>
                        <input type="date" name="data"
                               value="<c:out value='${locacao.data}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Hora: </th>
                    <td>
                        <input type="text" name="hora" maxlength="5" onkeypress="formatar('##:##', this)"
                               value="<c:out value='${locacao.hora}' />"
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