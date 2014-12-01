import java.util.ArrayList;

public class Order {
	// private BeverageComponent coffee = new Coffee();
	// private BeverageComponent decaf = new Decaf();
	// private BeverageComponent tea = new Tea();
	// private BeverageComponent soup = new Soup();
	//
	// private BeverageComponent cream = new Cream();
	// private BeverageComponent lemon = new Lemon();
	// private BeverageComponent sugar = new Sugar();

	private ArrayList<BeverageComponent> order = new ArrayList<BeverageComponent>();

	public Order() {
	}

	public void add(BeverageComponent beverage) {
		order.add(beverage);
	}

	public void remove(BeverageComponent beverage) {
		order.remove(beverage);
	}

	public ArrayList getOrder() {
		return order;
	}

	public void cancelOrder() {
		for (int i = order.size() - 1; i >= 0; i--) {
			order.remove(order.get(i));
		}
	}

	public void dispense() {
		for (int i = order.size() - 1; i >= 0; i--) {
			order.get(i).dispense();
			order.remove(i);
		}
	}

}
