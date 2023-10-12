class Solution:
    def solveNQueens(self, N: int) -> list[list[str]]:
        board = [list("." * N) for _ in range(N)]
        listOfSolutions = []
        columnUnsafe = set()
        positiveDiagonalUnsafe = set()
        negativeDiagonalUnsafe = set()

        def backtrackingNQueensSolution(row: int):
            if (row == N):
                listOfSolutions.append(list(map(lambda x: "".join(x), board)))
            else:
                for column in range(len(board)):
                    if (column in columnUnsafe or (column + row) in positiveDiagonalUnsafe or (column - row) in negativeDiagonalUnsafe):
                        continue

                    columnUnsafe.add(column)
                    positiveDiagonalUnsafe.add(column + row)
                    negativeDiagonalUnsafe.add(column - row)
                    board[row][column] = "Q"

                    backtrackingNQueensSolution(row+1)

                    columnUnsafe.remove(column)
                    positiveDiagonalUnsafe.remove(column + row)
                    negativeDiagonalUnsafe.remove(column - row)
                    board[row][column] = "."

        backtrackingNQueensSolution(0)
        return listOfSolutions