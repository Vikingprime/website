

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Data
 */
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			   try {  
				Connection conn = AllConnect.reconnect();
				Statement first = conn.createStatement();
				String firstsql = "Select emailaddress FROM quiz_register;";
				ResultSet firstrs = first.executeQuery(firstsql);
				response.setContentType("text/html;charset=UTF-8");
				boolean sameemail = false;
				 String emailaddress = request.getParameter("emailaddress");
				 PrintWriter out = response.getWriter();
				while(firstrs.next()){
					if(firstrs.getString("emailaddress").equals(emailaddress)){
						sameemail = true;
						break;
					}
				}
				
				if(sameemail == false){
				String password = request.getParameter("password");
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				boolean rightemail = InputChecker.checkemail((emailaddress.toLowerCase()));
				boolean rightpass = InputChecker.checkpassword(password);
				boolean rightfirstname =InputChecker.checkname(firstname);
				boolean rightlastname = InputChecker.checkname(lastname);
				if(rightemail && rightpass && rightfirstname && rightlastname) {
					
				Statement sta = conn.createStatement();
				String Sql = "SELECT id FROM quiz_register;";
				ResultSet rs = sta.executeQuery(Sql);
				int ID = 0;
				System.out.println("You reached here");
				if (rs.next()) {
					Statement next = conn.createStatement();
					String nextSql = "SELECT TOP 1 id FROM quiz_register ORDER BY id DESC;";
					ResultSet two = sta.executeQuery(nextSql);
					two.next();
					ID = two.getInt("id");
					two.close();
				}
				rs.close();
				
				
				
	PreparedStatement updateemp = conn.prepareStatement("insert into quiz_register values(?,?,?,?,?)");
					updateemp.setInt(1, (ID+1));
					updateemp.setString(2,emailaddress);
				   String encryptedpass = encryptioin.encrypt(password);
				updateemp.setString(3, encryptedpass);
				updateemp.setString(4, firstname);
				updateemp.setString(5, lastname);
				updateemp.executeUpdate();
					 System.out.println("success");
					 out.print("<p> Thanks for Registering! </p>");
				   	        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				   		           rd.include(request, response);
			     MailApp.register(firstname,password,emailaddress);
				}
				else {
					if(rightemail==false){
						 out.println("Sorry, the email you entered was not valid. Remember that "
						 		+ "* and ; characters are not allowed in your email address.");
					}
					else if(!(rightfirstname && rightlastname)) {
						String sentence = "Your name cannot contain * or ; characters and must be more than 0 characters.";
						out.println(sentence);
					}
					else if(!rightpass){
						String sentence = "Your password cannot contain * or ; characters and must be more than 0 characters.";
						out.println(sentence);
					}
					RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
	   		           rd.include(request, response);
					
				}
		
				 }
				 else {
					 out.print("That email address has already been used.");
					 RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
	   		           rd.include(request, response);
				 conn.close();	
				 }
			   } catch(Exception e) {
					e.printStackTrace();
				}
			} 
	}


