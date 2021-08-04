<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Liste over alle studerende
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        Her er en liste med alle studerende:

        <table class="table table-striped">
            <c:forEach var="student" items="${requestScope.studentList}">


                <tr>
                    <td>${student.id}</td>
                    <td>${student.email}</td>
                    <td>${student.name}</td>
                    <td>${student.phone}</td>
                </tr>


    </c:forEach>


        </table>


        <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/adminpage"><btn-text> Tilbage </btn-text> </a>

    </jsp:body>

</t:genericpage>

