package exceptions;

public class VisitedHouseException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	public VisitedHouseException(){
		super();
	}

	public VisitedHouseException(String message){
		super (message);
	}
}
