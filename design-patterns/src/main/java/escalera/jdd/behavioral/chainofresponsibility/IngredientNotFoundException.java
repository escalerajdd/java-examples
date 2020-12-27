package escalera.jdd.behavioral.chainofresponsibility;

public class IngredientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public IngredientNotFoundException() {
		super("Ingredient not found");
	}

}
