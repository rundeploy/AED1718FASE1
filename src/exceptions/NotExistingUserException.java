package exceptions;

public class NotExistingUserException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	public NotExistingUserException(){
		super();
	}
	
	public NotExistingUserException(String message){
		super(message);
	}

}
