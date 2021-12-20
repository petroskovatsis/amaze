package com.petroskovatsis.projects.amaze.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTextReader {

    @Test
    public void testRead() {
        try {
            TextReader textReader = TextReader.getInstance();
            List<String> lines = textReader.read(new File("src/test/resources/maze.txt").getAbsolutePath());
            assertNotNull(lines);
            assertEquals(6, lines.size());
            assertEquals(8, lines.get(0).toCharArray().length);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
