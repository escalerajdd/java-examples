package escalera.jdd.behavioral.chainofresponsibility;

public class HasTomatoValidator extends BurgerValidator {

	@Override
	public boolean check(Burger burger) {
		if (burger.isTomatoIncluded())
			System.out.println(String.format("%s burger has tomato...", burger.getName()));
		else
			System.out.println(String.format("%s burger does not have tomato...", burger.getName()));
		return burger.isTomatoIncluded();
	}

}
