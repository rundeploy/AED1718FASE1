package exceptions;

public class UserIsOwnerException extends Exception {
	
private static final long serialVersionUID = 0L;
	
	public UserIsOwnerException (){
		super();
	}
	
	public UserIsOwnerException (String message){
		super(message);
	}

}
