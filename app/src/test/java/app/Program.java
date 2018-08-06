package app;

import br.com.teste.app.module.FoodAction;

public class Program {

	public static void main(String[] args) {
		
		FoodAction action = new FoodAction();
		
		action.order("11:41", "1,2,3");
		action.order("11:41", "2,1,3");
		action.order("11:41", "1,2,3,4");
		action.order("11:41", "1,2,3,3,3");
		action.order("19:01", "1,2,3,4");
		action.order("19:01", "1,2,2,4");
		
	}

}
