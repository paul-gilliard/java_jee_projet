package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlGenerator.generatorCatalogXml;

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
