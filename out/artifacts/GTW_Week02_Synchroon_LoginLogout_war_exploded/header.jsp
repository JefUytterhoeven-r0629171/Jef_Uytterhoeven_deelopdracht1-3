<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>chatapp web4</title>

    <link rel="stylesheet" href="Css/style.css" type="text/css" />
</head>
<body>

<div id="container">

    <div id="sub-header">
        <marquee behavior="alternate" direction="right">
            <img class="first" src="images/selected/100 (2).jpg" alt="" />
            <img src="images/selected/100.jpg" alt="" />
            <img src="images/selected/101.jpg" alt="" />
            <img src="images/selected/104.jpg" alt="" />
            <img src="images/selected/106.jpg" alt="" />
            <img src="images/selected/11.jpg" alt="" />
            <img src="images/selected/17 - Copy.jpg" alt="" />
            <img src="images/selected/18.jpg" alt="" />
            <img src="images/selected/2.jpg" alt="" />
            <img src="images/selected/4.jpg" alt="" />
            <img src="images/selected/40.jpg" alt="" />
            <img src="images/selected/47.jpg" alt="" />
            <img src="images/selected/48.jpg" alt="" />
            <img src="images/selected/5.jpg" alt="" />
            <img src="images/selected/51.jpg" alt="" />
            <img src="images/selected/6.jpg" alt="" />
            <img src="images/selected/67.jpg" alt="" />
            <img src="images/selected/70.jpg" alt="" />
            <img src="images/selected/71.jpg" alt="" />
            <img src="images/selected/73 (2).jpg" alt="" />
            <img src="images/selected/73.jpg" alt="" />
            <img src="images/selected/74.jpg" alt="" />
            <img src="images/selected/77.jpg" alt="" />
            <img src="images/selected/78.jpg" alt="" />
            <img src="images/selected/79.jpg" alt="" />
            <img src="images/selected/8.jpg" alt="" />
            <img src="images/selected/81.jpg" alt="" />
            <img src="images/selected/87.jpg" alt="" />
            <img src="images/selected/88.jpg" alt="" />
            <img src="images/selected/89.jpg" alt="" />
            <img src="images/selected/9.jpg" alt="" />
            <img src="images/selected/90.jpg" alt="" />
            <img src="images/selected/91.jpg" alt="" />
            <img src="images/selected/94.jpg" alt="" />
            <img src="images/selected/97.jpg" alt="" />
            <img src="images/selected/99.jpg" alt="" />
            <img src="images/selected/dz.jpg" alt="" />
        </marquee>


    </div>
    <div id="menu">
        <div id="menu-left"></div>
        <div id="menu-right"></div>
        <ul>
            <li id="first"><span class="access-key">01.</span> <a accesskey="1" href="Controller">Home</a></li>
            <li><span class="access-key">02.</span> <a accesskey="2" href="uitgaven.jsp">uitgaven</a></li>
            <li><span class="access-key">03.</span> <a accesskey="3" href="studenten.jsp">studenten</a></li>
        </ul>
    </div>
    <div style="height:100px; background-color:#fff">

        <h1 style="float:left;  font-size : 30px; text-align: center; width: 80%;">chatapp web4 </h1>

    </div>

        <%--

<header role="banner">
<img alt="Books" src="images/books.jpg">
<h1><span>Library</span></h1>
<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
    <h1>  <li><a href="uitgaven.jsp">uitgaven</a></li> </h1>
    <h1>  <li><a href="studenten.jsp">studenten</a></li> </h1>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
    <h1>  <li><a href="uitgaven.jsp">link naar uitgaven pagina</a></li> </h1>
</c:otherwise>
</c:choose>

</ul>
</nav>
<h2>
${param.title}
</h2>

</header>

--%>
