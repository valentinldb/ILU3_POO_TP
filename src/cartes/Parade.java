package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getType().getMsgParade();
	}
}
