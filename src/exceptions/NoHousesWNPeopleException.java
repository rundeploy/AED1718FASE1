package exceptions;

public class NoHousesWNPeopleException extends Exception{
	
private static final long serialVersionUID = 0L;
	
	public NoHousesWNPeopleException(){
		super();
	}
	
	public NoHousesWNPeopleException(String message){
		super(message);
	}

}
