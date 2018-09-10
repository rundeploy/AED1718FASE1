package exceptions;

public class NotExistingHouseException extends Exception {
	
	private static final long serialVersionUID = 0L;

	public NotExistingHouseException(){
		super();
	}
	
	public NotExistingHouseException(String message){
		super(message);
	}
	
}
