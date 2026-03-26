package cartes;

public abstract class Probleme extends Carte {

	protected Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme other) {
			return other.type == this.type;	
		}else {
			return false;
		}
	}
	
	private Type type;
	

}
