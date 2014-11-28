import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends BeverageComponent {
	ArrayList<BeverageComponent> menuComponents = new ArrayList<BeverageComponent>();
	String name;
	String description;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(BeverageComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(BeverageComponent menuComponent) {
		menuComponent.remove(menuComponent);
	}

	@Override
	public BeverageComponent getChild(int index) {
		return menuComponents.get(index);
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
		System.out.print("\n" + getName());
		System.out.print(", " + getDescription());
		System.out.println("---------------------");

		Iterator<BeverageComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			BeverageComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}
}
