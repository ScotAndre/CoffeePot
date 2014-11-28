
/*
 *  Condiment.java
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

public class Condiment extends BeverageComponent {
	String name;
	String description;
	int inventory;

	public Condiment() {

	}

	public Condiment(String name, String description, int inventory) {
		this.name = name;
		this.description = description;
		this.inventory = inventory;
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
	public void print() {
		System.out.println("  " + getName());
		System.out.println("    -- " + getDescription());
	}

}
