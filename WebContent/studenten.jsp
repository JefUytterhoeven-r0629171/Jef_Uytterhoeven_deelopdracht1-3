<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/studenten.js"></script>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<main>

    <div id="studenten">
        <div id="studentenlijst" >

        </div>
        <br>


        <div id="studentenformulier">
            naam <input type="text" id="studentnaam" name="studentnaam" value="snape">
            vak <input type="text" id="vak" name="vak" value="web4">
            datum <input type="text" id="datum" name="datum" value="31/06/1997">
            uur <input type="number" id="uur" name="uur" value="4" min="0" max="24">
            <button id="addstudent" type="button" onclick="sendStudenten();" >Send</button>
        </div>
    </div>
    <script type="text/javascript">
        window.addEventListener("load", viewStudent);
    </script>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>