package metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Cave {
	int id;
	HashMap<Integer, ArrayList<Bottle>> cave = new HashMap<Integer,ArrayList<Bottle>>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<Integer, ArrayList<Bottle>> getCave() {
		return cave;
	}

	public void setCave(HashMap<Integer, ArrayList<Bottle>> cave) {
		this.cave = cave;
	}

	public Cave(int user_id) {
		this.id=user_id;
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		
		cave.put(this.id, bottles);
		
	}
	
	public void addNewBottleFromList(int user_id,Bottle bottle) {
		if(!cave.containsKey(user_id)){
			cave.put(user_id, new ArrayList<Bottle>());
		}
		cave.get(user_id).add(bottle);
		
	}

}
