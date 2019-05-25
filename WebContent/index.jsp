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
	<p>Veel succes!</p>
<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</div>
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
		<div id="userstatus"> <h3> je huidige status is ${user.getStatus()} </h3></div>
		<h2>kies jou status</h2>
		<form>
			<input id="online" type="radio" name="status" value="online" checked> online<br>
			<input id="away" type="radio" name="status" value="away"> away<br>
			<input id="offline" type="radio" name="status" value="offline"> offline<br>
			<input id="other" type="radio" name="status" value="kieszelf"> Other
			<input id="eigenstatusfield"type="text" name="status"><br>

		</form>
		<button id="changestatebutton">changestate</button>
		<h2>dit zijn al jouw vrienden</h2>
		<div id="friends"  ></div>

		<div id="addfrienddiv">
			<p>
				<label for="friendsid">friend id </label>
				<input type="text" id="friendsid" name="friendsid" value="an@ucll.be">
			</p>
			<button id="addfriendbutton">add friend</button>

		</div>
		<script>
            document.getElementById("changestatebutton").addEventListener('click', changeState)
            document.getElementById("addfriendbutton").addEventListener('click', addFriend)
		</script>

		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>
		<div id="logedinuserid" style="display: none;">${user.getUserId()}</div>
		<script>
            document.getElementById("logedinuserid").addEventListener('load', viewFriendList())
		</script>



	</c:when>
	<c:otherwise>
		<div id="loginform" style="display: block">
		<form method="post" action="Controller?action=LogIn">
			<p>
				<label for="email">Your email </label>
				<input type="text" id="email" name="email" value="jan@ucll.be">
			</p>
			<p>
				<label for="password">Your password</label>
				<input type="password" id="password" name="password" value="t">
			</p>
			<p>
				<input type="submit" id="loginbutton" value="submit Log in">
				<button id="registerbutton" type="button">get register form</button>
			</p>
			<script>
                document.getElementById("registerbutton").addEventListener('click', toggleregister)
			</script>
		</form>
		</div>
		<div id="registerform" style="display: none">
			<form method="post" action="Controller?action=register">

				<p>
					<label for="email">Your email </label>
					<input type="text" id="email" name="email" value="test@ucll.be">
				</p>
				<p>
					<label for="password">Your password</label>
					<input type="password" id="password" name="password" value="t">
				</p>
				<p>
					<label for="firstName">Your firstName </label>
					<input type="text" id="firstName" name="firstName" value="piet">
				</p>
				<p>
					<label for="lastName">Your lastName </label>
					<input type="text" id="lastName" name="lastName" value="peters">
				</p>
				<p>
					<label for="gender">Your gender </label>
					<input type="text" id="gender" name="gender" value="male">
				</p>
				<p>
					<label for="age">Your age </label>
					<input type="number" id="age" name="age" value="25">
				</p>
				<p>

					<input type="submit" id="registersubmit" value="submit registration">
					<button id="loginbuttonswitch" type="button">get log in form</button>

				</p>
				<script>
                     document.getElementById("loginbuttonswitch").addEventListener('click', toggleregister)
				</script>
			</form>
		</div>
	</c:otherwise>
