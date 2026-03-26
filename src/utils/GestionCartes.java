package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	static Random rng = new Random();
	
	public static <T> T extraire(List<T> collection) {
		return collection.remove(rng.nextInt(collection.size()));
	}

	public static <T> T extraireIterator(List<T> collection) {
		Iterator<T> iterator = collection.listIterator();
		for (int i = 0; i < random.nextInt(collection.size()) - 1; i++) {
			iterator.next();
		}

		T result = iterator.next();
		iterator.remove();
		return result;
	}

	public static <T> List<T> melanger(List<T> collection) {
		int size = collection.size();
		List<T> result = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			result.addLast(extraire(collection));
		}
		return result;
	}

	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		for (T element : l1) {
			if (Collections.frequency(l1, element) != Collections.frequency(l2, element)) {
				return false;
			}
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> collection) {
		List<T> result = new ArrayList<>();

		Iterator<T> readIterator = collection.iterator();
		while (readIterator.hasNext()) {
			T reed = readIterator.next();
			Iterator<T> supprIterator = collection.iterator();

			while (supprIterator.hasNext()) {
				T elem = supprIterator.next();
				if (elem.equals(reed)) {
					result.addLast(elem);
					supprIterator.remove();
				}
			}
		}

		return result;
	}

	public static <T> boolean verifierRassemblement(List<T> collection) {
		if(collection.isEmpty()) {
			return true;
		}
		
		ListIterator<T> firstIterator = collection.listIterator();
		T curr = firstIterator.next();
		while(firstIterator.hasNext()) {
			if(!curr.equals(firstIterator.next())) {
				int index = firstIterator.previousIndex();
				ListIterator<T> secondIterator = collection.listIterator(index);
				
				while(secondIterator.hasNext()) {
					if(secondIterator.next().equals(curr)) {
						return false;	
					}
				}
				
			}
		}
		return true;
	}

	private static Random random = new Random();

}
