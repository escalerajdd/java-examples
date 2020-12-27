package escalera.jdd.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import escalera.jdd.behavioral.chainofresponsibility.Burger;
import escalera.jdd.behavioral.chainofresponsibility.IngredientNotFoundException;
import escalera.jdd.behavioral.chainofresponsibility.Kitchen;

public class BehavioralPatternsTest {

	@Test
	public void chainOfResponsibilityTest() throws IngredientNotFoundException {
		Burger famous = new Burger();
		famous.setName("Famous");
		famous.setLettuceIncluded(true);
		famous.setMeatIncluded(true);
		famous.setTomatoIncluded(true);

		Kitchen kitchen = new Kitchen();
		kitchen.addMeal(famous);
		kitchen.dispatch();

		assertFalse(kitchen.hasPendingMeals());
	}

	@Test
	public void chainOfResponsibilityIngredientNotFoundTest() {
		Burger bigOne = new Burger();
		bigOne.setName("The Big One");
		bigOne.setLettuceIncluded(true);
		bigOne.setMeatIncluded(false);
		bigOne.setTomatoIncluded(true);

		Kitchen kitchen = new Kitchen();
		kitchen.addMeal(bigOne);
		assertThrows(IngredientNotFoundException.class, () -> {
			kitchen.dispatch();
		});
	}

}
