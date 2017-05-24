
import java.util.Random;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int[][] enemyBoard = new int[6][6];
		int[][] friendlyBoard = new int[6][6];
		int[][] coordCheck = new int[6][6];
	
	System.out.println("WELCOME TO VIOLENT SEA DISPUTES");
	System.out.println("HERE ARE THE RULES\n___________\nTHE OBJECTIVE OF THE GAME IS TO FIND AND DESTROY OTHER PEOPLES SHIPS"
			+ "\nTO DO THIS, YOU WILL CHOOSE COORDINATES ON THE ENEMIES BOARD\nTO SHOOT.\n_________\nUNSHOT COORDINATES"
			+ "WILL BE REPRESENTED AS '~'.\n_________\nALL COORDINATES THAT HAVE BEEN SHOT BUT DID NOT CONTAIN SHIPS WILL BE REPRESENTED AS '-'.\n_________\n"
			+ "ALL COORDINATES THAT WERE SHOT THAT DID CONTAIN SHIPS WILL BE REPRESENTED AS 'X'.\n_________\nWHEN ALL SHIPS ON ONE SIDE HAVE BEEN"
			+ "SHOT, THE OPPOSING PLAYER WILL WIN.\n_________\n");
	System.out.println("THIS IS YOUR BOARD\n\n");
	//PRINTS BOARD FOR USER FIRST TIME
		boardDisplay(friendlyBoard);
		friendlyBoardChooser(friendlyBoard);
		friendlyBoardMaker(friendlyBoard);
		enemyBoardMaker(enemyBoard);
		friendlyShooter(enemyBoard, friendlyBoard, coordCheck);
		enemyShooter(friendlyBoard, coordCheck, enemyBoard);
		
	}
	public static void boardDisplay(int friendlyBoard[][]) {
		System.out.println("THIS IS WHAT YOUR BOARD LOOKS LIKE!");
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
		boolean f1 = false;
		boolean f2 = false;
		int coordinateNumberX = 0;
		int coordinateNumberY = 0;
		System.out.println("\nPlease enter your five coordinates");
		for (int coordinateAmount = 0; coordinateAmount < 5; coordinateAmount++) {
			while (!f1){	
			System.out.println("Please enter your X and Y coordinate number " + coordinateAmount + " (FROM 0-5) for example 2,2:");
				String input = sc.nextLine();
				if (input.length() < 3){
					System.out.println("INVALID INPUT, PLEASE TRY AGAIN");
				}	
				else if ((Character.getNumericValue(input.charAt(2)) > 5) || (Character.getNumericValue(input.charAt(2)) > 5 )){
					System.out.println("INVALID INPUT, PLEASE TRY AGAIN");
				}
				else {
					 coordinateNumberX = Character.getNumericValue(input.charAt(0));
					 coordinateNumberY = Character.getNumericValue(input.charAt(2));
					if (coordinateNumberX < 6 && coordinateNumberX > -1 && coordinateNumberY < 6 && coordinateNumberY > -1) {
					 	if(friendlyBoard[coordinateNumberX][coordinateNumberY] == 0){
					 			friendlyBoard[coordinateNumberX][coordinateNumberY] = 1;
								f1 = true;
						}
						else {
								System.out.println("YOU HAVE ALREADY SELECTED THIS COORDINATE, PLEASE CHOOSE A DIFFERENT ONE.");
								coordinateAmount--;
						}
					}
					else {
						System.out.println("YOU HAVE INPUTTED AN INVALID VALUE, PLEASE DO NOT USE SPACES OR INCLUDE CHARACTERS GREATER THAN THE COORDINATES");
						coordinateAmount--;
					}
				}
			}
			f1 = false;
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
					System.out.print("\t" + "X");
				else if (friendlyBoard[row1][column1] == -1)
					System.out.print("\t" + "-");
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
		enemyBoardDisplay(enemyBoard);
	}
	public static void enemyBoardDisplay(int[][] enemyBoard) {
		
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
	public static void friendlyShooter(int[][] enemyBoard, int[][] friendlyBoard, int[][] coordCheck){
		Scanner sc = new Scanner(System.in);
		int chooseX = 0;
		int chooseY = 0;
		boolean fWin = false;
		System.out.println("\nYOU MAY NOW SELECT TWO COORDINATES TO SHOOT FOR EXAMPLE : x,y = 2,2. (SEPERATE ONLY BY COMMA, NO SPACES)");
	//this loop is to make sure that the user inputs a value that wont cause an error
		boolean goodData = false;
		while (!goodData) {
			String chooseCoordinate = sc.nextLine();
			 
			 if (chooseCoordinate.length() < 3) {
					System.out.println("\nTHAT INPUT WAS INVALID, PLEASE INPUT A PROPER VALUE");
					goodData = false;	
			}
			 else if (Character.getNumericValue(chooseCoordinate.charAt(0)) > 5 || Character.getNumericValue(chooseCoordinate.charAt(2)) > 5 || Character.getNumericValue(chooseCoordinate.charAt(0)) <= -1 || Character.getNumericValue(chooseCoordinate.charAt(2)) <= -1 ){		
					System.out.println("\nTHAT INPUT WAS INVALID, PLEASE INPUT A PROPER VALUE");
					goodData = false;
		 	}
				else {
			 		chooseX = Character.getNumericValue(chooseCoordinate.charAt(0));
			 		chooseY = Character.getNumericValue(chooseCoordinate.charAt(2));
			 		goodData = true;
			}
		}
		if (enemyBoard[chooseX][chooseY] == 0) {
			enemyBoard[chooseX][chooseY] = -1;
			System.out.println("\nYOU MISSED!");	
		}
		else if (enemyBoard[chooseX][chooseY] == 1 ) {
			enemyBoard[chooseX][chooseY] = 2;
			System.out.println("\nYOU HIT A SHIP");
		}
			//checks to see if youve won or not 
		for (int searchX = 0; searchX < 6; searchX++) {
			for (int searchY = 0; searchY < 6; searchY++){
				if (enemyBoard[searchX][searchY] == 1) {
					 fWin = true;
					 searchX = 10;
					 searchY = 10;
				}
				else if (fWin == false && searchX == 5) {
					System.out.println("YOU HAVE WON! CONGRATULATIONS!");
					System.exit(1);
				}
			}
		}
		
		enemyBoardDisplay(enemyBoard);
		enemyShooter (friendlyBoard, coordCheck, enemyBoard);
		
	}
	public static void enemyShooter (int[][] friendlyBoard, int[][] coordCheck, int[][] enemyBoard) {
		Random rand = new Random();
		 int randCoordY = 0;
		 int counter = 0;
		 boolean eWin = false;
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
			
			
			for (int searchX = 0; searchX < 6; searchX++) {
				for (int searchY = 0; searchY < 6; searchY++){
					if (friendlyBoard[searchX][searchY] == 1) {
						eWin = true;
						searchX = 10;
						searchY = 10;
					}
					else if (eWin == false && searchX == 5) {
						System.out.println("YOU HAVE LOST! \nExiting...");
						System.exit(1);
				}
			}
			
			}
			friendlyBoardMaker(friendlyBoard);
			friendlyShooter(enemyBoard, friendlyBoard, coordCheck);
		
	}
}

