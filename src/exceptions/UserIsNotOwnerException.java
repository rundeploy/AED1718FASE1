package exceptions;

public class UserIsNotOwnerException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	public UserIsNotOwnerException (){
		super();
	}
	
	public UserIsNotOwnerException(String message){
		super(message);
	}
}
