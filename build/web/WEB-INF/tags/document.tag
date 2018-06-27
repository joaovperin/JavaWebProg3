<%@tag description="Document tag" pageEncoding="UTF-8"%>
<%@attribute name="title" required="false" description="View title" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            input {margin-bottom: 12px;}
            .msg{color: #1AC03B; font-weight: 300; font-size: 32px;}
            .error-msg{color: red; font-weight: 300; font-size: 32px;}
        </style>
    </head>
    <body>
        <jsp:doBody />
    </body>
</html>
