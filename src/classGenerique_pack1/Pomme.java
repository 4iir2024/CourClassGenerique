package classGenerique_pack1;

public class Pomme  implements Comparable<Pomme>{
	
	private int poids;
	private String color;
	public Pomme(int poids, String color) {
		super();
		this.poids = poids;
		this.color = color;
	}
	@Override
	public int compareTo(Pomme o) {
		// TODO Auto-generated method stub
		return this.poids-o.poids;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	@Override
	public String toString() {
		return "Pomme [poids=" + poids + ", color=" + color + "]";
	}
	
	

}
