package metier;

public class Users {
	String pseudo;
	String name;
	static int idInc;
	int id;

	
	public Users() {
		this.id = idInc;
		idInc++;
		Cave cave = new Cave(this.getId());
		}
	
	
	public void addNewBottle() {
		
		
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
	
	

}
