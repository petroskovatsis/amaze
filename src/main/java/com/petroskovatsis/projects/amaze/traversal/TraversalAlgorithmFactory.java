package com.petroskovatsis.projects.amaze.traversal;

import java.util.Objects;

public class TraversalAlgorithmFactory {

    public TraversalAlgorithm getAlgorithm(String algo) {
        if (Objects.isNull(algo)) {
            return null;
        }

        switch (algo) {
            case "BFS":
                return new BFS();
            case "DFS":
                return new DFS();
            default:
                return null;
        }
    }
}
