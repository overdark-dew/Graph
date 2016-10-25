package second;

import java.util.Random;

public class Graph {

	public static void main(String[] args) {

		int block = 99;
		int n = 10;

		int[][] g = new int[n][n]; // Начальный массив с расстояниями
		int[][] d = g; // Массив для экспериментов
		int[][] m = new int[n][n]; // Массив с последней точкой,
									// через которую был учлучшен путь

		// int[][] g = { { block, 0, 0, 0, 0 },
		// { 9, block, 0, 0, 0 },
		// { block, 4, block, 0, 0 },
		// { 7, block, 5, block, 0 },
		// { block, 15, 3, 2, block } };

		// System.out.println(g);
		Random r = new Random();

		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {

				if (j <= i) {
					System.out.print("XХ   ");
					continue;
				} else if (r.nextInt(2) > 0) {
					g[i][j] = r.nextInt(50) + 1;
				} else {
					g[i][j] = block;
				}
				g[j][i] = g[i][j];
				System.out.print(g[i][j] + "   ");
			}
		}

		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {
				System.out.println();
				for (int k = 0; k < n; ++k) {

					if (k <= j) {
						System.out.print("XХ   ");
						continue;
					} else if (d[j][k] > d[j][i] + d[i][k]) {
						d[j][k] = d[j][i] + d[i][k];
						m[j][k] = i;
					}
					if (g[j][k] < 10) {
						System.out.print(" " + g[j][k] + "   ");
					} else {
						System.out.print(g[j][k] + "   ");
					}
				}
			}
		}
		System.out.println();
		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {

				if (j <= i) {
					System.out.print("XХ   ");
					continue;
				}
				System.out.print(" " + m[i][j] + "   ");

			}

		}
	}
}