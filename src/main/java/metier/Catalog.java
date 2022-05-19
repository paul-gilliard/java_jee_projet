package metier;

import java.util.ArrayList;

public class Catalog {
	private static Catalog instance;
	private ArrayList<Bottle> bottles = new ArrayList<>();
	
	public Catalog() {
		getInstance();
		
	}

	public static Catalog getInstance() {
		if ( instance == null) {
    		instance = new Catalog();
    	}
    	return instance;
	}
	
	public void addNewBottle(Bottle bottle) {
		bottles.add(bottle);
	}

}
