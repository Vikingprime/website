import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Email {
	protected static boolean exists(String email,Connection conn){
		boolean correctemail = false;
		try{
		Statement first = conn.createStatement();
		String firstsql = "select emailaddress from quiz_register";
		ResultSet firstrs = first.executeQuery(firstsql);
		while(firstrs.next()){
			if(firstrs.getString("emailaddress").equals(email)){
				correctemail=true;
				break;
				
			}
		}
		firstrs.close();
		first.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return correctemail;
	}

}
