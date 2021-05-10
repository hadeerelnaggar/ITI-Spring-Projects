<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>${title}</title>
        </head>

        <body>
            <h3 style="color: red;">${error}</h3>
            <h3>${msg}</h3>
            <form name="loginForm" action="<c:url value='/submitlogin'/>" method="POST">
                User:<input type="text" name="userName"/>
                Password:<input type="password" name="password"/>
                <input type="checkbox" name="remember-me" value="remember me"/>
                <input type="submit" value="submit"/>
                <input type="hidden" name=${_csrf.parameterName} value="${_csrf.token}"/>
            </form>
        </body>

        </html>