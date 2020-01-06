import java.util.Scanner;

public class CoffeeMachine {

	public Drink[] Drinks;
	public int deposit;
	public int choice;
	public boolean isMoneyTaken;
	public boolean isDone;

	public CoffeeMachine() {
		isDone = false;
		Drinks = new Drink[3];
		for (int i = 0; i < Drinks.length; i++) {
			Drinks[i] = new Drink();
			Drinks[i].id = i;
		}
		Drinks[0].name = "Coffe";
		Drinks[0].price = 10;
		Drinks[1].name = "Tee";
		Drinks[1].price = 9;
		Drinks[2].name = "Capuchino";
		Drinks[2].price = 15;
	}

	public void start() {
		for (Drink d : Drinks) {
			System.out.println(d);
		}
		System.out.println();
		takeMoney();
	}

	public void takeMoney() {
		isMoneyTaken = false;
		System.out.println("Input money, grn");
		Scanner in = new Scanner(System.in);
		try {
			deposit += Integer.parseInt(in.next());
			isMoneyTaken = deposit > 0 ? true : false;
		} catch (NumberFormatException e) {
			System.out.println("Not correct");
		} catch (Exception e) {
			System.out.println("Error input = " + e.getMessage());
		}

		if (isMoneyTaken) {
			putDrink();
		}
//		showDeposit("take money --- ");

	}

	public void showDeposit(String str) {
		System.out.println(str + deposit);
	}

	public void putDrink() {
		System.out.println("Select drink");
		Scanner in = new Scanner(System.in);
		try {
			choice = Integer.parseInt(in.next());
			if (choice < Drinks.length && deposit >= Drinks[choice].price) {
				System.out.print("Prepearing. Please wait ");
				for (int i = 0; i < 7; i++) {					
					System.out.print(".");
					Thread.sleep(500);
				}
				System.out.println("\nTake your " + Drinks[choice].name);
				deposit -= Drinks[choice].price;
				isDone = true;
			} else
				System.out.println("\nNo enouth cash or incorrect input. You have " + deposit + " grn\n");
		} catch (NumberFormatException e) {
			System.out.println("Not correct");
		} catch (Exception e) {
			System.out.println("Error input = " + e.getMessage());
		}
//		showDeposit("put drink --- ");
		if (isDone) {
			putChange();
		}
	}

	public void putChange() {

		System.out.println(deposit > 0 ? "\nTake your change " + deposit + " grn." : "");
		System.out.println("Thank you!");
	}
}
