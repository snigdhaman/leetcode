package arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class LC36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] grids = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (rows[i].contains(ch)) {
                    return false;
                }
                rows[i].add(ch);

                if (cols[j].contains(ch)) {
                    return false;
                }
                cols[j].add(ch);

                int gridIdx = 3 * (i / 3) + (j / 3);
                if (grids[gridIdx].contains(ch)) {
                    return false;
                }
                grids[gridIdx].add(ch);
            }
        }
        return true;
    }
}
