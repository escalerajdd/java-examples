package escalera.jdd.test.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import escalera.jdd.algorithms.search.BinarySearch;
import escalera.jdd.exceptions.ObjectNotFoundException;

public class SearchingAlgorithmsTest {

	@Test
	public void binarySearchTest() throws ObjectNotFoundException {
		BinarySearch<Integer> bs = new BinarySearch<>();
		Integer[] array = { 1, 3, 5, 7, 8, 9, 10, 12, 15 };
		
		Integer result = bs.search(array, 7);
		
		assertEquals(result, 7);
	}

	@Test
	public void binarySearchObjectNotFoundTest() {
		BinarySearch<Integer> bs = new BinarySearch<>();
		Integer[] array = { 1, 3, 5, 7, 8, 9, 10, 12, 15 };
		
		assertThrows(ObjectNotFoundException.class, () -> {
			bs.search(array, 2);
		});
	}

}
