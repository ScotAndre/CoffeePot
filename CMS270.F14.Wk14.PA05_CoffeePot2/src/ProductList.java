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

	public ProductList() {
		Beverage coffee = new Coffee();
		Beverage decaf = new Decaf();
		Beverage tea = new Tea();
		Beverage soup = new Soup();

		Condiment cream = new Cream();
		Condiment sugar = new Sugar();
		Condiment lemon = new Lemon();

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

		coffeeMenu.add(coffee);
		coffeeMenu.add(decaf);
		coffeeMenu.add(coffeeCondiments);

		teaMenu.add(tea);
		teaMenu.add(teaCondiments);

		coffeeCondiments.add(cream);
		coffeeCondiments.add(sugar);

		teaCondiments.add(cream);
		teaCondiments.add(sugar);
		teaCondiments.add(lemon);

		soupMenu.add(soup);

		CoffeePot waitress = new CoffeePot(allMenus);

		waitress.printMenu();
	}
}
