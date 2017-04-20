import java.util.Random;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int[][] enemyBoard = new int[6][6];
		int[][] friendlyBoard = new int[6][6];
		int[][] coordCheck = new int[6][6];
	System.out.println("WELCOME TO VIOLENT SEA DISPUTES \n THIS IS YOUR BOARD");
	//PRINTS BOARD FOR USER FIRST TIME
	boardDisplay(friendlyBoard);
		friendlyBoardChooser(friendlyBoard);
		friendlyBoardMaker(friendlyBoard);
		enemyBoardMaker(enemyBoard);
		friendlyShooter(enemyBoard);
		enemyShooter(friendlyBoard, coordCheck);
		
	}
	public static void boardDisplay(int friendlyBoard[][]) {
		System.out.println("\t0 \t1 \t2 \t3 \t4 \t5");
		for (int row1 = 0; row1 < 6; row1++) {
			System.out.print("\n" + (row1));
			for (int column1 = 0; column1 < 6; column1++) {
				if (friendlyBoard[row1][column1] == 0)
					System.out.print("\t" + "~");
			}
		}
	}
	public static void friendlyBoardChooser(int[][] friendlyBoard) //this chooses the coordinates for the user
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter your five coordinates");
		for (int coordinateAmount = 1; coordinateAmount <= 5; coordinateAmount++) {
				System.out.println("X-value of coordinate number " + coordinateAmount + " (FROM 0-5):");
				int coordinateNumberX = sc.nextInt();
				System.out.println("Y-value of coordinate number " + coordinateAmount + " (FROM 0-5):");
				int coordinateNumberY = sc.nextInt();
					if(friendlyBoard[coordinateNumberX][coordinateNumberY] == 0){
						friendlyBoard[coordinateNumberX][coordinateNumberY] = 1;
					}
					else {
						System.out.println("YOU HAVE ALREADY SELECTED THIS COORDINATE, PLEASE CHOOSE A DIFFERENT ONE.");
						coordinateAmount--;
						
					}

		}
	}

	public static void friendlyBoardMaker(int[][] friendlyBoard) //this shows the users board
	{
		System.out.println("THIS IS YOUR BOARD");
		System.out.println("\t0 \t1 \t2 \t3 \t4 \t5");
		for (int row1 = 0; row1 < 6; row1++) {
			System.out.print("\n" + (row1));
			for (int column1 = 0; column1 < 6; column1++) {
				if (friendlyBoard[row1][column1] == 0)
					System.out.print("\t" + "~");
				else if (friendlyBoard[row1][column1] == 1)
					System.out.print("\t" + "B");
				else if (friendlyBoard[row1][column1] == 2)
					System.out.println("\t" + "X");
				else if (friendlyBoard[row1][column1] == -1)
					System.out.println("\t" + "-");
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
		System.out.println("\nTHIS IS WHAT YOUR ENEMIES BOARD LOOKS LIKE");
		System.out.println("\n\n\t0 \t1 \t2 \t3 \t4 \t5");
		for (int row1 = 0; row1 < 6; row1++) {
			System.out.print("\n" + (row1));
			for (int column1 = 0; column1 < 6; column1++) {
				if (enemyBoard[row1][column1] == 0)
					System.out.print("\t" + "~");

				else if (enemyBoard[row1][column1] == 1)
					System.out.print("\t" + "~");

				else if (enemyBoard[row1][column1] == 2)
					System.out.print("\t" + "X");
				
				else if (enemyBoard[row1][column1] == -1)
					System.out.print("\t" + "-");
			}


		}
	}
	public static void friendlyShooter(int[][] enemyBoard){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nYOU MAY NOW SELECT TWO COORDINATES TO SHOOT FOR EXAMPLE : x,y = 2,2. (SEPERATE ONLY BY COMMA, NO SPACES)");
		String chooseCoordinate = sc.nextLine();
		int chooseX = Character.getNumericValue(chooseCoordinate.charAt(0));
		int chooseY = Character.getNumericValue(chooseCoordinate.charAt(2));
			if (enemyBoard[chooseX][chooseY] == 0) {
				enemyBoard[chooseX][chooseY] = -1;
				System.out.println("\nYOU MISSED!");
			}
			else if (enemyBoard[chooseX][chooseY] == 1 ) {
				enemyBoard[chooseX][chooseY] = 2;
				System.out.println("\nYOU HIT A SHIP");
			}
		
	}
	public static void enemyShooter (int[][] friendlyBoard, int[][] coordCheck) {
		Random rand = new Random();
		 
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
		if(friendlyBoard[randCoordX][randCoordY] == 1) {
			friendlyBoard[randCoordX][randCoordY] = 2;
			System.out.println("\nYOUR SHIP HAS BEEN HIT");
		}
		else if(friendlyBoard[randCoordX][randCoordY] == 0) {
			friendlyBoard[randCoordX][randCoordY] = -1;
			System.out.println("\nTHE ENEMY HAS MISSED, ITS YOUR TURN");
		}
		
		
	}
}



