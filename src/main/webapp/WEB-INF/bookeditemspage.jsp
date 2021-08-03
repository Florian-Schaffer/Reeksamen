<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Se alle items
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        Her er en liste med alt udstyr:

        <table class="table table-striped">
            <c:if test = "${sessionScope.role == 'admin'}">
            <form action ="${pageContext.request.contextPath}/fc/SeeBookedItemsCommand" method="POST">
                <c:forEach var = "bookedItems" items="${requestScope.bookedItems}">
                <p>Dato: ${bookedItems.bookingDate}. Lånedage: ${bookedItems.days}. status: ${bookedItems.bookingStatus}
                    </c:forEach>
                    </c:if>
                    <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/adminpage"><btn-text> Tilbage </btn-text> </a>


        </table>


    </jsp:body>

</t:genericpage>


