package codewars;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * PathFinderShortestPath
 */
public class PathFinderShortestPath {

    private static Integer[][] directions = new Integer[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int pathFinder(String maze) {
        String[][] mazeArray = Arrays.stream(maze.split("\n")).map(a -> a.trim().split("")).toArray(String[][]::new);
        boolean[][] visited = new boolean[mazeArray.length][mazeArray[0].length];
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[] {0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Integer[] position = queue.poll();

            if (position[0] == mazeArray[0].length - 1 && position[1] == mazeArray.length - 1)
                return position[2];

            for (Integer[] dir : directions) {
                findNeighbours(new Integer[] {
                    position[0] + dir[0],
                    position[1] + dir[1],
                    position[2] + 1
                }, mazeArray, queue, visited);
            }
        }
		return -1;
	}

    private static boolean findNeighbours(Integer[] position, String[][] maze, Queue<Integer[]> queue, boolean[][] visited) {
        int x = position[0];
        int y = position[1];
        int steps = position[2];
        if (x < 0 || x >= maze[0].length || y < 0 || y >= maze.length || "W".equals(maze[y][x]) || visited[y][x])
            return false;

        visited[y][x] = true;
        queue.add(new Integer[] {x, y, steps});
        return true;
    }
}
