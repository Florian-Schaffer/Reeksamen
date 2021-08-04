<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as an ADMIN of our wonderful site.



        <a href="${pageContext.request.contextPath}/fc/showstudentpage">Vis alle studerende.</a>

        <a href="${pageContext.request.contextPath}/fc/showitempage">Vis alt udstyr.</a>

        <a href="${pageContext.request.contextPath}/fc/registerpage">Opret ny bruger.</a>

    </jsp:body>
</t:genericpage>
