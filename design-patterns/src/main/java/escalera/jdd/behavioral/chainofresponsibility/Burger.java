package escalera.jdd.behavioral.chainofresponsibility;

public class Burger {

	private String name;

	private boolean tomatoIncluded;

	private boolean lettuceIncluded;

	private boolean meatIncluded;

	public boolean isTomatoIncluded() {
		return tomatoIncluded;
	}

	public void setTomatoIncluded(boolean tomatoIncluded) {
		this.tomatoIncluded = tomatoIncluded;
	}

	public boolean isLettuceIncluded() {
		return lettuceIncluded;
	}

	public void setLettuceIncluded(boolean lettuceIncluded) {
		this.lettuceIncluded = lettuceIncluded;
	}

	public boolean isMeatIncluded() {
		return meatIncluded;
	}

	public void setMeatIncluded(boolean meatIncluded) {
		this.meatIncluded = meatIncluded;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
