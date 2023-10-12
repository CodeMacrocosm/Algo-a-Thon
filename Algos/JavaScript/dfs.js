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
	dfs(goal, v = this.vertices[0], discovered = []) {
		let adj = this.adjacent;

		discovered[v] = true;

		for (let i = 0; i < adj[v].length; i++) {
			let w = adj[v][i];

			if (!discovered[w]) {
				this.dfs(goal, w, discovered);
			}
		}

		return discovered[goal] || false;
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

console.log(g.dfs("D"));
