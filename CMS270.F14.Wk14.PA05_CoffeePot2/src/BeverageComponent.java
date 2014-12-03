/*
 *  BeverageComponent.java
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
public abstract class BeverageComponent {
	/**
	 * Add a beverage component object to the menu.
	 * 
	 * @param menuComponent
	 */
	public void add(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a beverage component object to the menu.
	 * 
	 * @param menuComponent
	 */
	public void remove(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public BeverageComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return
	 */
	public String getName() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return
	 */
	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return
	 */
	public int getPrice() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return
	 */
	public int getInventory() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param menuComponent
	 * @return
	 */
	public boolean isAcceptableCondiment(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 */
	public void dispense() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 */
	public void print() {
		throw new UnsupportedOperationException();
	}
}
