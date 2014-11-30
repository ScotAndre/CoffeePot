import java.util.ArrayList;

/*
 *  ProductList.java
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
public class ProductList {
	// All Condiments
	private ArrayList<Condiment> allCondiments = new ArrayList<Condiment>();
	private Condiment cream = new Cream();
	private Condiment sugar = new Sugar();
	private Condiment lemon = new Lemon();

	// All Products
	private ArrayList<Beverage> allBeverages = new ArrayList<Beverage>();
	private Beverage coffee = new Coffee();
	private Beverage decaf = new Decaf();
	private Beverage tea = new Tea();
	private Beverage soup = new Soup();

	private BeverageComponent coffeeCondiments = new Menu("COFFEE CONDIMENTS",
			"Enhance Your Coffee!");

	public ProductList() {
		allCondiments();
		allBeverages();

		BeverageComponent coffeeMenu = new Menu("COFFEE MENU", "Coffee");
		BeverageComponent teaMenu = new Menu("TEA MENU", "Tea");
		BeverageComponent soupMenu = new Menu("SOUP MENU", "Soup");

		BeverageComponent teaCondiments = new Menu("TEA Condiments",
				"Tea Condiments");

		BeverageComponent allMenus = new Menu("ALL MENUS",
				"All menus combined.");

		allMenus.add(coffeeMenu);
		allMenus.add(teaMenu);
		allMenus.add(soupMenu);

		coffeeMenu.add(coffee);
		coffeeMenu.add(decaf);
		coffeeMenu.add(coffeeCondiments);

		teaMenu.add(tea);
		teaMenu.add(teaCondiments);

		// acceptable condiments for coffee
		for (int i = 0; i < allCondiments.size(); i++) {
			if (coffee.isAcceptableCondiment(allCondiments.get(i).getName())) {
				coffeeCondiments.add(allCondiments.get(i));
			}
		}

		// acceptable condiments for tea
		for (int i = 0; i < allCondiments.size(); i++) {
			if (tea.isAcceptableCondiment(allCondiments.get(i).getName())) {
				teaCondiments.add(allCondiments.get(i));
			}
		}

		soupMenu.add(soup);

		CoffeePot thePot = new CoffeePot(allMenus);

		thePot.printMenu();
	}

	private void allCondiments() {
		allCondiments.add(cream);
		allCondiments.add(lemon);
		allCondiments.add(sugar);
	}

	private void allBeverages() {
		allBeverages.add(coffee);
		allBeverages.add(decaf);
		allBeverages.add(tea);
		allBeverages.add(soup);
	}

	public ArrayList getAllCondiments() {
		return allCondiments;
	}

	public ArrayList getAllBeverages() {
		return allBeverages;
	}

	public BeverageComponent getCoffeeCondiments() {
		return coffeeCondiments;
	}
}
