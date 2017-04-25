
public class TestingClass {

	public static void main(String[] args) {
		int[][] array = new int[5][5];
		array[1][0] = 1;
		//array[2][2] = 1;
		//array[1][4] = 1;
		//array[3][3] = 1;
		//array[4][2] = 1;
			for (int i = 0; i < 5; i++) {
				for (int u = 0; u < 5; u++) {
					if (array[i][u] == 1) {
						System.out.println(true);
					}
					else {
						System.exit(1);
					}
				}
			}
	}

}
