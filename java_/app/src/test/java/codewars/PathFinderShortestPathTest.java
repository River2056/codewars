package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * PathFinderShortestPathTest
 */
class PathFinderShortestPathTest {

    @Test
    void testPathFinderShortestPath() {
        String a = ".W.\n"+
                 ".W.\n"+
                 "...",
               
             b = ".W.\n"+
                 ".W.\n"+
                 "W..",
               
             c = "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 "......",
               
             d = "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 ".....W\n"+
                 "....W.";

        assertEquals(4,  PathFinderShortestPath.pathFinder(a));
        assertEquals(-1, PathFinderShortestPath.pathFinder(b));
        assertEquals(10, PathFinderShortestPath.pathFinder(c));
        assertEquals(-1, PathFinderShortestPath.pathFinder(d));
    }
}
