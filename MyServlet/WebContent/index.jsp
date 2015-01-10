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
<% }%>
<li><a href="ContactUs.jsp">Contact Us</a></li>
<%if(session.getAttribute("emailaddress")!=null) {%>
<li><a href="quiz.jsp">Learning JS: Spaceships</a></li>
<li><a href="MyAccount.jsp">My Account</a></li>
<li><a href="LogoutServlet">Logout</a></li>
<%} %>
</ul>
</div>


<div class="color3" style=height:460px>
<div class="wordframe">
<h3> Vikas Shiva Pydah </h3>
<p style='text-align:left; font-size: 15px;'> I am currently a sophomore studying 
Computer Science at Vanderbilt University. Though I have focused on web, mobile, and some game development,
my interests and goals are much more varied. It's difficult to stay in the loop with Computer Science, and
I'd like to master a breadth of technologies to stay chic. As a result, I would like to remain well versed in
everything from operating systems to database management.
<br><br>
I will be using this website to put up some projects and jot down ideas. This website may or may
not, at a given time, have all the projects I am working on. If you're interested in seeing more projects,
please contact me via the Contact Us page.
<br><br>
As of right now, I am learning Android Development and improving my JavaScript knowledge. Please check out my
resume for more information on some interesting academic projects I've worked on. Login to check out some of
the projects in action (If you don't wish to register, click the login tab. There's a guest username/password).
</p>
<div style='text-align:center'>
<a href="./Files/Web_Resume.pdf" download>Click Here to See my Resume</a>
</div>
</div>
<div class="frame">
<div class="logo">
<a href="aboutus.jsp"><img src="images/me.jpg" width="300" height="440px"></a>
</div>
</div>
</div>


<div class="footer">
</div>
</div>
</body>
</html>
