package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.core.MazePoint;
import com.petroskovatsis.projects.amaze.core.MazePointType;
import com.petroskovatsis.projects.amaze.utils.PathFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DFS implements TraversalAlgorithm {

    private List<MazePoint> path = new ArrayList<>();

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void printResults() {
        String result = path.stream()
                .map(p -> String.format("(%s:%s (%s))", p.getRow(), p.getCol(), p.getMazePointType().getSymbol()))
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

    @Override
    public void traverse(Maze maze) throws Exception {
        long startMillis = System.currentTimeMillis();
        MazePoint[][] visited = new MazePoint[maze.getMazePoints().length][maze.getMazePoints()[0].length];
        traverse(maze.getStartPoint(), visited);
        PathFinder.getInstance().findPath(maze.getGoalPoint(), path);
        long endMillis = System.currentTimeMillis();
        System.out.println(String.format("Took %d millis.", endMillis - startMillis));
    }

    private void traverse(MazePoint mp, MazePoint[][] visited) {
        visited[mp.getRow()][mp.getCol()] = mp;

        if (mp.getMazePointType() == MazePointType.BLOCK) {
            return;
        }

        for (int i = 0; i < mp.getNeighbors().size(); i++) {
            MazePoint neighbor = mp.getNeighbors().get(i);
            if (Objects.isNull(visited[neighbor.getRow()][neighbor.getCol()])) {
                traverse(neighbor, visited);
                neighbor.setPrevious(mp);
                if (neighbor.getMazePointType() == MazePointType.GOAL) {
                    break;
                }
            }
        }
    }
}
