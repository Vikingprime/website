import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AllConnect {
	
	protected static Connection reconnect() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	//Connection conn = DriverManager.getConnection("jdbc:sqlserver://VIKINGPRIME;user=sa;password=Marinekingprime445;database=quizdb");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://182.18.175.142;user=quizdb;password=7v17yF0Vbu;database=vikasshi_quiz");
		return conn;
	}
}
