package exceptions;

public class InvalidDataException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	public InvalidDataException(){
		super();
	}
	
	public InvalidDataException(String message){
		super(message);
	}

}
