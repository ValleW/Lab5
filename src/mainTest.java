import static org.junit.Assert.*;
import org.junit.Test;

public class mainTest {

	@Test
	public void testFrame() {
		System.out.println("-- Testing Frames --");
		main instance = new main();
		int[] frameResult = new int[2];
		frameResult = instance.frame();
		
		int totalValue = frameResult[0] + frameResult[1];
		
		assertTrue(totalValue <= 10);
		
		for(int p = 0; p < 2; p++){
			System.out.println(frameResult[p]);
		}
	}
}
