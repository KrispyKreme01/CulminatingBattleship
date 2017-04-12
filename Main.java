import java.util.Random;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int[][] enemyBoard = new int[6][6];
		boolean[][] friendlyBoard = new boolean[6][6];
		friendlyBoardChooser(friendlyBoard);
		friendlyBoardMaker(friendlyBoard);
		enemyBoardMaker(enemyBoard);
	}

	public static void friendlyBoardChooser(boolean[][] friendlyBoard) //this chooses the coordinates for the user
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your five coordinates");
		for (int coordinateAmount = 1; coordinateAmount <= 5; coordinateAmount++) {
			System.out.println("X-value of coordinate number " + coordinateAmount + ":");
			int coordinateNumberX = sc.nextInt();
			System.out.println("Y-value of coordinate number " + coordinateAmount + ":");
			int coordinateNumberY = sc.nextInt();
			friendlyBoard[coordinateNumberX][coordinateNumberY] = true;

		}
	}

	public static void friendlyBoardMaker(boolean[][] friendlyBoard) //this shows the users board
	{
		System.out.println("\t0 \t1 \t2 \t3 \t4 \t5");
		for (int row1 = 0; row1 < 6; row1++) {
			System.out.print("\n" + (row1));
			for (int column1 = 0; column1 < 6; column1++) {
				if (friendlyBoard[row1][column1] != true)
					System.out.print("\t" + "~");

				else if (friendlyBoard[row1][column1])
					System.out.print("\t" + "X");
			}

		}
	}

	public static void enemyBoardMaker(int[][] enemyBoard) {
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			//sets up enemy battle ship spots
			
			int enemyCoordX = rand.nextInt(6);
			int enemyCoordY = rand.nextInt(6);
			if(enemyBoard[enemyCoordX][enemyCoordY] == 0)
			enemyBoard[enemyCoordX][enemyCoordY] = 1;
			else
			i--;

		}
		for (int row1 = 0; row1 < 6; row1++) {
			System.out.print("\n" + (row1));
			for (int column1 = 0; column1 < 6; column1++) {
				if (enemyBoard[row1][column1] == 0)
					System.out.print("\t" + "~");

				else if (enemyBoard[row1][column1] == 1)
					System.out.print("\t" + "~");

				else if (enemyBoard[row1][column1] == 2)
					System.out.print("\t" + "X");
			}


		}
	}
}



