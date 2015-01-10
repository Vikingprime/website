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
<%if(session.getAttribute("emailaddress")==null) {%>
<li><a href="register.jsp">Register</a></li>
<li><a href="login.jsp">Login</a></li>
<%} %>
<li><a href="ContactUs.jsp">Contact Us</a></li>
<%if(session.getAttribute("emailaddress")!=null) {%>
<li><a href="quiz.jsp">Learning JS: Spaceships</a></li>
<li><a href="MyAccount.jsp">My Account</a></li>
<li><a href="LogoutServlet">Logout</a></li>
<%} %>
</ul>
</div>

<div class="color3" style="height:380px;padding:0 150px;">
<div class="wordframe" style=height:300px;float:left;>
<h2> About Me</h2>
<p style=font-size:15px;text-align:left>I am a student at Vanderbilt University in Nashville, but my permanent residence is in Lexington, MA.
I am an avid chess player and have played in tournaments since the fifth grade. I also sing Indian 
Classical Music. At Vanderbilt, I am involved in Vandy Apps, Vandy Karma (Hinduism), and the Interfaith Council.
<br><br>
	Though I created this website primarily as a learning experience during my 2014 Summer trip to India, I've recently decided to
	use this site to showcase some ideas/projects. This website was created on 6/19/2014 using Java, JSP pages, and HTML/CSS. Please login to check out some projects. </p> 
<div class="clear"></div>
</div>
</div>


<div class="footer">
</div>
</div>
</body>
</html>