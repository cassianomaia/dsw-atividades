<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../helpers/header.jsp" />

<style>
    <%@include file="../css/estilo.css"%>
</style>


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
    <section class="OpcoesIndex">
        <div class="container-sessoes-index">
            <h2 class="titulo-sessoes-index">Gerenciamento de Usuários</h2>
            <ul>
                <li class="itemestaticomenu">Menu usuário</li>
                <li><a class="button" href="cadastro">Adicionar novo Usuário</a></li>
                <li><a class="button" href="lista">Lista de Usuários</a></li>
            </ul>
        </div>
    </section>
</center>
<div align="center">
    <c:if test="${usuario != null}">
        <form action="atualizacao" method="post">
        </c:if>
        <c:if test="${usuario == null}">
            <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <!--<caption>-->
                <h2>
                    <c:if test="${usuario != null}">
                        Edição
                    </c:if>
                    <c:if test="${usuario == null}">
                        Cadastro
                    </c:if>
                </h2>
                <!--                </caption>-->
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
                        <input type="email" name="email" size="50" required
                               value="<c:out value='${usuario.email}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Senha: </th>
                    <td>
                        <input type="password" name="senha"
                               value="<c:out value='${usuario.senha}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Data nascimento: </th>
                    <td>
                        <input type="date" name="data_nascimento"
                               value="<c:out value='${usuario.data_nascimento}' />"
                               />
                    </td>
                </tr>
                <tr>
                    <th>Telefone: </th>
                    <td>
                        <input type="text" name="telefone" maxlength="13" OnKeyPress="formatar('##-#####-####', this)"
                               value="<c:out value='${usuario.telefone}'/>"/>
                    </td>
                </tr>
                <tr>
                    <th>Sexo: </th>
                    <td>
                        <input type="text" name="sexo"
                               value="<c:out value='${usuario.sexo}' />"
                               />
                    </td>

                </tr>
                <tr>
                    <th>CPF: </th>
                    <td>
                        <input type="text" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)"
                               required value="<c:out value='${usuario.cpf}'/>"/>
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