package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC827MakingALargeIsland {
    int n;
    Map<Integer, Integer> size;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int largestIsland(int[][] grid) {
        n = grid.length;
        size = new HashMap<>();
        int label = 2;
        //Precompute the size of all islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j, label);
                    size.put(label, islandSize);
                    label++;
                }
            }
        }

        int max = 0;
        for (int val : size.values()) {
            max = Math.max(max, val);
        }
        //Flip 0s to 1 & connect neighbouring islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, connect(grid, i, j));
                }
            }
        }
        return max;
    }

    int dfs (int[][] grid, int row, int col, int label) {
        //If out of bounds or 0 or already visited
        if (outOfBounds(row, col) || grid[row][col] != 1) {
            return 0;
        }
        int size = 1;
        grid[row][col] = label;
        for (int i = 0; i < directions.length; i++) {
            size += dfs(grid, row + directions[i][0], col + directions[i][1], label);
        }
        return size;
    }

    int connect (int[][] grid, int row, int col) {
        int res = 1;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (!outOfBounds(newRow, newCol) && !visited.contains(grid[newRow][newCol])) {
                int sz = size.get(grid[newRow][newCol]) != null ? size.get(grid[newRow][newCol]) : 0;
                res += sz;
                visited.add(grid[newRow][newCol]);
            }
        }
        return res;
    }

    boolean outOfBounds (int row, int col) {
        return (row >= n || col >= n || row < 0 || col < 0);
    }
}
