
/*
 *  Beverage.java
 *  
 *  Scot Andre      sandre@rollins.edu
 *  Juan Recinos    jrecinos@rollins.edu
 *  Katie Shiver    kshiver@rollins.edu
 *  Patrick Skelly  pskelly@rollins.edu
 *  
 *  
 *  
 *  
 *  
 *  Coffee Pot Project
 *  Dr. Carrington
 *  CMS270.H1
 *  Fall 2014
 *
 */
public class Beverage extends BeverageComponent {
	private String name;
	private String description;
	private int inventory;
	private int price;

	public Beverage() {

	}

	@Override
	@Override
	public String getName() {
		return name;
	}

	@Override
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	@Override
	public int getPrice() {
		return price;
	}

	@Override
	@Override
	public void dispense() {

	}

	@Override
	@Override
	public void print() {
		DecimalFormat df = new DecimalFormat("##0.00");
		double bevPrice = getPrice() / 100.0;
		System.out.print("  " + getName());
		System.out.println(", $ " + df.format(bevPrice));
		System.out.println("    -- " + getDescription());
	}

	public boolean isAcceptableCondiment(String condiment) {
		return false;
	}// end isAcceptable()
}
