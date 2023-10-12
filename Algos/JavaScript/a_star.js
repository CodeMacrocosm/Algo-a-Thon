let cols = 5;
let rows = 5;
let grid = new Array(cols);
let openSet = [];
let closedSet = [];
let start;
let end;
let path = [];

function heuristic(position0, position1) {
	let d1 = Math.abs(position1.x - position0.x);
	let d2 = Math.abs(position1.y - position0.y);

	return d1 + d2;
}

function GridPoint(x, y) {
	this.x = x;
	this.y = y;
	this.f = 0;
	this.g = 0;
	this.h = 0;
	this.neighbors = [];
	this.parent = undefined;
	this.updateNeighbors = function (grid) {
		let i = this.x;
		let j = this.y;
		if (i < cols - 1) {
			this.neighbors.push(grid[i + 1][j]);
		}
		if (i > 0) {
			this.neighbors.push(grid[i - 1][j]);
		}
		if (j < rows - 1) {
			this.neighbors.push(grid[i][j + 1]);
		}
		if (j > 0) {
			this.neighbors.push(grid[i][j - 1]);
		}
	};
}

//initializing the grid
function init() {
	for (let i = 0; i < cols; i++) {
		grid[i] = new Array(rows);
	}

	for (let i = 0; i < cols; i++) {
		for (let j = 0; j < rows; j++) {
			grid[i][j] = new GridPoint(i, j);
		}
	}

	for (let i = 0; i < cols; i++) {
		for (let j = 0; j < rows; j++) {
			grid[i][j].updateNeighbors(grid);
		}
	}

	start = grid[0][0];
	end = grid[cols - 1][rows - 1];

	openSet.push(start);

	console.log(grid);
}

//A star search implementation
function A_star() {
	init();
	while (openSet.length > 0) {
		let lowestIndex = 0;
		for (let i = 0; i < openSet.length; i++) {
			if (openSet[i].f < openSet[lowestIndex].f) {
				lowestIndex = i;
			}
		}
		let current = openSet[lowestIndex];

		if (current === end) {
			let temp = current;
			path.push(temp);
			while (temp.parent) {
				path.push(temp.parent);
				temp = temp.parent;
			}
			console.log("DONE!");
			return path.reverse();
		}

		openSet.splice(lowestIndex, 1);

		closedSet.push(current);

		let neighbors = current.neighbors;

		for (let i = 0; i < neighbors.length; i++) {
			let neighbor = neighbors[i];

			if (!closedSet.includes(neighbor)) {
				let possibleG = current.g + 1;

				if (!openSet.includes(neighbor)) {
					openSet.push(neighbor);
				} else if (possibleG >= neighbor.g) {
					continue;
				}

				neighbor.g = possibleG;
				neighbor.h = heuristic(neighbor, end);
				neighbor.f = neighbor.g + neighbor.h;
				neighbor.parent = current;
			}
		}
	}

	return [];
}

console.log(A_star());
