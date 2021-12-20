package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;

public interface TraversalAlgorithm {

    String getName();

    boolean traverse(Maze maze) throws Exception;

    void printResults();
}
