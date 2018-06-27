<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="/WEB-INF/tlds/tags.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:document>

    <t:content title="Usuários">
        <center>
            <t:messages msg="${msg}" error="${errorMsg}" />
            <form method="POST" action="${basePath}/users">
                <label for="usr-nome">
                    Usuário
                    <input name="usr-nome" type="text" placeholder="Nome" value="${usr.nome}" autofocus="autofocus" />
                </label>
                <label for="usr-email">
                    E-mail
                    <input name="usr-email" type="text" placeholder="E-mail" value="${usr.email}" />
                </label>
                <label for="usr-pass">
                    Senha
                    <input name="usr-pass" type="password" placeholder="Senha" value="${usr.senha}" />
                </label>
                <label for="usr-birth">
                    Nascimento (dd/MM/yyyy)
                    <input name="usr-birth" type="date" placeholder="Nascimento" value="${usr.dataNascimento}" />
                </label>
                <input type="submit" value="Enviar" />
        </center>
        <br/>
        <%-- Grid --%>
        <center>
            <table style="width: 80%; border: solid 3px mediumvioletred; border-collapse: collapse;">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Nascimento</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="usr">
                        <tr style="text-align: left;">
                            <td>${usr.idUsuario}</td>
                            <td>${usr.nome}</td>
                            <td>${usr.endEmail}</td>
                            <td>${usr.fmtDataNascimento()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </center>
    </t:content>

</t:document>
