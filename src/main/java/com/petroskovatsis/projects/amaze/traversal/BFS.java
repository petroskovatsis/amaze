package com.petroskovatsis.projects.amaze.traversal;

import com.petroskovatsis.projects.amaze.core.Maze;
import com.petroskovatsis.projects.amaze.core.MazePoint;
import com.petroskovatsis.projects.amaze.core.MazePointType;
import com.petroskovatsis.projects.amaze.utils.PathFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFS implements TraversalAlgorithm {
    private final Logger logger = LoggerFactory.getLogger(BFS.class);

    private Queue<MazePoint> queue = new ArrayDeque<>();
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
        logger.info("Path result from BFS: {}", result);
    }

    @Override
    public boolean traverse(Maze maze) throws Exception {
        MazePoint[][] visited = new MazePoint[maze.getMazePoints().length][maze.getMazePoints()[0].length];
        visited[maze.getStartPoint().getRow()][maze.getStartPoint().getCol()] = maze.getStartPoint();
        queue.add(maze.getStartPoint());

        while (queue.size() != 0) {
            MazePoint point = queue.poll();

            if (point.getMazePointType() == MazePointType.BLOCK) {
                continue;
            }

            if (point.getMazePointType() == MazePointType.GOAL) {
                break;
            }

            for (int i = 0; i < point.getNeighbors().size(); i++) {
                MazePoint neighbor = point.getNeighbors().get(i);
                if (Objects.isNull(visited[neighbor.getRow()][neighbor.getCol()])) {
                    visited[neighbor.getRow()][neighbor.getCol()] = neighbor;
                    queue.add(neighbor);
                    neighbor.setPrevious(point);
                }
            }
        }

        PathFinder.getInstance().findPath(maze.getGoalPoint(), path);
        return true;
    }

    @Override
    public List<MazePoint> getPath() {
        return path;
    }
}
