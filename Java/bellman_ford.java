
import java.io.*;
import java.lang.*;
import java.util.*;


class bellman_ford {

	class g_edge {
		int src, dest, weight;
		g_edge() { src = dest = weight = 0; }
	};

	int V, E;
	g_edge g_edge[];

	bellman_ford(int v, int e)
	{
		V = v;
		E = e;
		g_edge = new g_edge[e];
		for (int i = 0; i < e; ++i)
			g_edge[i] = new g_edge();
	}

	
	void BellmanFord(bellman_ford graph, int src)
	{
		int V = graph.V, E = graph.E;
		int distance[] = new int[V];

		
		for (int i = 0; i < V; ++i)
			distance[i] = Integer.MAX_VALUE;
		distance[src] = 0;

	
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.g_edge[j].src;
				int v = graph.g_edge[j].dest;
				int weight = graph.g_edge[j].weight;
				if (distance[u] != Integer.MAX_VALUE
					&& distance[u] + weight < distance[v])
					distance[v] = distance[u] + weight;
			}
		}

		
		for (int j = 0; j < E; ++j) {
			int u = graph.g_edge[j].src;
			int v = graph.g_edge[j].dest;
			int weight = graph.g_edge[j].weight;
			if (distance[u] != Integer.MAX_VALUE
				&& distance[u] + weight < distance[v]) {
				System.out.println(
					"bellman_ford contains negative weight cycle");
				return;
			}
		}
		printArr(distance, V);
	}

	void printArr(int distance[], int V)
	{
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + distance[i]);
	}

	public static void main(String[] args)
	{
		int V = 5; 
		int E = 8; 

		bellman_ford graph = new bellman_ford(V, E);

		graph.g_edge[0].src = 0;
		graph.g_edge[0].dest = 1;
		graph.g_edge[0].weight = -3;

		graph.g_edge[1].src = 0;
		graph.g_edge[1].dest = 2;
		graph.g_edge[1].weight = 4;

		graph.g_edge[2].src = 1;
		graph.g_edge[2].dest = 2;
		graph.g_edge[2].weight = 3;

		graph.g_edge[3].src = 1;
		graph.g_edge[3].dest = 3;
		graph.g_edge[3].weight = 22;

		graph.g_edge[4].src = 1;
		graph.g_edge[4].dest = 4;
		graph.g_edge[4].weight = 2;

		graph.g_edge[5].src = 3;
		graph.g_edge[5].dest = 2;
		graph.g_edge[5].weight = 5;

		graph.g_edge[6].src = 3;
		graph.g_edge[6].dest = 1;
		graph.g_edge[6].weight = 1;

		graph.g_edge[7].src = 4;
		graph.g_edge[7].dest = 3;
		graph.g_edge[7].weight = -3;
		
		graph.BellmanFord(graph, 0);
	}
}
