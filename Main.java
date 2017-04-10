
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		boolean[][] enemyBoard = new boolean[9][9];
		boolean[][] friendlyBoard = new boolean[9][9];
		  friendlyBoardChooser(friendlyBoard);
	      friendlyBoardMaker(friendlyBoard);
	       }

	public static void friendlyBoardChooser(boolean[][] friendlyBoard) //this chooses the coordinates for the user
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your three coordinates");
		for (int coordinateAmount = 1; coordinateAmount <= 5; coordinateAmount++){
			System.out.println("X-value of coordinate number " + coordinateAmount + ":");
			int coordinateNumberX = sc.nextInt();
			System.out.println("Y-value of coordinate number " + coordinateAmount + ":");
			int coordinateNumberY = sc.nextInt();
			friendlyBoard[coordinateNumberX][coordinateNumberY] = true;
		}
	}
		public static void friendlyBoardMaker(boolean[][] friendlyBoard) //this shows the users board
	{
			System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8");
		for(int row1=0 ; row1 < 8 ; row1++ ){
            System.out.print("\n"+(row1)); 
            for(int column1=0 ; column1 < 9 ; column1++ ){
                if(friendlyBoard[row1][column1] != true)
                    System.out.print("\t"+"~");
                
                else if(friendlyBoard[row1][column1])
                    System.out.print("\t"+"X");
                }

    }
	}
	 /*public static void friendlyBoard(int[][] board){
	        System.out.println("\t1 \t2 \t3 \t4 \t5");
	        System.out.println();
	        
	        for(int row=0 ; row < 5 ; row++ ){
	            System.out.print((row+1)+""); 
	            for(int column=0 ; column < 5 ; column++ ){
	                if(friendlyBoard[row][column] != true)
	                    System.out.print("\t"+"~");
	                
	                else if(friendlyBoard[row][column])
	                    System.out.print("\t"+"X");
	                }

	    } */
	 }


