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
}
