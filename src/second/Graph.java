package second;

import java.util.Random;

public class Graph {

	private int block = 99;
	private int n;

	int[][] graph;// = new int[n][n]; // Начальный массив с расстояниями

	int[][] march;// = new int[n][n]; // Массив с последней точкой, через
					// которую был учлучшен путь

	Graph() {

		n = 10;
		graph = new int[n][n];
		march = new int[n][n];
	}

	Graph(int k) {

		n = k;
		graph = new int[n][n];
		march = new int[n][n];
	}

	int[][] buildRandomGraph() { // метод для генерации графа со случайными
									// расстояниями

		Random r = new Random();

		for (int i = 0; i < n; ++i) {
			// System.out.println();
			for (int j = 0; j < n; ++j) {

				if (j <= i) {
					// System.out.print("XХ ");
					continue;
				} else if (r.nextInt(2) > 0) {
					graph[i][j] = r.nextInt(50) + 1;
				} else {
					graph[i][j] = block;
				}
				graph[j][i] = graph[i][j];
				// System.out.print(graph[i][j] + " ");
			}
		}
		return graph;
	};

	int[][] buildUsersGraph() {
		return graph;
		// создать
		// int[][] g = {
		// { block, 0, 0, 0, 0 },
		// { 9, block, 0, 0, 0 },
		// { block, 4, block, 0, 0 },
		// { 7, block, 5, block, 0 },
		// { block, 15, 3, 2, block }
		// };
		// System.out.println(g);
	};

	void printGraph(int d[][]) {
		// Напечатать граф

		System.out.println();
		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {

				if (d[i][j] > 9) {
					// System.out.print("XХ ");
					// continue;
					System.out.print(d[i][j] + " | ");
				} else {
					System.out.print(" " + d[i][j] + " | ");
				}

			}

		}
	};

	int[][] findShortWay(int[][] graph) {

		for (int i = 0; i < n; ++i) {

			for (int j = 0; j < n; ++j) {

				for (int k = 0; k < n; ++k) {

					if (graph[j][k] > graph[j][i] + graph[i][k]) {

						graph[j][k] = graph[j][i] + graph[i][k];
						march[j][k] = i;
					}

				}
			}
		}
		return graph;
	};

}