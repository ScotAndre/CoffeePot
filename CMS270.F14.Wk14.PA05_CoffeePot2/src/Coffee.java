import java.text.DecimalFormat;

/*
 *  Coffee.java
 *  
 *  Scot Andre      sandre@rollins.edu
 *  Juan Recinos    jrecinos@rollins.edu
 *  Katie Shiver    kshiver@rollins.edu
 *  Patrick Skelly  pskelly@rollins.edu
 *  
 *  Coffee Pot Project
 *  Dr. Carrington
 *  CMS270.H1
 *  Fall 2014
 *
 */
public class Coffee extends Beverage {
	DecimalFormat df = new DecimalFormat("##0.00");
	private String name = "Coffee";
	private String description = "Black Coffee";
	private int inventory = 100;
	private final int PRICE = 35;
	private String[] condiments = { "Cream", "Sugar" };

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getInventory() {
		return inventory;
	}

	@Override
	public int getPrice() {
		return PRICE;
	}

	@Override
	public void dispense() {
		inventory--;
		System.out.println("Coffee dispensed.");
	}

	public boolean hasEnough(int num) {
		if (num > inventory) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isAcceptableCondiment(String condiment) {
		for (int i = 0; i < condiments.length; i++) {
			if (condiments[i].equals(condiment)) {
				return true;
			}
		}
		return false;
	}// end isAcceptable()

	@Override
	public String toString() {
		return name + "\t" + df.format(PRICE / 100.0);
	}
}
