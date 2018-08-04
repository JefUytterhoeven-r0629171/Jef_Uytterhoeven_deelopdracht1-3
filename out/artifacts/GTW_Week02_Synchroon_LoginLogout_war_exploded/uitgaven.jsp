<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

    <div id="uitgavens">
        <div id="uitgavenlijst" >

        </div>

        <div id="uitgavenform">
            naam <input type="text" id="naam" name="naam" value="snape">
            bedrag <input type="number" id="bedrag" name="bedrag" min="0" value="0">
            datum <input type="text" id="datum" name="datum" value="31/06/1997">
            <button id="adduitgavenb" type="button" onclick="senduitgaven;" >Send</button>
        </div>
    </div>
    <script type="text/javascript">
        window.addEventListener("load", viewUitgaven);
    </script>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>