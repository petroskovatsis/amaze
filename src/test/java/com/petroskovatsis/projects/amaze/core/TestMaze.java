package com.petroskovatsis.projects.amaze.core;

import com.petroskovatsis.projects.amaze.utils.TextReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestMaze {

    @Test
    public void testConstructor() {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze.txt").getAbsolutePath());
            Assertions.assertDoesNotThrow(() -> new Maze(lines));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void testNonLinesProvidedShouldThrowException() {
        Assertions.assertThrows(Exception.class, () -> new Maze(null));
    }

    @Test
    public void testInvalid2DArrayShouldThrowException() {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze_err.txt").getAbsolutePath());
            Assertions.assertThrows(Exception.class, () -> new Maze(lines));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void testNoStartPointShouldThrowException() throws IOException {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze_no_start.txt").getAbsolutePath());
            Assertions.assertThrows(Exception.class, () -> new Maze(lines));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void testNoGoalPointShouldThrowException() throws IOException {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze_no_goal.txt").getAbsolutePath());
            Assertions.assertThrows(Exception.class, () -> new Maze(lines));
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
