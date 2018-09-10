package exceptions;

public class NoHouseInThisPlaceException extends Exception{
	
private static final long serialVersionUID = 0L;
	
	public NoHouseInThisPlaceException (){
		super();
	}
	
	public NoHouseInThisPlaceException(String message){
		super (message);
	}

}
