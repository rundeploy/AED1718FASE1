package aed;
import dataStructures.*;
import exceptions.*;

/**
 * Represents a Manager and its data to manage an user and a house
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public class ManagerClass implements Manager {
	
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWENTY = 20;
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	
	/**
	 * Creates an User object
	 */
	private User user;
		
	/**
	 * Creates a control class for the application (constructor).
	 */
	public void Manager(){
		user = null;
		
	}
	
	@Override
	public void createUser(String idUser, String email, String telefone, String nome, String nacionalidade, String morada) throws ExistingUserException{
		if (existUser(idUser))
			throw new ExistingUserException();
		
		user = new UserClass(idUser, email, telefone, nome, nacionalidade, morada);
	}
	
	/**
	 * Verifies if there is a user in the system with the unique identifier <code>idUser</code>. 
	 * Returns true if there is.
	 * @param idUser - unique identifier of an user
	 * @return true iff there is a user in the system with the unique identifier <code>idUser</code>, false otherwise
	 */
	private boolean existUser(String idUser){
		if (user == null)
			return false;
		else if (!user.getIdUser().equalsIgnoreCase(idUser))
			return false;
		
		return true;
	}
	@Override
	public void modUserData(String idUser, String email, String telefone, String morada) throws NotExistingUserException{
		if (!existUser(idUser))
			throw new NotExistingUserException();
		
		user.setEmail(email);
		user.setPhone(telefone);
		user.setAddress(morada);
	}
	@Override
	public void delUser(String idUser) throws NotExistingUserException, UserIsOwnerException{
		if (!existUser(idUser))
			throw new NotExistingUserException();
		else if(user.hasHouse())
			throw new UserIsOwnerException();
		
		user = null;	
	}
	@Override
	public User getUser(String idUser) throws NotExistingUserException{
		if (!existUser(idUser))
			throw new NotExistingUserException();
		
		return user;
	}
	
	@Override
	public void addHouse(String idHome, String idUser, int preco, int pessoas, String local, String descricao, String morada) throws InvalidDataException, NotExistingUserException, ExistingHouseException{
		if(preco < ZERO || pessoas < ONE || pessoas > TWENTY){
			throw new InvalidDataException();
		}else if (!existUser(idUser)){
			throw new NotExistingUserException();
		}else if (existHouse(idHome)){
			throw new ExistingHouseException();
		}
		String userName = user.getName();
		House house = new HouseClass(idHome, preco, pessoas, local, descricao, morada, userName);
		user.setHouse(house);
		
	}
	
	/**
	 * Verifies if there is a house, owned by an user, with the unique identifier <code>idHome</code>.
	 * Returns true if there is.
	 * @param idHome - unique identifier of an house
	 * @return true iff there is a house, owned by an user, with the unique identifier <code>idHome</code>, false otherwise
	 */
	private boolean existHouse(String idHome){
		if(user == null)
			return false;
		else if (user.getHouse() == null)
			return false;
		else if (!user.getHouse().getIdHouse().equalsIgnoreCase(idHome))
			return false;
		
		return true;
			
	}
	
	@Override
	public House getHouse(String idHome)throws NotExistingHouseException{
		if(!existHouse(idHome))
			throw new NotExistingHouseException();

		return user.getHouse();
	}
	
	@Override
	public void delHouse(String idHome) throws NotExistingHouseException, VisitedHouseException{
		if(!existHouse(idHome)){
			throw new NotExistingHouseException();
		}else if ( user.visitedHouse()){
			throw new VisitedHouseException();
		}
	
		user.removeHouse();
	}
	
	@Override
	public void addTouristStay(String idUser, String idHome, int pontos) throws InvalidDataException, NotExistingUserException, NotExistingHouseException, UserIsOwnerException{
		if(pontos < ZERO || pontos > TWENTY)
			throw new InvalidDataException();
		else if (!existUser(idUser))
			throw new NotExistingUserException();
		else if(!existHouse(idHome))
			throw new NotExistingHouseException();
		else if (user.hasHouse())
			throw new UserIsOwnerException();
	}
	
	@Override
	public void addOwnStay(String idUser, String idHome) throws NotExistingUserException, NotExistingHouseException, UserIsNotOwnerException{
		if (!existUser(idUser))
			throw new NotExistingUserException();
		else if(!existHouse(idHome))
			throw new NotExistingHouseException();
		else if (!user.hasHouse())
			throw new UserIsNotOwnerException();
		
		House house = user.getHouse();
		user.addStay(house);
	}
	
	@Override
	public House listOwnHouses(String idUser)throws NotExistingUserException, UserIsNotOwnerException{ 
		if (!existUser(idUser))
			throw new NotExistingUserException();
		else if(!user.hasHouse())
			throw new UserIsNotOwnerException();
		
		return user.getHouse();
	}
	
	@Override
	public Iterator<House> listOwnStays(String idUser) throws NotExistingUserException, NotTraveledUserException{ 
		if (!existUser(idUser))
			throw new NotExistingUserException();
		else if(!user.visitedHouse())
			throw new NotTraveledUserException();
		
		return user.listStays();
	}
	
	@Override
	public House listHouseByNPeople(int pessoas, String local) throws InvalidDataException, NoHousesWNPeopleException{
		if(user == null || !user.hasHouse())
			throw new NoHousesWNPeopleException();
		else if(pessoas < ONE || pessoas > TWENTY)
			throw new InvalidDataException();
		else if (!(user.getHouse().getTown().equalsIgnoreCase(local)) || (pessoas > (user.getHouse().getMaxPeaople())) )
			throw new NoHousesWNPeopleException();
			
		return user.getHouse();
		
	}
	
	@Override
	public House listHouseByPlace(String local) throws NoHouseInThisPlaceException{
		if(user == null || !user.hasHouse() || !user.getHouse().getTown().equalsIgnoreCase(local))
			throw new NoHouseInThisPlaceException();
		
		return user.getHouse();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
