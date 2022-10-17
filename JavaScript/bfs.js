class Graph {
	constructor() {
		this.vertices = [];
		this.adjacent = {};
		this.edges = 0;
	}

	addVertex(v) {
		this.vertices.push(v);
		this.adjacent[v] = [];
	}

	addEdge(v, w) {
		this.adjacent[v].push(w);
		this.adjacent[w].push(v);
		this.edges++;
	}
	bfs(goal, root = this.vertices[0]) {
		let adj = this.adjacent;

		const queue = [];
		queue.push(root);

		while (queue.length) {
			let v = queue.shift();
			console.log(v);

			if (v === goal) {
				return true;
			}

			for (let i = 0; i < adj[v].length; i++) {
				queue.push(adj[v][i]);
			}
		}

		return false;
	}
}

const g = new Graph();

g.addVertex("A");
g.addVertex("B");
g.addVertex("C");
g.addVertex("D");

g.addEdge("A", "B");
g.addEdge("A", "C");
g.addEdge("A", "D");
g.addEdge("B", "C");
g.addEdge("B", "D");
g.addEdge("C", "D");

console.log(g.bfs("D"));
