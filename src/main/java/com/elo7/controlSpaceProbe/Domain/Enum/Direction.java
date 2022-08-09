package com.elo7.controlSpaceProbe.Domain.Enum;

public enum Direction {
    N(1,"North"),
    E(2,"East"),
    S(3,"South"),
    W(4,"West");

    private final String description;

    Direction(int order, String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Direction getDirectionByOrder(int i){
        for(Direction dir: Direction.values()) {
            if (i == dir.ordinal()) {
                return dir;
            }
        }
        return this;
    }
}
