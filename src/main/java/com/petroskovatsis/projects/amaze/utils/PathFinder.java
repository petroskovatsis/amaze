package com.petroskovatsis.projects.amaze.utils;

import com.petroskovatsis.projects.amaze.core.MazePoint;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PathFinder {

    private static PathFinder instance;

    private PathFinder() {
    }

    public static PathFinder getInstance() {
        return Optional.ofNullable(instance).orElseGet(() -> {
            instance = new PathFinder();
            return instance;
        });
    }

    public void findPath(MazePoint goalPoint, List<MazePoint> path) throws Exception {
        MazePoint point = goalPoint;
        while (point != null) {
            path.add(point);
            point = point.getPrevious();
        }

        if (path.size() == 1) {
            throw new Exception("No path could be found!");
        }

        Collections.reverse(path);
    }
}
