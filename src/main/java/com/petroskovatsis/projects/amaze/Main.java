package com.petroskovatsis.projects.amaze;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.traversal.TraversalAlgorithm;
import com.petroskovatsis.projects.amaze.traversal.TraversalAlgorithmFactory;
import com.petroskovatsis.projects.amaze.utils.ExecutionTimer;
import com.petroskovatsis.projects.amaze.utils.TextReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello Etraveli Group!");

        if (args.length < 2) {
            logger.error("Parameters must be set: [0]algorithm(BFS or DFS) [1]maze_file_path");
            System.exit(1);
        }

        String algorithmArg = Objects.requireNonNull(args[0], "The algorithm must be set.");
        String mazePathArg = Objects.requireNonNull(args[1], "The maze.txt file must be set.");

        try {
            logger.info("Building the maze from path: {}", mazePathArg);
            List<String> lines = TextReader.getInstance().read(mazePathArg);
            Maze maze = new Maze(lines);
            maze.print();

            TraversalAlgorithmFactory factory = new TraversalAlgorithmFactory();
            TraversalAlgorithm algorithm = factory.getAlgorithm(algorithmArg);

            if (Objects.isNull(algorithm)) {
                logger.error("Could not find algorithm. Please use BFS or DFS.");
                System.exit(1);
            }

            logger.info("Using {} algorithm. Great choice!", algorithm.getName());
            ExecutionTimer executionTimer = new ExecutionTimer();
            executionTimer.exec(new ExecutionTimer.ExecMethod<Boolean>() {
                @Override
                public Boolean exec() throws Exception {
                    return algorithm.traverse(maze);
                }
            });
            algorithm.printResults();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
