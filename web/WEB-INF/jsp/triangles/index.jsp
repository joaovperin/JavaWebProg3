<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="/WEB-INF/tlds/tags.tld"%>
<t:document>

    <t:content title="Triângulos">
        <center>
            <t:messages msg="${msg}" error="${errorMsg}" />
            <form method="POST" action="${basePath}/triangle">
                <label for="tri-ca">
                    Cateto Adjascente: 
                    <input name="tri-ca" type="number" placeholder="Valor" value="${catetoAdjascente}" autofocus="autofocus" />
                </label>
                <label for="tri-co">
                    Cateto Oposto: 
                    <input name="tri-co" type="number" placeholder="Valor" value="${catetoOposto}" />
                </label>
                <label for="tri-hi">
                    Hipotenusa: 
                    <input name="tri-hi" type="number" placeholder="Valor" value="${hipotenusa}"/>
                </label>
                <input type="submit" value="Enviar" />
        </center>
    </t:content>

</t:document>
