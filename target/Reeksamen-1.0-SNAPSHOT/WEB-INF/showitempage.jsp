<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Liste over alt udstyr
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        Her er en liste med alt udstyr:

        <table class="table table-striped">

            <%--<form action ="${pageContext.request.contextPath}/fc/ShowItemsCommand" method="POST"> --%>
                 <c:forEach var = "item" items="${requestScope.itemList}">
                <tr>
                    <td>Item id: ${item.id}.</td>
                    <td>Navn: ${item.name}.</td>
                    <td>Beskrivelse. ${item.description}.</td>
                    <td>Lokale ${item.roomNumber}</td>
                </tr>
                 </c:forEach>


        </table>
        <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/adminpage"><btn-text> Tilbage </btn-text> </a>


    </jsp:body>

</t:genericpage>

