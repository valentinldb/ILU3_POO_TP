package cartes;

public abstract class Carte {
	@Override
	public String toString() {
		return "Carte ";
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass() == this.getClass();
	}
}
