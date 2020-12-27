package escalera.jdd.behavioral.chainofresponsibility;

public class HasLettuceValidator extends BurgerValidator {

	@Override
	public boolean check(Burger burger) {
		if (burger.isLettuceIncluded())
			System.out.println(String.format("%s burger has lettuce...", burger.getName()));
		else
			System.out.println(String.format("%s burger does not have lettuce...", burger.getName()));
		return burger.isLettuceIncluded();
	}

}
