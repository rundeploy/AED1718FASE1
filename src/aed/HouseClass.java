package aed;

/**
 * Represents a House and its data
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */

public class HouseClass implements House{
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	
	/**
	 * Value to initialize the number of points of a house
	 */
	private static final int ZERO = 0;
	
	/**
	 * Unique identifier of the house.
	 */
	private String idHome;
	
	/**
	 * Price per day of staying at the house.
	 */
	private int preco;
	
	/**
	 * Maximum of people allowed to stay at the house at the same time.
	 */
	private int pessoas;
	
	/**
	 * Location of the house.
	 */
	private String local;
	
	/**
	 * Description of the house.
	 */
	private String descricao;
	
	/**
	 * Address of the house.
	 */
	private String morada;
	
	/**
	 * Total of points attributed to the house.
	 */
	private int pontos;
	
	/**
	 * Unique identifier of the user that owns the house.
	 */
	private String idUser;
	
	/**
	 * House class constructor
	 * @param idHome identifier of the house
	 * @param preco price for rent per day of the house
	 * @param pessoas maximum number of people allowed to stay at the house
	 * @param local location of the house
	 * @param descricao house description
	 * @param morada house adress
	 * @param idUser id of the owner of the house 
	 */
	public HouseClass(String idHome,int preco, int pessoas, String local, String descricao, String morada, String idUser){
		this.idHome = idHome;
		this.preco = preco;
		this.pessoas = pessoas;
		this.local = local;
		this.descricao = descricao;
		this.morada = morada;
		this.idUser = idUser;
		pontos = ZERO;
	}
	
	public String getIdHouse(){
		return idHome;
	}
	
	public String getDescrip(){
		return descricao;
	}
	
	public String getAddress(){
		return morada;
	}
	
	public String getTown(){
		return local;
	}
	
	public int getPrice(){
		return preco;
	}
	
	public int getMaxPeaople(){
		return pessoas;
	}
	
	public int getPoints(){
		return pontos;
	}
	
	public String getUserName(){
		return idUser;
	}


}
