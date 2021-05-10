<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

            <html>

            <head>
                <title>${title}</title>
            </head>

            <body>
                <h1>
                    Spring Web MVC Hello world
                </h1>
                <h2>welcome:
                    <security:authentication property="principal.username" />
                </h2>
                <h2>${message}</h2>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <h3>Hello admin</h3>
                </security:authorize>
            </body>

            </html>