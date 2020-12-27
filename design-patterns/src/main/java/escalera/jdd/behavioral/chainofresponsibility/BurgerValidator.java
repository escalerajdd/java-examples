package escalera.jdd.behavioral.chainofresponsibility;

import static java.util.Objects.isNull;

public abstract class BurgerValidator {

	private BurgerValidator nextValidator;

	protected BurgerValidator link(BurgerValidator validator) {
		this.nextValidator = validator;
		return this.nextValidator;
	}

	protected abstract boolean check(Burger burger);

	public boolean validate(Burger burger) throws IngredientNotFoundException {
		boolean burgerIsValid = this.check(burger);
		if (burgerIsValid)
			return isNull(nextValidator) ? true : nextValidator.validate(burger);
		else
			throw new IngredientNotFoundException();
	}

}
