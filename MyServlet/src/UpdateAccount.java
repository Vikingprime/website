

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateAccount
 */
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
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
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://VIKINGPRIME;user=sa;password=Marinekingprime445;database=quizdb");
			System.out.println("connected");
			response.setContentType("text/html;charset=UTF-8");
			Statement sta = conn.createStatement();
			HttpSession session = request.getSession();
			System.out.println("Session: "+(String) session.getAttribute("firstname"));
			String updateSQl = "UPDATE quiz_register SET firstname= ?,lastname= ? WHERE emailaddress = ?";
			PreparedStatement updateemp = conn.prepareStatement(updateSQl);
			updateemp.setString(1,request.getParameter("firstname"));
			updateemp.setString(2,request.getParameter("lastname"));
			//updateemp.setString(3,request.getParameter("emailaddress"));
			updateemp.setString(3, (String) session.getAttribute("emailaddress")); 
			updateemp.executeUpdate();
			 RequestDispatcher rd = request.getRequestDispatcher("Refresh");
		           rd.include(request, response);

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
