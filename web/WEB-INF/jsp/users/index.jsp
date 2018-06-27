<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="/WEB-INF/tlds/tags.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:document>

    <t:content title="Usuários">
        Insira algum conteúdo aqui...
        <c:if test="${not empty users}">
            <c:forEach var="usr" items="${users}">
                <p>User: ${usr.nome}</p>
            </c:forEach>
        </c:if>
    </t:content>

</t:document>
