package codewars;

/**
 * MazeRunner
 */
public class MazeRunner {
    private static final String DEAD = "Dead";
    private static final String FINISH = "Finish";
    private static final String LOST = "Lost";
    private static final int SPACE = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int END = 3;

    public static String walk(int[][] maze, String[] directions) {
        return navigate(maze, findStartingPoint(maze), directions);
    }

    private static int[] findStartingPoint(int[][] maze) {
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++)
                if (maze[i][j] == START)
                    return new int[] {i, j};
        return new int[0];
    }

    private static String navigate(int[][] maze, int[] position, String[] directions) {
        for (String dir : directions) {
            int[] move = switch (dir) {
                case "N" -> new int[] {-1, 0};
                case "E" -> new int[] {0, 1};
                case "S" -> new int[] {1, 0};
                case "W" -> new int[] {0, -1};
                default -> new int[0];
            };
            
            position[0] += move[0];
            position[1] += move[1];

            if (position[0] < 0 || position[0] > maze[0].length - 1 || position[1] < 0 || position[1] > maze.length - 1 || maze[position[0]][position[1]] == WALL)
                return DEAD;

            if (maze[position[0]][position[1]] == END)
                return FINISH;
        }

        if (maze[position[0]][position[1]] == WALL)
            return DEAD;

        if (maze[position[0]][position[1]] == END)
            return FINISH;

        if (maze[position[0]][position[1]] == SPACE || maze[position[0]][position[1]] == START)
            return LOST;

        return null;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 3},
			{1, 0, 1, 0, 1, 0, 1},
			{0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 2, 1, 0, 1, 0, 1}
        };
        System.out.println(walk(maze, new String[] {"N","N","N","N","N","E","E","E","E","E"}));
        System.out.println(walk(maze, new String[] {"N", "N", "N", "N", "N", "E", "E", "E", "E", "E", "W", "W"}));
        System.out.println(walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S" }));
    }
}
