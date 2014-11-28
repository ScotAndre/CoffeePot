public class Sugar extends Condiment {
	private String name = "Sugar";
	private String description = "All-Natural Sugar";
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