</c:choose>

		<div id="blog">
			<div id="topic1">
				<div id="titel"><h3>topic1</h3></div>
				<div id="tekst">
					orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in pulvinar nunc. Duis pellentesque magna sed quam vehicula maximus. Ut imperdiet sapien vitae massa pharetra, faucibus ultrices enim gravida. Pellentesque eu facilisis est. Vestibulum rutrum euismod enim, vel placerat nisl tristique et. Aenean quis auctor sapien. Curabitur in auctor ex, ac tempus magna. Vestibulum mattis lacus ut dolor tempus sodales. Cras dapibus suscipit sapien ac congue. Curabitur luctus neque felis, nec posuere libero mattis eu. Suspendisse turpis dolor,
				</div>
				<div id="comments">
                    <div id="addcomment">

                        naam <input type="text" id="cnaam1" name="cnaam1" value="dumbledore">
                         rating max 10 <input type="number" id="crating1" name="crating1" min="1" max="10" value="10">
                        <button id="button1" type="button" onclick="send(1);" >Send</button>
                    </div>
                    <div id="comments1">

                    </div>
				</div>
			</div>
            <div id="topic2">
                <div id="titel"><h3>topic2</h3></div>
                <div id="tekst">
                    orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in pulvinar nunc. Duis pellentesque magna sed quam vehicula maximus. Ut imperdiet sapien vitae massa pharetra, faucibus ultrices enim gravida. Pellentesque eu facilisis est. Vestibulum rutrum euismod enim, vel placerat nisl tristique et. Aenean quis auctor sapien. Curabitur in auctor ex, ac tempus magna. Vestibulum mattis lacus ut dolor tempus sodales. Cras dapibus suscipit sapien ac congue. Curabitur luctus neque felis, nec posuere libero mattis eu. Suspendisse turpis dolor,
                </div>
                <div id="comments">
                    <div id="addcomment">

                        naam <input type="text" id="cnaam2" name="cnaam2" value="snape">
                        rating max 10 <input type="number" id="crating2" name="crating1" min="1" max="10" value="10">
                        <button id="button2" type="button" onclick="send(2);" >Send</button>
                    </div>
                    <div id="comments2">

                    </div>
                </div>
            </div>
            <div id="topic3">
                <div id="titel"><h3>topic3</h3></div>
                <div id="tekst">
                    orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in pulvinar nunc. Duis pellentesque magna sed quam vehicula maximus. Ut imperdiet sapien vitae massa pharetra, faucibus ultrices enim gravida. Pellentesque eu facilisis est. Vestibulum rutrum euismod enim, vel placerat nisl tristique et. Aenean quis auctor sapien. Curabitur in auctor ex, ac tempus magna. Vestibulum mattis lacus ut dolor tempus sodales. Cras dapibus suscipit sapien ac congue. Curabitur luctus neque felis, nec posuere libero mattis eu. Suspendisse turpis dolor,
                </div>
                <div id="comments">
                    <div id="addcomment">

                        naam <input type="text" id="cnaam3" name="cnaam3" value="harry">
                        rating max 10 <input type="number" id="crating3" name="crating3" min="1" max="10" value="10">
                        <button id="button3" type="button" onclick="send(3);" >Send</button>
                    </div>
                    <div id="comments3">

                    </div>
                </div>
            </div>
            <div id="topic4">
                <div id="titel"><h3>topic4</h3></div>
                <div id="tekst">
                    orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in pulvinar nunc. Duis pellentesque magna sed quam vehicula maximus. Ut imperdiet sapien vitae massa pharetra, faucibus ultrices enim gravida. Pellentesque eu facilisis est. Vestibulum rutrum euismod enim, vel placerat nisl tristique et. Aenean quis auctor sapien. Curabitur in auctor ex, ac tempus magna. Vestibulum mattis lacus ut dolor tempus sodales. Cras dapibus suscipit sapien ac congue. Curabitur luctus neque felis, nec posuere libero mattis eu. Suspendisse turpis dolor,
                </div>
                <div id="comments">
                    <div id="addcomment">

                        naam <input type="text" id="cnaam4" name="cnaam4" value="ron">
                        rating max 10 <input type="number" id="crating4" name="crating4" min="1" max="10" value="10">
                        <button id="button4" type="button" onclick="send(4);" >Send</button>
                    </div>
                    <div id="comments4">

                    </div>
                </div>
            </div>
            <div id="topic5">
                <div id="titel"><h3>topic5</h3></div>
                <div id="tekst">
                    orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in pulvinar nunc. Duis pellentesque magna sed quam vehicula maximus. Ut imperdiet sapien vitae massa pharetra, faucibus ultrices enim gravida. Pellentesque eu facilisis est. Vestibulum rutrum euismod enim, vel placerat nisl tristique et. Aenean quis auctor sapien. Curabitur in auctor ex, ac tempus magna. Vestibulum mattis lacus ut dolor tempus sodales. Cras dapibus suscipit sapien ac congue. Curabitur luctus neque felis, nec posuere libero mattis eu. Suspendisse turpis dolor,
                </div>
                <div id="comments">
                    <div id="addcomment">

                        naam <input type="text" id="cnaam5" name="cnaam5" value="mcgonagall">
                        rating max 10 <input type="number" id="crating5" name="crating5" min="1" max="10" value="10">
                        <button id="button5" type="button" onclick="send(5);" >Send</button>
                    </div>
                    <div id="comments5">

                    </div>
                </div>
            </div>
		</div>

		<script type="text/javascript">
            window.addEventListener("load", openSocket);
            var webSocket;
            var messages = document.getElementById("messages");

            function openSocket(){
                webSocket = new WebSocket("ws://localhost:8081/echo");
               // console.log("de socket word geopend");
                webSocket.onopen = function(event){
                    //writeResponse("Connection opened")
                    //console.log("de socket word geopend");
                };

                webSocket.onmessage = function(event){
                   // console.log("er word een message doorgegeven 1");
                    writeResponse(event.data);
                };

                webSocket.onclose = function(event){
                    //writeResponse("Connection closed");
                };
            }

            function send(comment){
               // console.log("er word een message doorgegeven 0");
                var naam = document.getElementById("cnaam" + comment).value;
                var number = document.getElementById("crating"+ comment).value;
               /* var data = new Object();

                data.naam = naam;
                data.nummer  = number;
                data.comment = 1;
                var jsonString= JSON.stringify(data);
                */
               var message = comment.toString() + " " + number + " " + naam;
              //  console.log("er word een message doorgegeven 2");
                webSocket.send(message);
            }

            function closeSocket(){
                webSocket.close();
            }

            function writeResponse(text){
                //console.log("er word een message doorgegeven 3");
                //var comment = JSON.parse(text);
                //var html = "<div> naam = " +text;
                var comment = text.split(" ");
                var c = comment[0];
               // console.log("c  " + c);
                if(c !== 'Connection') {
                    var html = "<div> naam = " + comment[2] + " rating = " + comment[1] + "</div>";
                    document.getElementById("comments" + c).innerHTML += html;
                   // console.log("er word een message doorgegeven 4");
                }
            }
		</script>

		<div id="users"  ></div>
	<script>
      //  window.addEventListener("load",  getUsers)
	</script>
        <div id="chatdiv">

        </div>


        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	</main>

    <script type="text/javascript" src="js/chat.js"></script>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
</body>
</html>