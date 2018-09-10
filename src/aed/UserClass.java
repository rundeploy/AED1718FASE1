package aed;
import dataStructures.*;


/**
 * Represents an User and its data
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public class UserClass implements User {
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 * Unique identifier of the user
	 */
	private String idUser;
	/**
	 * Email of the user
	 */
	private String email;
	/**
	 * Phone of user
	 */
	private String telefone;
	/**
	 * Name of the user
	 */
	private String nome;
	/**
	 * Nationality of the user
	 */
	private String nacionalidade;
	/**
	 * Address of the user
	 */
	private String morada;
	
	/**
	 * House object
	 */
	private House house;
	
	/**
	 * Structure responsible for storing the possible stays of the user, at available houses.
	 */
	private StackIterator<House> stays;
	
	/**
	 * Creates a user with id <code>idUser</code>, email <code>email</code>, phone <code>telefone</code>, name <code>nome</code>, nationality <code>nacionalidade</code> and adress <code>address</code>
	 * @param idUser - identifier of the user
	 * @param email - email of the user
	 * @param telefone - phone number of the user
	 * @param nome - name of the user
	 * @param nacionalidade - nationality of the user
	 * @param morada - address of the user
	 */
	public UserClass(String idUser, String email, String telefone, String nome, String nacionalidade, String morada){
		this.idUser = idUser;
		this.email = email;
		this.telefone = telefone;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.morada = morada;
		
		house = null;
		stays = new StackIteratorInList<House>();
	}
	
	@Override
	public String getIdUser (){
		return idUser;
	}
	
	@Override
	public String getEmail (){
		return email;
	}
	
	@Override
	public String getPhone (){
		return telefone;
	}
	
	@Override
	public String getName (){
		return nome;
	}
	
	@Override
	public String getNationality (){
		return nacionalidade;
	}
	
	@Override
	public String getAddress (){
		return morada;
	}
	
	@Override
	public void setEmail(String email){
		this.email = email;
	}
	
	@Override
	public void setPhone(String telefone){
		this.telefone = telefone;
	}
	
	@Override
	public void setAddress(String morada){
		this.morada = morada;
	}
	
	@Override
	public void setHouse(House house){
		this.house = house;
		
	}
	
	@Override
	public boolean hasHouse(){
		if (house == null)
			return false;
		return true;
	}
	
	@Override
	public void removeHouse(){
		house = null;
	}
	
	@Override
	public void addStay(House house){
		stays.push(house); 
	}
	
	@Override
	public boolean visitedHouse(){
		return !stays.isEmpty();
	}
	
	@Override
	public House getHouse(){
		return house;
	}
	
	@Override
	public Iterator<House> listStays(){
		return stays.iterator();
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	

}
