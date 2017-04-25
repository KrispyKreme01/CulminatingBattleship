import java.util.Scanner;

public class TestingClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter your five coordinates");
		for (int coordinateAmount = 1; coordinateAmount <= 5; coordinateAmount++) {
				System.out.println("X-value of coordinate number " + coordinateAmount + " (FROM 0-5):");
				int coordinateNumberX = sc.nextInt();
				System.out.println("Y-value of coordinate number " + coordinateAmount + " (FROM 0-5):");
				int coordinateNumberY = sc.nextInt();
				if (coordinateNumberY > 5 || coordinateNumberX > 5) {
					System.out.println("\nYOU INPUTTED AN INVALID VALUE, PLEASE INPURT A VALUE BETWEEN 0 AND 5");
					coordinateAmount--;
				
				}
	}

}
}