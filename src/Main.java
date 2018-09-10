import java.util.Scanner;
import java.io.*;

import aed.*;
import exceptions.*;
import dataStructures.*;

/**
 *@author CRISTIAN MITUL
 *@version AED v1
 *@since 27.09.2017
 */


public class Main {
	
	private static final String ADD_USER = "IU";
	private static final String USER_ADED = "Insercao de utilizador com sucesso.\n";
	private static final String EXISTENT_USER = "Utilizador existente.\n";
	
	private static final String MOD_USER_INFO = "UU";
	private static final String USER_UPDATED = "Utilizador atualizado com sucesso.\n";
	private static final String INEXIST_USER = "Utilizador inexistente.\n";
	
	private static final String DELETE_USER = "RU";
	private static final String USER_REMOVED = "Utilizador removido com sucesso.\n";
	private static final String USER_OWNER = "Utilizador e proprietario.\n";
	
	private static final String CONSULT_USER = "GU";
	
	private static final String ADD_HOUSE = "AH"; 
	private static final String HOUSE_ADDED = "Propriedade adicionada com sucesso.\n";
	private static final String INVALID_DATA = "Dados invalidos.\n";
	private static final String ALRDY_EXIST_HOUSE = "Propriedade existente.\n";
	
	private static final String DELETE_HOUSE = "RH"; 
	private static final String HOUSE_REMOVED = "Propriedade removida com sucesso.\n";
	private static final String INEXIST_HOUSE = "Propriedade inexistente.\n";
	private static final String ALDY_VISITED_HOUSE = "Propriedade ja foi visitada.\n";
	
	private static final String CONSULT_HOUSE_INFO = "GH";
	
	private static final String RATE_STAY = "AT";
	private static final String STAY_ADDED = "Estadia adicionada com sucesso.\n";
	private static final String TOURIST_OWNER = "Viajante e o proprietario.\n";
	
	
	private static final String TOURIST_IS_NOT_OWNER = "Viajante nao e proprietario.\n";
	
	private static final String LIST_OWNER_HOUSES = "LH";
	private static final String USER_IS_NOT_OWNER = "Utilizador nao e proprietario.\n";
	
	private static final String LIST_TOURIST_STAYS = "LT"; 
	private static final String USER_NOT_TRAVELED = "Utilizador nao viajou.\n";
	
	private static final String SEARCH_HOUSES = "PH"; 
	private static final String OH_NO = "Pesquisa nao devolveu resultados.\n";
	
	private static final String LIST_BEST_H = "LB";
	private static final String EXIT = "XS";
	private static final String RECORD = "Gravando e terminando...\n"; 
	
	public static void main(String[] args) {
		
		Manager hr = load();
		Scanner in = new Scanner(System.in);
		
		if (hr == null)
			hr = new ManagerClass();
		String command = "";
		
		while (!command.equalsIgnoreCase(EXIT)){
			command = in.next();
			
			if (command.equalsIgnoreCase(ADD_USER))
				addUser(hr, in);
			else if (command.equalsIgnoreCase(MOD_USER_INFO))
				modUser(hr, in);
			else if ( command.equalsIgnoreCase(DELETE_USER))
				delUser(hr, in);
			else if (command.equalsIgnoreCase(CONSULT_USER))
				checkUser(hr, in);
			else if (command.equalsIgnoreCase(ADD_HOUSE))
				addHouse(hr, in);
			else if (command.equalsIgnoreCase(DELETE_HOUSE))
				delHouse(hr, in);
			else if (command.equalsIgnoreCase(CONSULT_HOUSE_INFO))
				checkHouse(hr, in);
			else if (command.equalsIgnoreCase(RATE_STAY))
				regStay(hr, in);
			else if (command.equalsIgnoreCase(LIST_OWNER_HOUSES))
				listOwnHouses(hr, in);
			else if (command.equalsIgnoreCase(LIST_TOURIST_STAYS))
				listTStays(hr, in);
			else if (command.equalsIgnoreCase(SEARCH_HOUSES))
				listHousesByNPeople(hr, in);
			else if (command.equalsIgnoreCase(LIST_BEST_H))
				listBestH(hr, in);
		}
		System.out.println(RECORD);
		store(hr);
	}


	private static void addUser(Manager hr, Scanner in) {
		String idUser = in.next();
		String email = in.next();
		String telefone = in.next().trim();
		String nome = in.nextLine().trim();
		String nacionalidade = in.nextLine();
		String morada = in.nextLine();
		
		try{
			hr.createUser(idUser, email, telefone, nome, nacionalidade, morada);
			System.out.println(USER_ADED);
		}catch(ExistingUserException e){
			System.out.println(EXISTENT_USER);
		}
	}
	
	private static void modUser(Manager hr, Scanner in) {
		String idUser = in.next();
		String email = in.next();
		String telefone = in.nextLine().trim();
		String morada = in.nextLine();
		
		try{
			hr.modUserData(idUser, email, telefone, morada);
			System.out.println(USER_UPDATED);
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}
	}
	
	private static void delUser(Manager hr, Scanner in) {
		String idUser = in.nextLine().trim();
		
		try{
			hr.delUser(idUser);
			System.out.println(USER_REMOVED);
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}catch(UserIsOwnerException e){
			System.out.println(USER_OWNER);
		}
	}
	
	private static void checkUser(Manager hr, Scanner in) {
		String idUser = in.nextLine().trim();
		
		try{
			User user = hr.getUser(idUser);
			System.out.println(user.getName() + ": " + user.getAddress() + ", " + user.getNationality() + ", " + user.getEmail() + ", " + user.getPhone() + "\n");
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}
		
	}
	
