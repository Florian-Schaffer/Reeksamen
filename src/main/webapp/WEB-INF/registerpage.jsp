<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="Enter a valid email">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Password</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control" type="password" name="password1"  value="${param.password1}"  placeholder="Enter your password">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password2">Password</label>
                    <div class="col-sm-4">
                        <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}"  placeholder="Repeat the password">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="name">Full Name</label>
                    <div class="col-sm-4">
                        <input id="name" class="form-control" type="text" name="name" value="${param.name}" placeholder="Your name">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="phone">Phone Nr.</label>
                    <div class="col-sm-4">
                        <input id="phone" class="form-control" type="text" name="phone" value="${param.phone}" placeholder="Enter a phone number">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="role">Role.</label>
                    <div class="col-sm-4">
                        <input id="role" class="form-control" type="text" name="role" value="${param.role}" placeholder="Choose a role">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">


                <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/adminpage"><btn-text> Tilbage </btn-text> </a>
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


