public class Decaf extends Beverage {
	private String name = "Decaf";
	private String description = "Decaf Coffee";
	private int inventory = 100;
	private final int PRICE = 35;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public int getInventory() {
		return inventory;
	}

	@Override
	public int getPrice() {
		return PRICE;
	}

}
