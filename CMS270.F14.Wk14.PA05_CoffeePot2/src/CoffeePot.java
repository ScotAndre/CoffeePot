
public class CoffeePot {
	BeverageComponent allMenus;
	
	public CoffeePot(BeverageComponent allMenus){
		this.allMenus = allMenus;
	}
	
	public void printMenu(){
		allMenus.print();
	}
}
