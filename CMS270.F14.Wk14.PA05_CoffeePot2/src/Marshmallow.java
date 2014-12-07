/*
 *  Marshmallow.java
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
public class Marshmallow extends Condiment {
	private String name = "Marshmallow";
	private String description = "Miniture Marshmallows";
	private int inventory = 100;

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
	public void dispense() {
		inventory = -3;
		System.out.println("Marshmallows dispensed.");
	}
}
