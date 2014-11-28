public class ProductList {

	public ProductList() {
		BeverageComponent coffeeMenu = new Menu("COFFEE MENU", "Coffee");
		BeverageComponent teaMenu = new Menu("TEA MENU", "Tea");
		BeverageComponent soupMenu = new Menu("SOUP MENU", "Soup");

		BeverageComponent coffeeCondiments = new Menu("COFFEE CONDIMENTS",
				"Don't like it black!");
		BeverageComponent teaCondiments = new Menu("TEA Condiments",
				"Tea Condiments");

		BeverageComponent allMenus = new Menu("ALL MENUS",
				"All menus combined.");

		allMenus.add(coffeeMenu);
		allMenus.add(teaMenu);
		allMenus.add(soupMenu);

		coffeeMenu.add(new Beverage("Coffee", "Dark Roast", 100, 35));
		coffeeMenu.add(new Beverage("Decaf", "Decaf Coffee", 100, 35));
		coffeeMenu.add(coffeeCondiments);

		teaMenu.add(new Beverage("Tea", "Hot Black Tea", 100, 60));
		teaMenu.add(teaCondiments);

		coffeeCondiments
				.add(new Beverage("Cream", "Non-Dairy Creamer", 100, 0));
		coffeeCondiments.add(new Beverage("Sugar", "Sugar", 3, 0));

		teaCondiments.add(new Beverage("Cream", "Non-Dairy Creamer", 100, 0));
		teaCondiments.add(new Beverage("Sugar", "Sugar", 3, 0));
		teaCondiments.add(new Beverage("Lemon", "Lemon Juice", 100, 0));

		soupMenu.add(new Beverage("Soup", "Chicken Noodle Soup", 100, 75));

		CoffeePot waitress = new CoffeePot(allMenus);

		waitress.printMenu();
	}
}
