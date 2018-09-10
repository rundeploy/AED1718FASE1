package aed;
import java.io.Serializable;

import dataStructures.Iterator;
import exceptions.*;

/**
 * Creates a Manager object to manage house and user
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public interface Manager extends Serializable{
	
	/**
	 * Inserts a user of id <code>idUser</code>, email <code>email</code>, phone <code>telefone</code>, name <code>nome</code>, nationality <code>nacionalidade</code> and address <code>morada</code> in the system.
	 * @param idUser - unique identifier of the user
	 * @param email - email of the user
	 * @param telefone - phone number of the user
	 * @param nome - name of the user
	 * @param nacionalidade - nationality of the user
	 * @param morada - address of the user
	 * @throws ExistingUserException if the identifier <code>idUser</code> already exists in the system
	 */
	public void createUser(String idUser, String email, String telefone, String nome, String nacionalidade, String morada) throws ExistingUserException;
	
	/**
	 * Updates the information about email <code>email</code>, phone <code>phone</code> and address <code>address</code> of user <code>idUser</code>
	 * @param idUser - unique identifier of the user
	 * @param email - email of the user
	 * @param telefone - phone number of the user
	 * @param morada - address of the user
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 */
	public void modUserData(String idUser, String email, String telefone, String morada) throws NotExistingUserException;
	
	/**
	 * Removes the user with identifier <code>idUser</code> from the system.
	 * @param idUser - unique identifier of the user
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws UserIsOwnerException if the user possesses houses
	 */
	public void delUser(String idUser) throws NotExistingUserException, UserIsOwnerException;
	
	/**
	 * Returns the user with identifier <code>idUser</code>
	 * @param idUser - unique identifier of the user
	 * @return the user with identifier <code>idUser</code>
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 */
	public User getUser(String idUser) throws NotExistingUserException;
	
	/**
	 * Inserts a house with an unique identifier <code>idHome</code>
	 * @param idHome - unique identifier of the house
	 * @param idUser - unique identifier of the owner of the house
	 * @param preco - price of staying one day at the house
	 * @param pessoas - max people allowed to stay at the house at the same time
	 * @param local - location of the house
	 * @param descricao - description of the house
	 * @param morada - address of the house
	 * @throws InvalidDataException if the values of price <code>preco</code> and max people <code>pessoas</code> are positive integers. 
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws ExistingHouseException if the identifier <code>idHome</code> already exists in the system
	 */
	public void addHouse(String idHome, String idUser, int preco, int pessoas, String local, String descricao, String morada) throws InvalidDataException, NotExistingUserException, ExistingHouseException;
	
	/**
	 * Removes the house with identifier <code>idHome</code> from the system.
	 * @param idHome - unique identifier of the house
	 * @throws NotExistingHouseException if the identifier <code>idHome</code> does not exist in the system
	 * @throws VisitedHouseException if the house has been visited
	 */
	public void delHouse(String idHome) throws NotExistingHouseException, VisitedHouseException;
	
	/**
	 * Returns the house with identifier <code>idHome</code>
	 * @param idHome - unique identifier of the house
	 * @return the house with identifier <code>idHome</code>
	 * @throws NotExistingHouseException if the identifier <code>idHome</code> does not exist in the system
	 */
	public House getHouse(String idHome)throws NotExistingHouseException;
	
	/**
	 * Adds the stay of user with identifier <code>idUser</code> at the house <code>idHome</code> and the points <code>pontos</code> given to the stay.
	 * @param idUser - unique identifier of the user
	 * @param idHome - unique identifier of the house
	 * @param pontos - points given to the stay
	 * @throws InvalidDataException if the points <code>pontos</code> given are negative or higher than the maximum of points allowed
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws NotExistingHouseException if the identifier <code>idHome</code> does not exist in the system
	 * @throws UserIsOwnerException if the visitor is also the owner of the house to be visited
	 */
	public void addTouristStay(String idUser, String idHome, int pontos) throws InvalidDataException, NotExistingUserException, NotExistingHouseException, UserIsOwnerException;
	
	/**
	 * Adds the stay of user with identifier <code>idUser</code> at the house <code>idHome</code>
	 * @param idUser - unique identifier of the user
	 * @param idHome - unique identifier of the house
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws NotExistingHouseException if the identifier <code>idHome</code> does not exist in the system
	 * @throws UserIsNotOwnerException if the visitor is not the owner of the house to be visited
	 */
	public void addOwnStay(String idUser, String idHome) throws NotExistingUserException, NotExistingHouseException, UserIsNotOwnerException;
	
	/**
	 * Returns the house belonging to the user <code>idUser</code>
	 * @param idUser - unique identifier of the user
	 * @return the house belonging to user <code>idUser</code>
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws UserIsNotOwnerException if the id does not have houses
	 */
	public House listOwnHouses(String idUser)throws NotExistingUserException, UserIsNotOwnerException;
	
	/**
	 * Returns an iterator for the stays made by the user <code>idUser</code>
	 * @param idUser - unique identifier of the user
	 * @return iterator for the stays made by the user <code>idUser</code>
	 * @throws NotExistingUserException if the identifier <code>idUser</code> does not exist in the system
	 * @throws NotTraveledUserException if the user did not visit any house
	 */
	public Iterator<House> listOwnStays(String idUser) throws NotExistingUserException, NotTraveledUserException;
	
	/**
	 * Returns the house that in a certain location <code>local</code> are able to receive a specified number of people <code>pessoas</code> 
	 * @param pessoas - max people allowed to stay at the house at the same time
	 * @param local - location of the house
	 * @return the house that in a certain location <code>local</code> are able to receive a specified number of people <code>pessoas</code>
	 * @throws InvalidDataException if the number of people <code>pessoas</code> is greater than the max allowed by the system or a negative number
	 * @throws NoHousesWNPeopleException if the search did not find suitable houses
	 */
	public House listHouseByNPeople(int pessoas, String local) throws InvalidDataException, NoHousesWNPeopleException;
	
	/**
	 * Returns the houses from a specified location <code>local</code> by order of rating, from best rating to lowest
	 * @param local - location of the house
	 * @return the houses from a specified location <code>local</code> by order of rating, from best rating to lowest
	 * @throws NoHouseInThisPlaceException if there are no houses in the specified location <code>local</code>
	 */
	public House listHouseByPlace(String local) throws NoHouseInThisPlaceException;
	

}
