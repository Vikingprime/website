

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactMe
 */
public class ContactMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {
	            String name=request.getParameter("name");
	            String emailaddress = request.getParameter("emailaddress");
	            String comment = request.getParameter("comment");
	            out.print("<p style='text-align:center;'> Welcome "+name +". Your email address, "+
		   	            emailaddress+", and your comment, have been received.</p>");
		   	            RequestDispatcher rd = request.getRequestDispatcher("/ContactUs.jsp");
		   		           rd.include(request, response);
	     MailApp.send(name, emailaddress, comment);
		           
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
				finally 
	        {  
	            out.close();	
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
