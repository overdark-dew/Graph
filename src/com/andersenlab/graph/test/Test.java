package com.andersenlab.graph.test;

import com.andersenlab.graph.Graph;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph test = new Graph(3);
		Graph expect = new Graph(3);
		
		test.graph[0][1] = 1;
		test.graph[0][2] = 2;
		test.graph[1][2] = 5;
		test.graph[1][0] = 1;
		test.graph[2][0] = 2;
		test.graph[2][1] = 5;
		
		expect.graph[0][1] = 1;
		expect.graph[0][2] = 2;
		expect.graph[1][2] = 3;
		expect.graph[1][0] = 1;
		expect.graph[2][0] = 2;
		expect.graph[2][1] = 3;

		
		System.out.print("Начальный граф :");
		test.printGraph(test.graph);
		test.findShortWay(test.graph);
		
		System.out.print("Оптимизированный граф :");
		test.printGraph(test.graph);
		
		System.out.print("Ожидаемый оптимизированный граф :");
		test.printGraph(expect.graph);
		
		System.out.print("Точки оптимизации :");
		test.printGraph(test.march);
		
		System.out.print("Результат теста :");
		
		for (int i = 0; i < 3; ++i) {
		 System.out.println();
		for (int j = 0; j < 3; ++j) {

			if (test.graph[i][j] == expect.graph[i][j]) {
				 System.out.print(" Оk |");
				continue;
			} else {
				System.out.print("Error!!!");
				break;
			} 
			
		}
		
		
	}

	}

}
