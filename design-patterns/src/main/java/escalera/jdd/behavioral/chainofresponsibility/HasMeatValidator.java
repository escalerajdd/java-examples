package escalera.jdd.behavioral.chainofresponsibility;

public class HasMeatValidator extends BurgerValidator {

	@Override
	public boolean check(Burger burger) {
		if (burger.isMeatIncluded())
			System.out.println(String.format("%s burger has meat...", burger.getName()));
		else
			System.out.println(String.format("%s burger does not have meat...", burger.getName()));
		return burger.isMeatIncluded();
	}

}
