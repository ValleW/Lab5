import static org.junit.Assert.*;
import org.junit.Test;

public class mainTest {

	@Test
	public void testFrame() {
		System.out.println("-- Testing Frame --");
		main instance = new main();
		int[] frameResult = new int[2];
		frameResult = instance.frame();
		
		assertTrue(frameResult[0] <= 10);
		assertTrue(frameResult[1] <= 10 - frameResult[0]);
		
		/* Prints for readability */
		System.out.println("F1:" + frameResult[0] + "\nF2:" + frameResult[1]);
	}
	
	@Test
	public void testFrameScore(){
		System.out.println("-- Testing Frame Score --");
		main instance = new main();
		
		int[] frameResult = new int[2];
		frameResult = instance.frame();
		
		assertTrue(instance.frameScore(frameResult) <= 10);
		
		/* Prints for readability */
		System.out.println("F1:" + frameResult[0] + "\nF2:" + frameResult[1]);
		System.out.println("Total: " + instance.frameScore(frameResult));
	}
	
	@Test
	public void testGameFrames(){
		System.out.println("-- Testing Game Frames --");
		main instance = new main();
		
		int[] gameResult = new int[10];
		frameResult = instance.game();
		
		/* prints for readability */
		for(int p = 0; p < 10; p++){
			System.out.println(frameResult[p]);
		}
	}
}
