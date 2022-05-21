package metier;

import java.util.ArrayList;

public class Catalog {
	private static Catalog instance;
	private ArrayList<Bottle> bottles = new ArrayList<>();
	


	public static Catalog getInstance() {
		if ( instance == null) {
    		instance = new Catalog();
    	}
    	return instance;
	}
	
	public void addNewBottle(int user_id,Bottle bottle) {
		bottles.add(bottle);
		//Cave.addNewBottle(user_id,bottle);
	}

}
