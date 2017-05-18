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
		
		int[][] gameResult = new int[10][2];
		gameResult = instance.game();
		
		/* prints for readability */
		System.out.print("Frames: ");
		for(int p = 0; p < 10; p++){
			System.out.print(gameResult[p][0] + ", " + gameResult[p][1] + " | ");
		}
	}
	
	@Test
	public void testGameScore() {
		System.out.println("\n-- Testing Game Score --");
		main instance = new main();
		
		int[][] game = new int[10][2];
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {1, 2};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score);
		assertTrue(score == 30);
	}
	
	@Test
	public void testStrike() {
		System.out.println("\n-- Testing Strike --");
		main instance = new main();
		System.out.println("Testing: |10, 0|");
		assertTrue(instance.isStrike(new int[] {10, 0}));

		// Create a prefilled game with specific numbers so we can verify the score
		int[][] game = new int[10][2];
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {1, 2};
		// Set first frame to a strike
		game[0] = new int[] {10, 0};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score);
		assertTrue(score == 40);
	}
	
	@Test
	public void testSpare() {
		System.out.println("\n-- Testing Spare --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {4, 3};
		
		// Set first frame to a Spare
		game[0] = new int[] {1, 9};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + "\n");
		assertTrue(score == 77);
	}
	
	@Test
	public void testStrikeAndSpare() {
		System.out.println("\n-- Testing Strike And Spare --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++) 
			game[i] = new int[] {2, 2};
		
		// Set first frame to a Strike and second frame to a Spare
		game[0] = new int[] {10, 0};
		game[1] = new int[] {4, 6};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + "\n");
		assertTrue(score == 64);
	}
	
	@Test
	public void testMultipleStrikes() {
		System.out.println("\n-- Testing Multiple Strikes --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {2, 2};
		
		// Set first and second frame to a Strike
		game[0] = new int[] {10, 0};
		game[1] = new int[] {10, 0};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + "\n");
		assertTrue(score == 68);
	}
	
	@Test
	public void testMultipleSpares() {
		System.out.println("\n-- Testing Multiple Spares --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {2, 2};
		
		// Set first and second frame to a Spare
		game[0] = new int[] {3, 7};
		game[1] = new int[] {2, 8};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + "\n");
		assertTrue(score == 56);
	}
	
	@Test
	public void testSpareAsTheLastFrame() {
		System.out.println("\n-- Testing Spare as the Last Frame --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {2, 2};
		
		// Set last frame to a Spare
		game[9] = new int[] {3, 7};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + ", bonus was: " + (score - 46) + "\n");
		// bonus can be 0-10, so we add that as the interval
		assertTrue(score >= 46 && score <= 56);
	}
	
	@Test
	public void testStrikeAsTheLastFrame() {
		System.out.println("\n-- Testing Strike as the Last Frame --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {2, 2};
		
		// Set last frame to a Strike
		game[9] = new int[] {10, 0};
		
		int score = instance.gameScore(game, null);
		/* prints for readability */
		System.out.print("score: " + score + ", bonus was: " + (score - 46) + "\n");
		// bonus can be 0-10, so we add that as the interval
		assertTrue(score >= 46 && score <= 56);
	}
	
	@Test
	public void testBonusIsAStrike() {
		System.out.println("\n-- Testing Bonus is a Strike --");
		main instance = new main();
		int[][] game = new int[10][2];
		
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++)
			game[i] = new int[] {2, 2};
		
		// Set last frame to a Spare
		game[9] = new int[] {5, 5};
		
		int score = instance.gameScore(game, new int[] {10, 0});
		/* prints for readability */
		System.out.print("score: " + score + ", bonus was: " + (score - 46) + "\n");
		assertTrue(score == 56);
	}
}
