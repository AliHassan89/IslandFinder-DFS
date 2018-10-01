/*
Find the number of islands
Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below
matrix contains 5 islands

Example:

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}
Output : 5
 */

package main.java;

public class IslandFinder {

    public static void main(String[] args) {
        boolean M[][] = new boolean[][] {
                {true, true, false, false, false},
                {false, true, false, false, true},
                {true, false, false, true, true},
                {false, false, false, false, false},
                {true, false, true, false, true}
        };

        System.out.println(numberOfIslands(M));
    }

    private static boolean[][] visited;
    private static int[] rowNbr = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
    private static int[] colNbr = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

    public static int numberOfIslands(boolean[][] map) {
        int row = map.length;
        int col = map[0].length;
        visited = new boolean[row][col];
        int count = 0;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (map[i][j] && !visited[i][j]){
                    visited[i][j] = true;
                    numberOfIslandsUtil(map, i, j, row, col);
                    ++count;
                }
            }
        }

        return count;
    }

    private static void numberOfIslandsUtil(boolean[][] map, int i, int j, int row, int col) {
        visited[i][j] = true;

        for (int k=0; k<8; k++){
            if (isSafe(map, i + rowNbr[k], j+colNbr[k], row, col)) {
                numberOfIslandsUtil(map, i + rowNbr[k], j+colNbr[k], row, col);
            }
        }
    }

    private static boolean isSafe(boolean[][] map, int nextRow, int nextCol, int row, int col) {
        return nextRow < row && nextRow >= 0 && nextCol < col && nextCol >= 0 && !visited[nextRow][nextCol]
                && map[nextRow][nextCol];
    }
}
