package com.elo7.controlSpaceProbe.Entity;

import com.elo7.controlSpaceProbe.Domain.Enum.Direction;

import javax.persistence.*;

@Entity
public class SpaceProbe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProbe;

    private int positionX;
    private int positionY;
    private Direction direction;

    @ManyToOne
    @JoinColumn(name="planet_id")
    private Planet planet;

    public SpaceProbe(int positionX, int positionY, Direction direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public SpaceProbe() {
    }

    public int getIdProbe() {
        return idProbe;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPositionAndDirection(){
        return "x=" + this.positionX + " y=" + this.positionY + " apontando para " + this.getDirection().getDescription();
    }

    public int moveX(int step, Direction direction){
        if (direction.equals(Direction.W)) {
            return this.positionX = positionX - step;
        }
        if(direction.equals(Direction.E)) {
            return this.positionX = positionX + step;
        }
        return this.positionX;
    }

    public int moveY(int step, Direction direction){
        if (direction.equals(Direction.N)) {
            return this.positionY = positionY + step;
        }
        if(direction.equals(Direction.S)) {
            return this.positionY = positionY - step;
        }
        return this.positionY;
    }

}
