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
	public void add(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public BeverageComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public int getPrice() {
		throw new UnsupportedOperationException();
	}

	public int getInventory() {
		throw new UnsupportedOperationException();
	}

	public boolean isAcceptableCondiment(BeverageComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void dispense() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}
}
