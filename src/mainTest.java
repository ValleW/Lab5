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
		for(int i = 0; i < 10; i++) {
			game[i][0] = 1;
			game[i][1] = 2;
		}
		int score = instance.gameScore(game);
		/* prints for readability */
		System.out.print("score: " + score);
		assertTrue(score == 30);
	}
	
	@Test
	public void testStrike() {
		System.out.println("\n-- Testing Strike --");
		main instance = new main();
		int[][] game = new int[1][2];
		game[0][0] = 10;
		game[0][1] = 0;
		/* prints for readability */
		System.out.println("Testing: |10, 0|");
		assertTrue(instance.isStrike(game[0][0], game[0][1]));

		// Create the game to test
		int[][] game2 = new int[10][2];
		// Fill it with specific numbers so we can verify the score
		for(int i = 0; i < 10; i++) {
			game2[i][0] = 1;
			game2[i][1] = 2;
		}
		// Set first to a strike
		game2[0][0] = 10;
		game2[0][1] = 0;
		int score = instance.gameScore(game2);
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
		for(int i = 0; i < 10; i++) {
			game[i][0] = 4;
			game[i][1] = 3;
		}
		// Set first to a Spare
		game[0][0] = 1;
		game[0][1] = 9;
		int score = instance.gameScore(game);
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
		for(int i = 0; i < 10; i++) {
			game[i][0] = 2;
			game[i][1] = 2;
		}
		// Set first to a Strike
		game[0][0] = 10;
		game[0][1] = 0;
		// Set second to a Spare
		game[1][0] = 4;
		game[1][1] = 6;
		int score = instance.gameScore(game);
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
		for(int i = 0; i < 10; i++) {
			game[i][0] = 2;
			game[i][1] = 2;
		}
		// Set first to a Strike
		game[0][0] = 10;
		game[0][1] = 0;
		// Set second to a Strike
		game[1][0] = 10;
		game[1][1] = 0;
		int score = instance.gameScore(game);
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
		for(int i = 0; i < 10; i++) {
			game[i][0] = 2;
			game[i][1] = 2;
		}
		// Set first to a Strike
		game[0][0] = 3;
		game[0][1] = 7;
		// Set second to a Strike
		game[1][0] = 2;
		game[1][1] = 8;
		int score = instance.gameScore(game);
		/* prints for readability */
		System.out.print("score: " + score + "\n");
		assertTrue(score == 56);
	}
}
