package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.core.MazePoint;

import java.util.List;

public interface TraversalAlgorithm {

    String getName();

    boolean traverse(Maze maze) throws Exception;

    void printResults();

    List<MazePoint> getPath();
}
