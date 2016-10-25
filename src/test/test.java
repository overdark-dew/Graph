package test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;

		for (int i = 0; i < n; ++i) {
			 System.out.println();
			for (int j = 0; j < n; ++j) {
				System.out.println();
				for (int k = 0; k < n; ++k) {

					if (k > j) {
						System.out.print(i + " ");
					} else {
						System.out.print(0 + " ");
					}
				}
			}
		}

	}

}
