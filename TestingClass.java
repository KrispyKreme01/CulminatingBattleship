
public class TestingClass {

	public static void main(String[] args) {
		int[][] array = new int[5][5];
		array[1][0] = 1;
		array[2][2] = 1;
		array[1][4] = 1;
		array[3][3] = 1;
		array[4][2] = 1;
		boolean flag = false;
		for (int searchX = 0; searchX < 5; searchX++) {
			for (int searchY = 0; searchY < 5; searchY++){
				if (array[searchX][searchY] == 1) {
					System.out.println("THE ENEMY STILL HAS SHIPS, DONT STOP THE FIGHT");
					flag = true;
					searchX = 10;
					searchY = 10;
				}
			}
		}
		if (flag == false) {
			System.out.println("you have lost");
			System.exit(1);
		}
	}

}