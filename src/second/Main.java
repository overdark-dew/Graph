package second;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(20);

		g.buildRandomGraph();
		g.printGraph(g.graph);
		g.findShortWay(g.graph);
		g.printGraph(g.graph);
		g.printGraph(g.march);
	}

}
