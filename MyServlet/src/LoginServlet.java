
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "", name = "", urlPatterns = "", value = "")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		
		try {
			Connection conn = AllConnect.reconnect();
			boolean correctemail=Email.exists(email,conn);
			if(correctemail == true){
			Statement sta = conn.createStatement();
			String Sql = "select * from quiz_register where emailaddress ='"+email+"';";
			ResultSet rs = sta.executeQuery(Sql);
			rs.next();
			String cryptpass = rs.getString("password");
			String firstname = rs.getString("firstname");
			String pass = encryptioin.decrypt(cryptpass);
			MailApp.newPassword(pass,firstname,email);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			out.println("Your password has been sent to your email");
			rd.include(request, response);
			rs.close();
			conn.close();
			sta.close();
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
	            out.println("<font color=red>Sorry, we do not have a registered account with that email</font>");
	            rd.include(request, response);
			}
    }
		catch(Exception e) {
			e.printStackTrace();
		}
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		
		try {
			Connection conn = AllConnect.reconnect();
			boolean correctemail=Email.exists(email,conn);
			if(correctemail){
			String Sql = "select * from quiz_register where emailaddress = ?;";
			PreparedStatement sta = conn.prepareStatement(Sql);
			sta.setString(1,email);
			ResultSet rs = sta.executeQuery();
			rs.next();
			String cryptpass = rs.getString("password");
			String pass = encryptioin.decrypt(cryptpass);
			String address = rs.getString("emailaddress");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			if(pass.equals(password))
			{
				HttpSession session = request.getSession();
	            session.setAttribute("firstname", firstname);
	            session.setAttribute("lastname", lastname);
	           session.setAttribute("emailaddress",address);
	           session.setMaxInactiveInterval(10*60);
	            response.sendRedirect("quiz.jsp");
		
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            out.println("<font color=red>Either email or password is incorrect.</font>");
	            rd.include(request, response);		
			}
		rs.close();
		conn.close();
		sta.close();
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            out.println("<font color=red>Either email or password is incorrect.</font>");
	            rd.include(request, response);		
			}
		
	} catch(Exception e) {
		e.printStackTrace();
	}
        // get request parameters for userID and password
        
 
    }
 
}