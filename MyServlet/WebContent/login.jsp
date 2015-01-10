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
<li><a href="register.jsp">Register</a></li>
<li><a href="login.jsp">Login</a></li>
<li><a href="ContactUs.jsp">Contact Us</a></li>
</ul>
</div> 
<div class = "color2">
<%
//allow access only if session exists

if(session.getAttribute("emailaddress") != null){
    response.sendRedirect("quiz.jsp");
}
%>
<form method ="post" action = "LoginServlet">
<table>
<tr>
<td>Email ID: </td>
<td><input type="text" name = "email" /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type = "password" name="pass" /></td>
</tr>
</table>
<input type = "submit" value = "Login" />
</form>
<br>
<a href="forgetpassword.jsp"><b>Forget your password?</b></a>
</div>

<div class="color3" style="height:250px;padding:0px 430px">
<div class="wordframe" style='height:100px;width:350px;padding-bottom:50px'>
<p style='text-align:left; font-size: 15px;'> 
Login to see some of my Projects.
<br><br> If you haven't registered, use:
<br>Username: guest@vikasshiva.com
<br>Password: guest
</p>
</div>
</div>


<div class="footer">
</div>
</div>
</body>
</html>
