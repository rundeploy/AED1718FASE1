package exceptions;

public class ExistingHouseException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	public ExistingHouseException (){
		super();
	}
	
	public ExistingHouseException(String message){
		super (message);
	}

}
