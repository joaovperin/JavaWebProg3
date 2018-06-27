<%@tag description="Buttons tag" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="/WEB-INF/tlds/tags.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title" required="true" description="View title" %>
<div class="center">
    <h1>JavaWebProg3</h1>
    <h2>${title}</h2>
    <jsp:doBody/>
    <t:buttons />
</div>