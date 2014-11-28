public class Soup extends Beverage {
	private String name = "Soup";
	private String description = "Chicken Noodle";
	private int inventory = 100;
	private final int PRICE = 75;

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
