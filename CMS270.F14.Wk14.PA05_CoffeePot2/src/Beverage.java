public class Beverage extends BeverageComponent {
	String name;
	String description;
	int inventory;
	int price;

	public Beverage(String name, String description, int inventory, int price) {
		this.name = name;
		this.description = description;
		this.inventory = inventory;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public boolean hasEnough() {
		return true;
	}

	@Override
	public void print() {
		System.out.print("  " + getName());
		System.out.println(", " + getPrice());
		System.out.println("    -- " + getDescription());
	}
}
