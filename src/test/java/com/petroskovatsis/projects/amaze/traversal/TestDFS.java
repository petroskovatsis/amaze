package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.utils.TextReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class TestDFS {

    @Test
    public void testGetName() {
        DFS dfs = new DFS();
        Assertions.assertEquals("DFS", dfs.getName());
    }

    @Test
    public void testTraverse() {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze_simple.txt").getAbsolutePath());
            Maze maze = new Maze(lines);
            DFS dfs = new DFS();
            boolean result = dfs.traverse(maze);

            Assertions.assertTrue(result);
            Assertions.assertNotNull(dfs.getPath());
            Assertions.assertTrue(!dfs.getPath().isEmpty());
            Assertions.assertEquals(5, dfs.getPath().size());
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
