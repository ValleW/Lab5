import java.util.Random;

public class main {
	
	public int[] frame(){
		System.out.println("Frame Function");
		
		int frame[] = new int[2];
		Random rand = new Random();
		
		int i = rand.nextInt(10);
		int k = rand.nextInt(11-i);
		
		frame[0] = i;
		frame[1] = k;
		
		return frame;
	}
}
