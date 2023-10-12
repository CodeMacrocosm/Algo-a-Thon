class Graph {
	constructor() {
		this.vertices = [];
		this.adjacencyList = {};
	}
	addVertex(vertex) {
		this.vertices.push(vertex);
		this.adjacencyList[vertex] = {};
	}

	addEdge(vertex1, vertex2, weight) {
		this.adjacencyList[vertex1][vertex2] = weight;
	}

	changeWeight(vertex1, vertex2, weight) {
		this.adjacencyList[vertex1][vertex2] = weight;
	}
	dijkstra(source) {
		let distances = {},
			parents = {},
			visited = new Set();
		for (let i = 0; i < this.vertices.length; i++) {
			if (this.vertices[i] === source) {
				distances[source] = 0;
			} else {
				distances[this.vertices[i]] = Infinity;
			}
			parents[this.vertices[i]] = null;
		}

		let currVertex = this.vertexWithMinDistance(distances, visited);

		while (currVertex !== null) {
			let distance = distances[currVertex],
				neighbors = this.adjacencyList[currVertex];
			for (let neighbor in neighbors) {
				let newDistance = distance + neighbors[neighbor];
				if (distances[neighbor] > newDistance) {
					distances[neighbor] = newDistance;
					parents[neighbor] = currVertex;
				}
			}
			visited.add(currVertex);
			currVertex = this.vertexWithMinDistance(distances, visited);
		}

		console.log(parents);
		console.log(distances);
	}
	vertexWithMinDistance(distances, visited) {
		let minDistance = Infinity,
			minVertex = null;
		for (let vertex in distances) {
			let distance = distances[vertex];
			if (distance < minDistance && !visited.has(vertex)) {
				minDistance = distance;
				minVertex = vertex;
			}
		}
		return minVertex;
	}
}

let g = new Graph();

// add the vertices
g.addVertex("A");
g.addVertex("B");
g.addVertex("C");
g.addVertex("D");

// create the edges
g.addEdge("A", "B", 3);
g.addEdge("A", "C", 2);
g.addEdge("B", "D", 2);
g.addEdge("C", "D", 6);

// run dijkstra's algorithm, with A as the source vertex.
g.dijkstra("A");

// should log
// { A: null, B: 'A', C: 'A', D: 'B' }
// { A: 0, B: 3, C: 2, D: 5 }
