package exceptions;

public class ExistingUserException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public ExistingUserException(){
		super();
	}
	
	public ExistingUserException(String message){
		super(message);
	}

}
