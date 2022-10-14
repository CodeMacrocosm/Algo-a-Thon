import java.util.*;

class BFS {
    
    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];

    BFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int a, int b) {
        adj[a].add(b);
    }

    void BFS1(int n) {
        LinkedList<Integer> queue = new LinkedList();
        visited[n] = true;
        queue.add(n);
        while (queue.size() != 0) {
            n = queue.poll();
            System.out.print(n + " ");
            Iterator<Integer> i = adj[n].listIterator();
            while (i.hasNext()) {
                int s = i.next();
                if (!visited[s]) {
                    visited[s] = true;
                    queue.add(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS(5);
        b.addEdge(0,1);
        b.addEdge(0,2);
        b.addEdge(0,3);
        b.addEdge(1,2);
        b.addEdge(1,4);
        b.addEdge(2,4);
        b.addEdge(2,3);
        b.addEdge(3,2);
        b.addEdge(3,4);
        b.BFS1(0);
    }
}