<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Booking page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        her kan du booke udstyr

        <table class="table table-striped">
            <p>Vælg udstyret du gerne vil låne</p>
            <div class="form-group">
                <label for="udstyr">Udstyr</label>
                <select class="form-control" id="udstyr">
                    <option>VR-headset</option>
                    <option>Arbejdscomputer</option>
                    <option>Plakatprinter</option>
                    <option>3D printer</option>
                    <option>Digitalt kamera</option>
                    <option>Fotostudie</option>
                </select>
            </div>
            <p>Skriv datoen for hvornår du gerne vil låne det</p>
            <div class = "form-group">
                <label for="dato">Dato for afhentning</label>
                <textarea class="form-control" id="dato" rows="3"></textarea>
            </div>
            <p>Hvor mange dage vil du gerne låne udstyret </p>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="1 dag" value="option1">
                <label class="form-check-label" for="1 dag">1</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="2dage" value="option2">
                <label class="form-check-label" for="2dage">2</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="3dage" value="option1">
                <label class="form-check-label" for="3dage">3</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="4dage" value="option2">
                <label class="form-check-label" for="4dage">4</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="5dage" value="option1">
                <label class="form-check-label" for="5dage">5</label>
            </div>


            <p>Kommentar til bestilling, skal indeholde tidspunkt for afhentning</p>
            <div class = "form-group">
                <label for="kommentar">kommentar</label>
                <textarea class="form-control" id="kommentar" rows="3"></textarea>
            </div>

            <input class="btn btn-primary" type="submit" value="Submit">

            <a class = "btn btn-primary" href="${pageContext.request.contextPath}/fc/studentpage"><btn-text> Tilbage </btn-text> </a>


        </table>


    </jsp:body>

</t:genericpage>


