package exceptions;

public class NotTraveledUserException extends Exception{
	
private static final long serialVersionUID = 0L;
	
	public NotTraveledUserException (){
		super();
	}
	
	public NotTraveledUserException(String message){
		super(message);
	}

}
