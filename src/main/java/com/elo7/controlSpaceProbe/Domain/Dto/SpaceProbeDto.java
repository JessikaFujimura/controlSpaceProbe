package com.elo7.controlSpaceProbe.Domain.Dto;

import com.elo7.controlSpaceProbe.Domain.Enum.Direction;

public class SpaceProbeDto {
    private int positionX;
    private int positionY;
    private char direction;
    private int idPlanet;

    public SpaceProbeDto(int positionX, int positionY, char direction, int idPlanet) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.idPlanet = idPlanet;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getIdPlanet() {
        return idPlanet;
    }

    public Direction getDirection() {
        for (Direction d : Direction.values()) {
            if (this.direction == d.toString().charAt(0)) {
                return d;
            }
        }
        return null;
    }
}
