package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.utils.TextReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class TestBFS {

    @Test
    public void testGetName() {
        BFS bfs = new BFS();
        Assertions.assertEquals("BFS", bfs.getName());
    }

    @Test
    public void testTraverse() {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze_simple.txt").getAbsolutePath());
            Maze maze = new Maze(lines);
            BFS bfs = new BFS();
            boolean result = bfs.traverse(maze);

            Assertions.assertTrue(result);
            Assertions.assertNotNull(bfs.getPath());
            Assertions.assertTrue(!bfs.getPath().isEmpty());
            Assertions.assertEquals(5, bfs.getPath().size());
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
