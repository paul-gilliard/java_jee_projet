package metier;

import java.util.Objects;
import xmlGenerator.generatorCatalogXml;

public class Bottle {
	String bottle_name;
	String castle;
	int mill;
	String region;
	String color;
	int alcool;
	int garde;
	int rating;
	int id;
	
	public Bottle(String bottle_name,String castle,int mill,String region,String color,int alcool,int garde,int rating) {
		this.bottle_name = bottle_name;
		this.alcool =alcool;
		this.castle=castle;
		this.mill = mill;
		this.region=region;
		this.color=color;
		this.garde=garde;
		this.rating=rating;
		generatorCatalogXml gen = new generatorCatalogXml();
		int goodId = gen.idIncrementedBottle();
		if(goodId == 0) {
			this.id =1;
		} else {
			this.id = goodId;
		}
		
	}
	public String getBottle_name() {
		return bottle_name;
	}
	public void setBottle_name(String bottle_name) {
		this.bottle_name = bottle_name;
	}
	public String getCastle() {
		return castle;
	}
	public void setCastle(String castle) {
		this.castle = castle;
	}
	public int getMill() {
		return mill;
	}
	public void setMill(int mill) {
		this.mill = mill;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAlcool() {
		return alcool;
	}
	public void setAlcool(int alcool) {
		this.alcool = alcool;
	}
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
		this.garde = garde;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getId() {
		return this.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alcool, bottle_name, castle, color, garde, id, mill, rating, region);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bottle other = (Bottle) obj;
		return alcool == other.alcool && Objects.equals(bottle_name, other.bottle_name)
				&& Objects.equals(castle, other.castle) && Objects.equals(color, other.color) && garde == other.garde
				&& id == other.id && mill == other.mill && rating == other.rating
				&& Objects.equals(region, other.region);
	}
	@Override
	public String toString() {
		return "Bottle [bottle_name=" + bottle_name + ", castle=" + castle + ", mill=" + mill + ", region=" + region
				+ ", color=" + color + ", alcool=" + alcool + ", garde=" + garde + ", rating=" + rating + "]";
	}
	
	
	
	

}
