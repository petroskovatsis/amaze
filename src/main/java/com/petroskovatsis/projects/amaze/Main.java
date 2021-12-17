package com.petroskovatsis.projects.amaze;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.traversal.TraversalAlgorithm;
import com.petroskovatsis.projects.amaze.traversal.TraversalAlgorithmFactory;
import com.petroskovatsis.projects.amaze.utils.TextReader;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Etraveli Group!");
        System.out.println();

        if (args.length < 2) {
            throw new Exception("Parameters must be set: [0]algorithm(BFS or DFS) [1]maze_file_path");
        }

        String algorithmArg = Objects.requireNonNull(args[0], "The algorithm must be set.");
        String mazePathArg = Objects.requireNonNull(args[1], "The maze.txt file must be set.");

        System.out.println("Building the maze...");
        List<String> lines = TextReader.getInstance().read(mazePathArg);
        Maze maze = new Maze(lines);
        maze.print();

        System.out.println();

        TraversalAlgorithmFactory factory = new TraversalAlgorithmFactory();
        TraversalAlgorithm algorithm = factory.getAlgorithm(algorithmArg);

        if (Objects.isNull(algorithm)) {
            throw new Exception("Could not find algorithm. Please use BFS or DFS.");
        }

        System.out.println(String.format("Using %s algorithm. Great choice!", algorithm.getName()));
        algorithm.traverse(maze);
        algorithm.printResults();
    }
}
