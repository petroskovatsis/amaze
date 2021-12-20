package com.petroskovatsis.projects.amaze.traversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTraversalAlgorithmFactory {

    TraversalAlgorithmFactory factory = new TraversalAlgorithmFactory();

    @Test
    public void testShouldReturnNull() {
        TraversalAlgorithm res1 = factory.getAlgorithm(null);
        TraversalAlgorithm res2 = factory.getAlgorithm("");

        Assertions.assertNull(res1);
        Assertions.assertNull(res2);
    }

    @Test
    public void testShouldReturnBFS() {
        TraversalAlgorithm algorithm = factory.getAlgorithm("BFS");

        Assertions.assertNotNull(algorithm);
        Assertions.assertInstanceOf(BFS.class, algorithm);
    }

    @Test
    public void testShouldReturnDFS() {
        TraversalAlgorithm algorithm = factory.getAlgorithm("DFS");

        Assertions.assertNotNull(algorithm);
        Assertions.assertInstanceOf(DFS.class, algorithm);
    }
}
