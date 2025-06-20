package graph;

import java.util.HashSet;

public class LC489RobotRoomCleaner {
    
    interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
          // Returns false if the cell in front is blocked and robot stays in the current cell.
          public boolean move();

          // Robot will stay in the same cell after calling turnLeft/turnRight.
          // Each turn will be 90 degrees.
          public void turnLeft();
          public void turnRight();

          // Clean the current cell.
          public void clean();
    }
    
    
    Robot robot;
    //Directions ->         UP      RIGHT   DOWN    LEFT
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    public void cleanRoom (Robot robot) {
        this.robot = robot;
        traverse(0, 0, 0);
    }

    void goBackToPreviousCell () {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    void traverse (int row, int col, int dir) {
        //Clean the cell & add it to visited set
        robot.clean();
        visited.add(new Pair(row, col));

        //Traverse all directions
        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4;
            int[] newDirection = directions[newDir];
            int newRow = row + newDirection[0];
            int newCol = col + newDirection[1];
            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                traverse(newRow, newCol, newDir);
                goBackToPreviousCell();
            }
            robot.turnRight();
        }
    }
}
