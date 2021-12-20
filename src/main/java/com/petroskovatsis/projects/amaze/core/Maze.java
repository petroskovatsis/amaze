package com.petroskovatsis.projects.amaze.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maze {
    private final Logger logger = LoggerFactory.getLogger(Maze.class);

    private MazePoint[][] mazePoints;
    private MazePoint startPoint;
    private MazePoint goalPoint;

    public Maze(List<String> lines) throws Exception {
        validate(Objects.requireNonNull(lines, "The lines must be set."));
        mazePoints = new MazePoint[lines.size()][lines.get(0).toCharArray().length];
        build(lines);
    }

    public void print() {
        for (int i = 0; i < mazePoints.length; i++) {
            logger.info(Stream.of(mazePoints[i])
                    .map(MazePoint::getMazePointType)
                    .map(MazePointType::getSymbol)
                    .collect(Collectors.joining()));
        }
    }

    private void validate(List<String> lines) throws Exception {
        int len = lines.get(0).toCharArray().length;
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).toCharArray().length != len) {
                throw new Exception("Please provide a valid 2D array.");
            }
        }
    }

    private void build(List<String> lines) throws Exception {
        for (int i = 0; i < mazePoints.length; i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                String toCheck = String.valueOf(chars[j]);
                if (toCheck.equals(MazePointType.START.getSymbol())) {
                    mazePoints[i][j] = startPoint = new MazePoint(i, j, MazePointType.START);
                } else if (toCheck.equals(MazePointType.GOAL.getSymbol())) {
                    mazePoints[i][j] = goalPoint = new MazePoint(i, j, MazePointType.GOAL);
                } else if (toCheck.equals(MazePointType.BLOCK.getSymbol())) {
                    mazePoints[i][j] = new MazePoint(i, j, MazePointType.BLOCK);
                } else {
                    mazePoints[i][j] = new MazePoint(i, j, MazePointType.FREE);
                }

                attach(mazePoints[i][j]);
            }
        }

        if (Objects.isNull(startPoint)) {
            throw new Exception("The Start point must be set.");
        }

        if (Objects.isNull(goalPoint)) {
            throw new Exception("The Goal point must be set.");
        }
    }

    private void attach(MazePoint mp) {
        int row = mp.getRow() - 1;
        if (row >= 0) {
            MazePoint neighbor = mazePoints[row][mp.getCol()];
            neighbor.addNeighbor(mp);
            mp.addNeighbor(neighbor);
        }

        int col = mp.getCol() - 1;
        if (col >= 0) {
            MazePoint neighbor = mazePoints[mp.getRow()][col];
            neighbor.addNeighbor(mp);
            mp.addNeighbor(neighbor);
        }
    }

    public MazePoint[][] getMazePoints() {
        return mazePoints;
    }

    public MazePoint getStartPoint() {
        return startPoint;
    }

    public MazePoint getGoalPoint() {
        return goalPoint;
    }
}
