<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%
String firstname = null;
String lastname = null;
String emailaddress = null;
if(session.getAttribute("emailaddress") == null){
    response.sendRedirect("login.jsp");}
else {
firstname = (String) session.getAttribute("firstname");
lastname = (String) session.getAttribute("lastname");
emailaddress = (String) session.getAttribute("emailaddress");
}%>
 

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
<div class="clear"></div>
</div>

<div class="color3" style="height:380px">
<h1>My Account</h1>
<form method="post" action="UpdateAccount">
<table>
<tr>
<td>
First Name</td><td> <textarea name="firstname" ><%=firstname%></textarea> </td></tr>
<tr>
<td>
Last Name</td><td> <textarea name="lastname" ><%=lastname%></textarea></td></tr>
<tr>
<td>
Email</td><td> <textarea name="emailaddress" readonly="readonly" ><%=emailaddress%></textarea></td></tr> 
</table>
<input type="submit" class="newcolor" value="Submit">
</form>
</div>

<div class="footer"> 
</div>
</div>
</body>
</html>