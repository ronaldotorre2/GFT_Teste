package app;

import br.com.teste.app.module.FoodAction;
import junit.framework.TestCase;

public class ProgramTest extends TestCase {

	public void teste() {

		FoodAction action = new FoodAction();
		
		assertEquals("Eggs,Toast,Coffee", action.order("11:41", "1,2,3"));
		assertEquals("Eggs,Toast,Coffee", action.order("11:41", "2,1,3"));
		assertEquals("Eggs,Toast,Coffee,error", action.order("11:41", "1,2,3,4"));
		assertEquals("Eggs,Toast,Coffee(x3)", action.order("11:41", "1,2,3,3,3"));
		
	}
}