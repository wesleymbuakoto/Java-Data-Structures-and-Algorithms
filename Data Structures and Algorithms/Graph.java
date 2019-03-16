package graph;

import ds.Queue;

public class Graph {
	public int n;	//number of vertice
	public int[][] A;	//the adjacency matrix
	private final int WHITE = 2;
	private final int GRAY = 3;
	private final int BLACK = 4;
	
	public Graph () {
		n = 0;
		A = null;
	}
	
	public Graph (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}
	
	/*
	 * Input: s denotes the index of the source node
	 * Output: the array dist, where dist[i] is the distance between the i-th node to s
	 */
	
	public int[] bfs (int s) {
		 int heads = 0;
	     int feet = 0;

	     int [][]queue = new int[n][2];
	     
	     boolean []vis = new boolean[n];
	     vis[s] = true;

	     queue[feet][0] = s;  
	     queue[feet++][1] = 0;

	     int []distance = new int[n];

	     distance[s] = 0;

	     while(heads != feet){

	          int inde = queue[heads][0];

	          for(int i1=0;i1<n;i1++){

	              if(!vis[i1] && A[inde][i1] == 1){

	                  vis[i1] = true;

	                  queue[feet][0] = i1;

	                  queue[feet][1] = queue[heads][1] + 1;

	                  distance[i1] = queue[feet][1];

	                  feet++;
	                }

	            }

	            heads++;

	       }

	        return distance;
	}
	
	public void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(i + ": " + array[i]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[][] A = 
			{{0, 1, 0, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 1, 0, 1, 1, 0},
			{0, 0, 1, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 1, 1, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 1, 0}};
		Graph g = new Graph(n, A);
		g.print_array(g.bfs(1));
	}

}
