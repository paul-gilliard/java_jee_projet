package metier;

import java.util.ArrayList;
import java.util.HashMap;

import xmlGenerator.GenerateCaveXml;

public class Cave {
	int id;
	HashMap<String, ArrayList<Bottle>> cave = new HashMap<String,ArrayList<Bottle>>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, ArrayList<Bottle>> getCave() {
		return cave;
	}

	public void setCave(HashMap<String, ArrayList<Bottle>> cave) {
		this.cave = cave;
	}

	public Cave(int user_id) {
		this.id=user_id;
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		
		cave.put("b"+String.valueOf(this.id), bottles);
		
	}
	
	public void addNewBottleFromList(int user_id,Bottle bottle) {
		if(!cave.containsKey(user_id)){
			//cave.put(user_id, new ArrayList<Bottle>());
		}
		cave.get(user_id).add(bottle);
		
	}
	
	public int getSize() {
		return cave.size();
	}
	
	
	public void addNewBottle(int idUser, Bottle bottle) {
		GenerateCaveXml genCave = new GenerateCaveXml();
		genCave.addBottle(idUser, bottle);
	}
	
	 //besoin de r�cup l'ID utilisateur depuis le formulaire

}
