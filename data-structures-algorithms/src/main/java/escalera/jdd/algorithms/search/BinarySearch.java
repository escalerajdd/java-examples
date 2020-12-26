package escalera.jdd.algorithms.search;

import escalera.jdd.exceptions.ObjectNotFoundException;

public class BinarySearch<T extends Comparable<T>> {

	public T search(T[] array, T target) throws ObjectNotFoundException {
		int mid, start = 0, end = array.length - 1;
		while(end > start) {
			mid = (start + end) / 2;
			if(target.compareTo(array[mid]) > 0) {
				if(start == mid) break;
				start = mid;
			} else if(target.compareTo(array[mid]) < 0) {
				if(end == mid) break;
				end = mid;
			} else {
				return array[mid];
			}
		}
		throw new ObjectNotFoundException();
	}
	
}
