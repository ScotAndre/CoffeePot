public class Lemon extends Condiment {
	private String name = "Lemon";
	private String description = "Lemon Concentrate";
	private int inventory = 100;

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

}
