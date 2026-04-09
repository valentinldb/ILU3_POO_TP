package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;
	
public class Sabot implements Iterable<Carte>{

	private int nbCartes;
	private int nbOperations = 0;
	private Carte[] cartes;
	Iterator<Carte> iterateur = iterator();

	public Sabot(Carte[] cartes) {
		this.nbCartes = cartes.length;
		this.cartes = cartes;
	}

	public boolean estVide() {
		return this.nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if(nbCartes < cartes.length) {
			cartes[nbCartes] = carte;
			nbCartes++;
		} else {
			throw new IllegalStateException("Dépassement de capacité");			
		}
		nbOperations++;
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte result = it.next();
		it.remove();
		return result;		
		
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}

	public class SabotIterator implements Iterator<Carte> {


		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationReference = nbOperations;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperationReference++;
			nbOperations++;
		}
		
		private void verificationConcurrence() {
			if(nbOperationReference != nbOperations)
				throw new ConcurrentModificationException();
		}

//		private void verifyNextEffected() {
//			if (!nextEffectue) {
//				throw new IllegalStateException();
//			}
//		}
//
//		private void verifyNext() {
//			if (!hasNext()) {
//				throw new IndexOutOfBoundsException();
//			}
//		}


	}


}