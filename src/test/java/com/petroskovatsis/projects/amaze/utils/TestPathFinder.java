package com.petroskovatsis.projects.amaze.utils;

import com.petroskovatsis.projects.amaze.core.MazePoint;
import com.petroskovatsis.projects.amaze.core.MazePointType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPathFinder {

    @Test
    public void testGoalNotProvidedShouldThrowException() {
        PathFinder pathFinder = PathFinder.getInstance();
        Assertions.assertThrows(Exception.class, () -> pathFinder.findPath(null, new ArrayList<MazePoint>()));
    }

    @Test
    public void testPathWithGoalOnlyShouldThrowException() {
        MazePoint goal = new MazePoint(0, 0, MazePointType.GOAL);
        PathFinder pathFinder = PathFinder.getInstance();
        Assertions.assertThrows(Exception.class, () -> pathFinder.findPath(goal, new ArrayList<MazePoint>()));
    }

    @Test
    public void testFindPath() {
        MazePoint start = new MazePoint(0, 0, MazePointType.START);
        MazePoint free = new MazePoint(0, 1, MazePointType.FREE);
        free.setPrevious(start);
        MazePoint goal = new MazePoint(0, 2, MazePointType.GOAL);
        goal.setPrevious(free);
        PathFinder pathFinder = PathFinder.getInstance();
        List<MazePoint> path = new ArrayList<>();

        Assertions.assertDoesNotThrow(() -> pathFinder.findPath(goal, path));
        Assertions.assertTrue(!path.isEmpty());
        Assertions.assertEquals(3, path.size());

        Assertions.assertEquals(MazePointType.START, path.get(0).getMazePointType());
        Assertions.assertEquals(0, path.get(0).getRow());
        Assertions.assertEquals(0, path.get(0).getCol());

        MazePoint goalToTest = path.get(path.size() - 1);
        Assertions.assertEquals(MazePointType.GOAL, goalToTest.getMazePointType());
        Assertions.assertEquals(0, goalToTest.getRow());
        Assertions.assertEquals(2, goalToTest.getCol());
    }
}
