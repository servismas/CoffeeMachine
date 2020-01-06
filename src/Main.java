
public class Main {

	public static void main(String[] args) {
		
		CoffeeMachine cm = new CoffeeMachine();
		
		while (!cm.isDone) {
			cm.start();			
		}
	}
}
