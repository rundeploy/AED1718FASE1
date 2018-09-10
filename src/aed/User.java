package aed;
import java.io.Serializable;
import dataStructures.Iterator;
/**
 * Represents an User object
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public interface User extends Serializable{
	
	
	/**
	 * Returns the unique identifier of the user.
	 * @return identifier of the user
	 */
	public String getIdUser ();
	
	/**
	 * Returns the email of the user.
	 * @return email of the user
	 */
	public String getEmail ();
	
	/**
	 * Returns the phone of the user.
	 * @return phone of the user
	 */
	public String getPhone ();
	
	/**
	 * Returns the name of the user.
	 * @return name of the user
	 */
	public String getName ();
	
	/**
	 * Returns the nationality of the user.
	 * @return nationality of the user
	 */
	public String getNationality ();
	
	/**
	 * Returns the address of the user.
	 * @return address of the user
	 */
	public String getAddress ();
	
	/**
	 * Updates the email of the user with <code>email</code>
	 * @param email - email of the user
	 */
	public void setEmail(String email);
	
	/**
	 * Updates the phone of the user with <code>telefone</code>
	 * @param telefone - phone number of the user
	 */
	public void setPhone(String telefone);
	
	/**
	 * Updates the address of the user with <code>morada</code>
	 * @param morada
	 */
	public void setAddress(String morada);
	
	/**
	 * Adds a house <code>house</code> to the user.
	 * @param house - house to be owned by the user
	 */
	public void setHouse(House house);
	
	/**
	 * Returns true iff the user owns a house.
	 * @return true iff the user owns a house, false otherwise
	 */
	public boolean hasHouse();
	
	/**
	 * Adds a stay made by the user, at the house <code>house</code>
	 * @param house - house visited by the user
	 */
	public void addStay(House house);
	
	/**
	 * Returns true iff the user has visited at least one house.
	 * @return true iff the user has visited at least one house, false otherwise
	 */
	public boolean visitedHouse();
	
	/**
	 * Returns the house owned by the user, or null, if the user has none.
	 * @return house owned by the user
	 */
	public House getHouse();
	
	/**
	 * Removes the house of the user.
	 */
	public void removeHouse();
	
	/**
	 * Returns an iterator for the collection of stays of the user.
	 * @return  iterator for the collection of stays of the user
	 */
	public Iterator<House> listStays();
	
}
