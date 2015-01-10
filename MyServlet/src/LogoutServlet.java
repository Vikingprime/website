import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "", name = "", urlPatterns = "", value = "")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
      
        //invalidate the session if exists
        HttpSession session = request.getSession(true);
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
 
}