import java.util.Scanner;

public class TestingClass {

	public static void main(String[] args) {
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
					System.out.println("set off first if");
			}
			 else if (Character.getNumericValue(chooseCoordinate.charAt(0)) > 5 || Character.getNumericValue(chooseCoordinate.charAt(2)) > 5 ){		
					System.out.println("\nTHAT INPUT WAS INVALID, PLEASE INPUT A PROPER VALUE");
					goodData = false;
					System.out.println("second if");
		 	}
			else {
					System.out.println("else");
					goodData = true;
			 		chooseX = Character.getNumericValue(chooseCoordinate.charAt(0));
			 		chooseY = Character.getNumericValue(chooseCoordinate.charAt(2));
			}
		
		

}
}
}