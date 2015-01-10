

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Refresh
 */
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		Connection conn = null;
		PrintWriter out = response.getWriter();
		
		try {
			conn = AllConnect.reconnect();
			Statement sta = conn.createStatement();
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			String emailadd = (String) session.getAttribute("emailaddress");
			String Sql = "select * from quiz_register WHERE emailaddress='"+emailadd+"';";
			ResultSet rs = sta.executeQuery(Sql);
			rs.next();
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
	            session.setAttribute("firstname", firstname);
	            session.setAttribute("lastname", lastname);
	            out.print("Your content was updated");
	            RequestDispatcher rd = request.getRequestDispatcher("MyAccount.jsp");
		           rd.include(request, response);
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	}

}
