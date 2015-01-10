
public class InputChecker {
protected static boolean checkemail(String email){
return ((email.endsWith(".net") || email.endsWith(".org") || email.endsWith(".com") ||
		email.endsWith(".info")||email.endsWith(".gov")||email.endsWith(".edu"))&&rightcharacters(email));	
}
protected static boolean checkname(String firstname){
	return (firstname.length()>0 && rightcharacters(firstname));
}
protected static boolean checkpassword(String pass){
	return (pass.length()>0 && rightcharacters(pass));
}
protected static boolean rightcharacters(String pass){
	boolean goodchar = true;
	for(int start = 0;start<pass.length();start++){
		if(pass.charAt(start)=='*'||pass.charAt(start)==';'){
			goodchar = false;
			break;
		}
	}
	return goodchar;
}
}
