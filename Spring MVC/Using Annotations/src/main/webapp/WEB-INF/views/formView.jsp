<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <form:form method="POST" modelAttribute="user" action="${contextPath}/users/register">
            <b>Name</b>
            <form:input path="name" />
            <form:errors path="name" />
            <br/>
            <b>Salary</b>
            <form:input path="salary" />
            <form:errors path="salary" />
            <br/>
            <input type="submit" value="Add new User"/>
        </form:form>
    </body>
</html>