package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	public Jeu() {
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, new JeuDeCartes().donnerCartes());
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] arrayCartes = listeCartes.toArray(new Carte[0]);
  		new Sabot(arrayCartes);
	}
}
