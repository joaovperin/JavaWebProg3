<%@tag description="Document tag" pageEncoding="UTF-8"%>
<%@attribute name="title" required="false" description="View title" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(title == null ? "JavaWebProg3" : title);%></title>
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"> 
        <link rel="stylesheet" type="text/css" href="https://unpkg.com/papercss/dist/paper.min.css">
        <style>
            .center {text-align: center;}
        </style>
    </head>
    <body>
        <jsp:doBody />
    </body>
</html>
