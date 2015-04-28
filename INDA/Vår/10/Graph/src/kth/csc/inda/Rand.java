package kth.csc.inda;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.function.Consumer;


public class Rand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("dawd");
		
		System.out.println(Analyse(1000, true, false));
		
		System.out.println(Analyse(1000, false, false));
		System.out.println(Analyse(2000, false, false));
		System.out.println(Analyse(3000, false, false));
		System.out.println(Analyse(4000, false, false));
		System.out.println(Analyse(5000, false, false));
		
		System.out.println("Break");
		
		System.out.println(Analyse(1000, false, true));
		
		System.out.println(Analyse(1000, false, true));
		System.out.println(Analyse(2000, false, true));
		System.out.println(Analyse(3000, false, true));
		System.out.println(Analyse(4000, false, true));
		System.out.println(Analyse(5000, false, true));

		
		
	}
	
	/**
	 * Analyses a graph.
	 * @param n The size
	 * @param showInfo Show detailed information about the graph.
	 * @param implementation See RandomGraph for comments.
	 * @return Time it took to execute
	 */
	public static long Analyse(int n, boolean showInfo, boolean implementation)
	{
		Stopwatch sw = new Stopwatch();
		Graph rand = RandGraph(1000, implementation);
		
		sw.start();
		int[] returnargs = maxComponents(rand);
		sw.stop();
		
		if(showInfo)
		{
			System.out.println("The graph consists of " + returnargs[2] + " components.");
			System.out.println("The longest one is located at " + returnargs[1] + " with the size of " + returnargs[0] + " items.");
		}
		
		return sw.nanoseconds();
		
	}
	
	/**
	 * random Generates a "random" graph with random edges (in total, n vertices and n edges.)
	 * @param n
	 * @param typeOfImplementation 0=HashGraph, 1=MatrixGraph
	 * @return
	 */
	public static Graph RandGraph(int n, boolean typeOfImplementation)
	{
		Random rn = new Random();
		
		Graph gr;
		
		if(typeOfImplementation)
			gr = new MatrixGraph(n);
		else
			gr = new HashGraph(n);
		
		int pointer = 0; // at the start
		boolean consumed = false;
		
		for(int i = 0 ; (i < n) && (gr.numEdges() < n); i++)
		{
			for(int j = 0; j < (rn.nextInt(n) % 10) && (gr.numEdges() < n); j++)
			{
				gr.add(i, rn.nextInt(100));
			}
		}
		
		if (gr.numEdges() < n)
		{
			while( n-gr.numEdges() > 0) {
				gr.add(n-1, rn.nextInt(10));
	
			}
		}
		
		return gr;
		
	}
	
	public static int temp = 0;
	/**
	 * Uses DFS to find a) the number of components b) where it is located and c) the size of the greatest component.
	 * @param g
	 * @return
	 */
	public static int[] maxComponents(Graph g) {
		
		int maxNum = 0;
		int pos = 0;
		int components = 0;
		//int temp = 0;
		//final int[] t = new int[g.numVertices()];
		
		VertexAction printVertex = new VertexAction() {
			@Override
			public void act(Graph g, int v) {
				//System.out.print(v + " ");
				//t[v] += 1;
				temp++;
				
			}
		};
		int n = g.numVertices();
		boolean[] visited = new boolean[n];
		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				dfs(g, v, visited, printVertex);
				
				// now we start on a new component
				if(temp >= maxNum)
				{
					maxNum = temp; // store the number of items in the component
					pos = v; // the position in the array
					
					temp = 0; // this is crucial
				}
				
				components++;
				//System.out.println();
			}
		}
		
		return new int[] {maxNum, pos, components};
	}

	/**
	 * Traverses the nodes of g that have not yet been visited. The nodes are
	 * visited in depth-first order starting at v. The act() method in the
	 * VertexAction object is called once for each node.
	 * 
	 * @param g
	 *            an undirected graph
	 * @param v
	 *            start vertex
	 * @param visited
	 *            visited[i] is true if node i has been visited
	 */
	private static void dfs(Graph g, int v, boolean[] visited,
			VertexAction action) {
		if (visited[v])
			return;
		visited[v] = true;
		action.act(g, v);
		for (VertexIterator it = g.neighbors(v); it.hasNext();)
			dfs(g, it.next(), visited, action);
	}

}
