package metier;

import java.util.HashMap;
import java.util.List;

import xmlGenerator.GenerateCaveXml;
import xmlGenerator.GenerateUserXml;
import xmlGenerator.generatorCatalogXml;

public class Users {
	String pseudo;
	String name;
	String surname;
	String password;
	static int idInc;
	int id;
	Cave cave;

	public Users() {
		GenerateUserXml gen = new GenerateUserXml();
		int goodId = gen.idIncrementedUser();
		if(goodId == 0) {
			this.id =1;
		} else {
			this.id = goodId+1;
		}
		cave = new Cave(this.getId());
		}
	public Users(String pseudo) {
		this.pseudo=pseudo;
	
		
	}
	
	public Cave getCave() {
		return this.cave;
	}

	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public void setPassword(String password) {
		this.password = password;
		
	}
	public String getSurname() {
		return surname;
	}


	public String getPassword() {
		return password;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Users [pseudo=" + pseudo + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", id=" + id + ", cave=" + cave + "]";
	}
	
	public HashMap<String, List> getBottles(){
		GenerateCaveXml gen = new GenerateCaveXml();
		return gen.getBottlesOfUser(this.id);
	}
	
	public HashMap<String, List> getBottlesById(String bottleId){
		generatorCatalogXml gen = new generatorCatalogXml();
		return gen.getOneBottleFromCatalogById(bottleId);
	}
	
	

}
