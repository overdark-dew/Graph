package com.andersenlab.graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph random = new Graph(20);
		Graph manual = new Graph(4);
		
		random.buildRandomGraph();
		random.printGraph(random.graph);
		random.findShortWay(random.graph);
		random.printGraph(random.graph);
		random.printGraph(random.march);
		
		manual.buildUsersGraph(manual.graph);
		manual.printGraph(manual.graph);
		manual.findShortWay(manual.graph);
		manual.printGraph(manual.graph);
	}

}
