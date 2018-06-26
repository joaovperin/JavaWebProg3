<%-- 
    Document   : document
    Created on : 26/06/2018, 19:53:36
    Author     : joaovperin
--%>
<%@tag description="Document tag" pageEncoding="UTF-8"%>
<%@attribute name="title" required="false" description="View title" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(title == null ? "JavaWebProg3" : title);%></title>
        <link rel="stylesheet" type="text/css" href="https://unpkg.com/papercss/dist/paper.min.css">
        <style>
            .center {text-align: center;}
        </style>
    </head>
    <body>
        <jsp:doBody />
    </body>
</html>
