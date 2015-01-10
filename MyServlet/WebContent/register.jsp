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
<%
//allow access only if session exists

if(session.getAttribute("emailaddress") != null){
    response.sendRedirect("quiz.jsp");
}
%>
 
<center>
  <form method="post" action="Data">
<div class ="color3" style="height:380px">
<br>
<h2 style="text-align:center;"> Register Here </h2>
<br>
<table>
<tr>
<td>
First Name</td><td> <input type="text" name="firstname"> </td>
</tr><tr>
<td>Last Name </td><td><input type="text" name="lastname"></td></tr><tr>
<td>Email</td><td> <input type="text" name="emailaddress"></td></tr><tr><td>
Password</td><td><input type = "password" name = "password"> </td></tr>
</table>
<br>
<input type="submit" class="newcolor2" value="Submit">
</form>
</div>
</center>
<div class="footer">

</div>

</body>
</html>
