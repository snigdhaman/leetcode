package graph;

import java.util.HashMap;
import java.util.Map;

public class LC200NumberOfIslands {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Map<Integer, Integer> map;
    public int numIslands(char[][] grid) {
        map = new HashMap<>();
        int label = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int size = dfs(grid, i, j, label);
                    map.put(label, size);
                    label++;
                }
            }
        }
        return map.size();
    }

    int dfs (char[][] grid, int row, int col, int label) {
        if (outOfBounds(grid, row, col) || grid[row][col] != '1') {
            return 0;
        }
        int size = 1;
        grid[row][col] = (char) (label + 48);
        //DFS traverse all 4 directions & update the island size
        for (int i = 0; i < directions.length; i++) {
            size += dfs(grid, row + directions[i][0], col + directions[i][1], label);
        }
        return size;
    }

    boolean outOfBounds (char[][] grid, int row, int col) {
        return row >= grid.length || col >= grid[0].length || row < 0 || col < 0;
    }
}
