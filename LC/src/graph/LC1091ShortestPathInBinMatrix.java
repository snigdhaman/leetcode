package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1091ShortestPathInBinMatrix {

    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    Queue<int[]> bfsQueue = new LinkedList<>();
    public int shortestPathBinaryMatrix (int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        grid[0][0] = 1;
        bfsQueue.offer(new int[]{0, 0});
        return bfs(grid, 0, 0);
    }

    private int bfs (int[][] grid, int i, int j) {
        while (!bfsQueue.isEmpty()) {
            int[] node = bfsQueue.poll();
            int row = node[0];
            int col = node[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbor : getNeighbors(row, col, grid)) {
                bfsQueue.offer(neighbor);
                grid[neighbor[0]][neighbor[1]] = distance + 1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors (int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[] {newRow, newCol});
        }
        return neighbors;
    }


    public static void main (String[] args) {
        LC1091ShortestPathInBinMatrix lc1091ShortestPathInBinMatrix = new LC1091ShortestPathInBinMatrix();
//        System.out.println(lc1091ShortestPathInBinMatrix.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1, 0}}));
        System.out.println(lc1091ShortestPathInBinMatrix.shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
//        System.out.println(lc1091ShortestPathInBinMatrix.shortestPathBinaryMatrix(new int[][] {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}}));
    }

}
