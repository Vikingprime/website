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

<div class="color3" style="height:380px">
<h2> ContactUs </h2>
<form class="justify" method="get" action="ContactMe">
<table>
<tr>
<td>
Name</td><td> <input type="text" name="name"> </td>
</tr><tr>
<td>Email</td><td> <input type="text" name="emailaddress"></td></tr><tr><td>
Comments</td><td> <textarea name="comment" >Enter text here...</textarea></td></tr> 

</table>
<input type="submit" class="newcolor" value="Submit">
</form>
<div class="clear"></div>
</div>





<div class="footer"> 
</div>
</div>
</body>
</html>