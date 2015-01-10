<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css" href="css/style.css">
<body>
<div class="main">
<div class="header"> 
<div class="logo">
<a href="aboutus.jsp"><img src="images/vikaslogo4.png" width="200" height="40" style="margin:30px 10px;"></a>

</div>
</div>
<div class="menu">
<ul>
<li><a href="index.jsp">Home</a></li>
<li><a href="aboutus.jsp">About Me</a></li>
<li><a href="ContactUs.jsp">Contact Us</a></li>
<li><a href="quiz.jsp">Learning JS: Spaceships</a></li>
<li><a href="MyAccount.jsp">My Account</a></li>
<li><a href="LogoutServlet">Logout</a></li>
</ul>
</div>

<div class="color2">
<%
//allow access only if session exists
String firstname = null;
String emailaddress = null;
if(session.getAttribute("emailaddress") == null){
    response.sendRedirect("login.jsp");
}else {
	firstname = (String) session.getAttribute("firstname");
emailaddress = (String) session.getAttribute("emailaddress");

}
%>
<h3>Hi <%=firstname%>, Login successful.</h3>
<br>
	<head>
		<title>Asteroid Dodger</title>
		<br> Move : Up/Down/Left/Right 
		<br> Shoot: 'a' key 
		<br>(I used 'a' because some cheaper keyboards don't allow
		users to press up, Spacebar, and left at the same time)
		<br>
	
	<link rel="stylesheet" href="styles.css">
		

<script src="Javascript/main.js"> </script>
<script src="Javascript/spaceship.js"></script>
<script src="Javascript/bullets.js"></script>
	</head>

<body style=text-align:center>
		<h1>Asteroid Dodger</h1>
		<canvas id='myCanvas' width='480' height='480'></canvas>
 </body>
</div>
<div class="footer">
</div>
</body>
</html>
