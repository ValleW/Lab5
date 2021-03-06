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

			game[i] = new int[] {randOne, randTwo};
		}
		
		return game;
	}

	public int gameScore(int[][] game, int[] forcedBonus) {
		// Create 2 frames and change them if forcedBonus isn't null (used in test cases)
		int[] bonus1 = frame();
		int[] bonus2 = frame();
		if(forcedBonus != null) {
			bonus1 = forcedBonus;
			bonus2 = forcedBonus;
		}
		
		int score = 0;
		for(int i = 0; i < 10; i++) {
			if(isStrike(game[i])) { // Check for first strike
				score += 10;
				// If there's a frame after i, check for another strike and increase score according to user stories
				if(i+1 < 10) {
					// Check for secondary strike
					if(isStrike(game[i+1])) {
						score += 10;
						// check if there's a frame after this strike
						if(i+2 < 10) {
							// and add the first throw in that frame
							score += game[i+2][0];
						} else {
							if(isStrike(bonus1))
								score += 10;
						}
					} else {
						score += frameScore(game[i+1]);
					}
				} else {					
					if(isStrike(bonus1)) {
						score+=10;
						if(isStrike(bonus2)) {
							score+=10;
						} else {
							score += bonus1[0] + bonus2[1]; 
						}
					} else {
						score += bonus1[0] + bonus2[1]; 
					}
				}
			} else if(isSpare(game[i])) {
				// Add 10 and if there's a frame after i, add the first throw from that frame
				score += 10;
				if(i+1 < 10) {
					score += game[i+1][0];
				} else {
					score += bonus1[0]; 
				}
			} else { // if i is anything else
				score += frameScore(game[i]);
			}
		}
		return score;
	}

	public boolean isStrike(int[] frame) {
		return(frame[0] == 10 && frame[1] == 0);
	}

	public boolean isSpare(int[] frame) {
		return(frame[0] + frame[1] == 10);
	}
}
