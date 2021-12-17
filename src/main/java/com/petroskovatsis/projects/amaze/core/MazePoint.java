package com.petroskovatsis.projects.amaze.core;

import java.util.LinkedList;
import java.util.Objects;

public class MazePoint {

    private int row;
    private int col;
    private MazePointType mazePointType;
    private LinkedList<MazePoint> neighbors;
    private MazePoint previous;

    public MazePoint(int row, int col, MazePointType mazePointType) {
        this.row = row;
        this.col = col;
        this.mazePointType = mazePointType;
        neighbors = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazePoint mazePoint = (MazePoint) o;
        return row == mazePoint.row && col == mazePoint.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public void addNeighbor(MazePoint mp) {
        this.neighbors.add(mp);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public MazePointType getMazePointType() {
        return mazePointType;
    }

    public void setMazePointType(MazePointType mazePointType) {
        this.mazePointType = mazePointType;
    }

    public LinkedList<MazePoint> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<MazePoint> neighbors) {
        this.neighbors = neighbors;
    }

    public MazePoint getPrevious() {
        return previous;
    }

    public void setPrevious(MazePoint previous) {
        this.previous = previous;
    }
}
