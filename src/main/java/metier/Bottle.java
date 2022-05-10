package metier;

public class Bottle {
	String bottle_name;
	String castle;
	int mill;
	String region;
	String color;
	int alcool;
	int garde;
	int rating;
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
	@Override
	public String toString() {
		return "Bottle [bottle_name=" + bottle_name + ", castle=" + castle + ", mill=" + mill + ", region=" + region
				+ ", color=" + color + ", alcool=" + alcool + ", garde=" + garde + ", rating=" + rating + "]";
	}
	
	
	
	

}
