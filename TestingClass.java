import java.util.Random;
public class TestingClass {

	public static void main(String[] args) {
		Random rand = new Random();
		 int[][] coordCheck = new int[6][6];
		int randCoordY = 0;
		
		int randCoordX = 0;
		for(int q = 0; q < 1; q++) {
			randCoordX = rand.nextInt(6);
			randCoordY = rand.nextInt(6);
				if (coordCheck[randCoordX][randCoordY] == 0)
					coordCheck[randCoordX][randCoordY] = 1;
				else 
					q--;
		}
		System.out.println(randCoordX);
	}

}
