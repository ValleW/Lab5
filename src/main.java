import java.util.Random;

public class main {

	public int[] frame(){
		int frame[] = new int[2];
		Random rand = new Random();
		
		int i = rand.nextInt(10);
		int k = rand.nextInt(11-i);
		
		frame[0] = i;
		frame[1] = k;
		
		return frame;
	}
	
	public int frameScore(int[] frame){		
		int frameScore = frame[0] + frame[1];

		return frameScore;
	}
	
	public int[][] game(){
		int[][] game = new int[10][2];
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++){
			int randOne = rand.nextInt(10);
			int randTwo = rand.nextInt(11-randOne);
			
			game[i][0] = randOne;
			game[i][1] = randTwo;
		}
		
		return game;
	}

	public int gameScore(int[][] game) {
		int score = 0;
		for(int i = 0; i < 10; i++)
			score += game[i][0] + game[i][1];
		return score;
	}

	public boolean isStrike(int[][] game) {
		return(game[0][0] == 10 && game[0][1] == 0);
	}
}
