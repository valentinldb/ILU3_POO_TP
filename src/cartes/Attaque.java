package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getType().getMsgAttaque();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && obj instanceof Attaque;
	}
}
