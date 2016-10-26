package com.andersenlab.graph;

//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Graph {

	private int block = 99;
	private int n;

	public int[][] graph;// = new int[n][n]; // Начальный массив с расстояниями

	public int[][] march;// = new int[n][n]; // Массив с последней точкой, через
	// которую был учлучшен путь

	public Graph() {

		n = 10;
		graph = new int[n][n];
		march = new int[n][n];
		createNullMarch();

	}

	public Graph(int k) {

		n = k;
		graph = new int[n][n];
		march = new int[n][n];
		createNullMarch();
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

	int[][] createNullMarch() {

		for (int i = 0; i < n; ++i) {
			// System.out.println();
			for (int j = 0; j < n; ++j) {
				march[i][j] = -1;
			}

		}
		return march;
	}

	int[][] buildUsersGraph(int[][] graph) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // создаём объект класса Scanner

		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {

				if (i == j) {
					continue;
				} else {
					System.out.print("Введите расстояние из точки (" + i + ") в точку (" + j + "): ");
					if (sc.hasNextInt()) {

						graph[i][j] = sc.nextInt();

					} else {
						System.out.println("Вы ввели не целое число");
					}

				}
			}
		}

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

	public void printGraph(int d[][]) {
		// Напечатать граф

		// System.out.println();
		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {

				if (d[i][j] > 9 || d[i][j] < 0) {
					// System.out.print("XХ ");
					// continue;
					System.out.print(d[i][j] + " | ");
				} else {
					System.out.print(" " + d[i][j] + " | ");
				}

			}

		}
		System.out.println();
	};

	public int[][] findShortWay(int[][] graph) {

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