	private static void addHouse(Manager hr, Scanner in) {
		String idHome = in.next();
		String idUser = in.next();
		int preco = in.nextInt();
		int pessoas = in.nextInt();
		String local = in.nextLine().trim();
		String descricao = in.nextLine();
		String morada = in.nextLine();
		
		try{
			hr.addHouse(idHome, idUser, preco, pessoas, local, descricao, morada);
			System.out.println(HOUSE_ADDED);
		}catch(InvalidDataException e){
			System.out.println(INVALID_DATA);
		}catch (NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}catch (ExistingHouseException e){
			System.out.println(ALRDY_EXIST_HOUSE);
		}
	}
	
	private static void delHouse(Manager hr, Scanner in) {
		String idHome = in.nextLine().trim();
		
		try{
			hr.delHouse(idHome);
			System.out.println(HOUSE_REMOVED);
		}catch(NotExistingHouseException e){
			System.out.println(INEXIST_HOUSE);
		}catch (VisitedHouseException e ){
			System.out.println(ALDY_VISITED_HOUSE);
		}	
	}
	
	private static void checkHouse(Manager hr, Scanner in) {
		String idHome = in.nextLine().trim();
		
		try{
			House hd = hr.getHouse(idHome);
			System.out.println(hd.getDescrip() + ": " + hd.getAddress() + ", " + hd.getTown() + ", " + hd.getPrice() + ", " + hd.getMaxPeaople() + ", " + hd.getPoints() + ", " + hd.getUserName() + "\n");
		}catch(NotExistingHouseException e){
			System.out.println(INEXIST_HOUSE);
		}
	}
	
	private static void regStay(Manager hr, Scanner in) {
		String line = in.nextLine().trim();
		String[] result = line.split("\\s");
		
		String idUser = result[0];
		String idHome = result[1];
		
		try{
			if(result.length == 2){
				hr.addOwnStay(idUser, idHome);
				System.out.println(STAY_ADDED);
			}else{
				int pontos = Integer.parseInt(result[2]);
				in.nextLine();	
				hr.addTouristStay(idUser, idHome, pontos);
			}
		}catch(NumberFormatException e){
			System.out.println();
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}catch(NotExistingHouseException e){
			System.out.println(INEXIST_HOUSE);
		}catch(UserIsNotOwnerException e){
			System.out.println(TOURIST_IS_NOT_OWNER);
		}catch(InvalidDataException e){
			System.out.println(INVALID_DATA);
		}catch(UserIsOwnerException e){
			System.out.println(TOURIST_OWNER);
		}	
	}
	
	private static void listOwnHouses(Manager hr, Scanner in) {
		String idUser = in.nextLine().trim();
		
		try{
			House hd = hr.listOwnHouses(idUser);
			System.out.println(hd.getIdHouse() + " " + hd.getDescrip() + " " + hd.getAddress() + " " + hd.getTown() + " " + hd.getPrice() + " " + hd.getMaxPeaople() + " " + hd.getPoints() + "\n");
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}catch(UserIsNotOwnerException e){
			System.out.println(USER_IS_NOT_OWNER);
		}
	}
	
	private static void listTStays(Manager hr, Scanner in) {
		String idUser = in.nextLine().trim();
		try{
			Iterator<House> it = hr.listOwnStays(idUser);
			while(it.hasNext()){
				House hd = it.next();
				System.out.println(hd.getIdHouse() + " " + hd.getDescrip() + " " + hd.getAddress() + " " + hd.getTown() + " " + hd.getPrice() + " " + hd.getMaxPeaople() + " " + hd.getPoints());
				
			}
			System.out.println();
		}catch(NotExistingUserException e){
			System.out.println(INEXIST_USER);
		}catch(NotTraveledUserException e){
			System.out.println(USER_NOT_TRAVELED);
		}
	}
	
	private static void listHousesByNPeople(Manager hr, Scanner in){
		int pessoas = in.nextInt();
		String local = in.nextLine().trim();
		
		try{
			House hd = hr.listHouseByNPeople(pessoas, local);
			System.out.println(hd.getIdHouse() + " " + hd.getDescrip() + " " + hd.getAddress() + " " + hd.getTown() + " " + hd.getPrice() + " " + hd.getMaxPeaople() + " " + hd.getPoints() + "\n");
		}catch(InvalidDataException e){
			System.out.println(INVALID_DATA);
		}catch(NoHousesWNPeopleException e){
			System.out.println(OH_NO);
		}
	}
	
	private static void listBestH(Manager hr, Scanner in) {
		String local = in.nextLine().trim();
		
		try{
			House hd = hr.listHouseByPlace(local);
			System.out.println(hd.getIdHouse() + " " + hd.getDescrip() + " " + hd.getAddress() + " " + hd.getTown() + " " + hd.getPrice() + " " + hd.getMaxPeaople() + " " + hd.getPoints() + "\n");
		}catch(NoHouseInThisPlaceException e){
			System.out.println(OH_NO);
		}
		
		
	}
	
	/**
	 * Saves all the data from memory to a file to be used/loaded the next time the system will be initialized
	 * @param fit saves the all current system information
	 */
	private static void store(Manager hr){
		try{
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("file"));
			file.writeObject(hr);
			file.flush();
			file.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads data from file into the memory of our system
	 * @return gets the data of the last system successfully exit
	 */
	private static Manager load(){
		Manager man = null;
		try{
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("file"));
			man = (Manager) file.readObject();
			file.close();
			
		}catch (IOException e){
			man = new ManagerClass();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}
		return man;
	}
	
}



