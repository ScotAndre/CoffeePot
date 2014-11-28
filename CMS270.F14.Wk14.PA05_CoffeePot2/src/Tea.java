public class Tea extends Beverage {
	private String name = "Tea";
	private String description = "Black Tea";
	private int inventory = 100;
	private final int PRICE = 60;

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
