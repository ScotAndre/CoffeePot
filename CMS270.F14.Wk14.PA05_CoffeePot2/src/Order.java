import java.util.ArrayList;

public class Order {

	private ArrayList<BeverageComponent> order = new ArrayList<BeverageComponent>();

	public Order() {
	}

	public void add(BeverageComponent beverage) {
		order.add(beverage);
	}

	public void remove(BeverageComponent beverage) {
		order.remove(beverage);
	}

	public ArrayList<BeverageComponent> getOrder() {
		return order;
	}

	public void cancelOrder() {
		for (int i = order.size() - 1; i >= 0; i--) {
			order.remove(order.get(i));
		}
	}

	public void dispense() {
		BeverageComponent beverage;
		for (int i = order.size() - 1; i >= 0; i--) {
			beverage = order.get(i);
			beverage.dispense();
			order.remove(i);
		}
	}

}
