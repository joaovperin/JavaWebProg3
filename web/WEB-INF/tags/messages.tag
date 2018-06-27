<%@tag description="Messages tag" pageEncoding="UTF-8"%>
<%@attribute name="msg" required="true" description="Message" %>
<%@attribute name="error" required="true" description="Error Message" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top:40px">
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="error-msg">${error}</div>
    </c:if>
    <br/>
</div>