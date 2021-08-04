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
        <c:if test = "${sessionScope.role == 'admin'}">
        <table class="table table-striped">


                 <c:forEach var = "item" items="${requestScope.itemList}">

                     <tr>
                         <td>${item.id}</td>
                         <td>${item.description}</td>
                         <td>${item.name}</td>
                         <td>${item.roomNumber}</td>
                         <td>${item.status}</td>
                     </tr>

                     </c:forEach>


        </table>
    </c:if>
        <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/adminpage"><btn-text> Tilbage </btn-text> </a>


    </jsp:body>

</t:genericpage>

