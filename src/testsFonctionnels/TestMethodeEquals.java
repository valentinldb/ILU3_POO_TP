package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	static private void test1() {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);

		if (!b1.equals(b2) || !b2.equals(b1)) {
			System.out.println("Error with Borne.equal");
		}
		return;
	}

	static private void test2() {
		Attaque f1 = new Attaque(Type.FEU);
		Attaque f2 = new Attaque(Type.FEU);

		if (!f1.equals(f2) || !f2.equals(f1)) {
			System.out.println("Error with Attaque.equal");
		}
		return;
	}

	static private void test3() {
		Attaque f1 = new Attaque(Type.FEU);
		Parade f2 = new Parade(Type.FEU);

		if (f1.equals(f2) || f2.equals(f1)) {
			System.out.println("Error with Attaque/Parade.equal");
		}
		return;
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
		System.out.println("TEST DONE !");
	}

}
