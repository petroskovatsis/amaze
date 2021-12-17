package com.petroskovatsis.projects.amaze.core;

public enum MazePointType {

    START("S"), GOAL("G"), BLOCK("X"), FREE("_");

    private String symbol;

    MazePointType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
