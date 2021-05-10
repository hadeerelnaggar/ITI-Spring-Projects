<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>logout</title>
    </head>
    <body>
        <form action="<c:url value='/customlogout'/>" method="POST" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <script>
            document.getElementById("logoutForm").submit();
        </script>
    </body>
</html> 