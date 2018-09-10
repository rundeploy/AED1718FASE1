package aed;
import java.io.Serializable;

/**
 * Creates an House object
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public interface House extends Serializable{
	
	/**
	 * Returns the unique identifier of the house.
	 * @return identifier of the house
	 */
	public String getIdHouse();
	
	/**
	 * Returns the description of the house.
	 * @return description of the house
	 */
	public String getDescrip();
	
	/**
	 * Returns the address of the house.
	 * @return address of the house
	 */
	public String getAddress();
	
	/**
	 * Returns the location of the house.
	 * @return location of the house
	 */
	public String getTown();
	
	/**
	 * Returns the cost of staying one day in the house.
	 * @return price per day of the house
	 */
	public int getPrice();
	
	/**
	 * Returns the maximum of people allowed to stay at the house at the same time.
	 * @return maximum of people allowed to stay at the house at the same time
	 */
	public int getMaxPeaople();
	
	/**
	 * Returns the rating, in points, of the house. 
	 * @return rating of the house
	 */
	public int getPoints();
	
	/**
	 * Returns the unique identifier of the owner of the house.
	 * @return identifier of the owner of the house
	 */
	public String getUserName();

}
