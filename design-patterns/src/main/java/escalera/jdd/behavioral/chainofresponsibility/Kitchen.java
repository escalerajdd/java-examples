package escalera.jdd.behavioral.chainofresponsibility;

import java.util.LinkedList;
import java.util.Queue;

public class Kitchen {

	private Queue<Burger> meals;

	private BurgerValidator validator;

	public Kitchen() {
		meals = new LinkedList<Burger>();
		validator = new HasTomatoValidator();
		validator.link(new HasMeatValidator())//
				.link(new HasLettuceValidator());
	}

	public void addMeal(Burger burger) {
		meals.add(burger);
	}

	public boolean hasPendingMeals() {
		return !meals.isEmpty();
	}

	public void dispatch() throws IngredientNotFoundException {
		while (!meals.isEmpty()) {
			Burger burger = meals.remove();
			if (validator.validate(burger))
				System.out.println(String.format("Dispatching %s burger", burger.getName()));
			else
				System.out.println(String.format("An error occurred while producing %s burger", burger.getName()));
		}
	}

}
