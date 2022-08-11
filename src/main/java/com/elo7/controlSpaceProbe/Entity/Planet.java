package com.elo7.controlSpaceProbe.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanet;

    private String name;
    private int width;
    private int length;

    @Transient
    private List<int[]> occupiedPositions;

    public Planet(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.occupiedPositions = new ArrayList<>();
    }

    public Planet() {
    }

    public int getIdPlanet() {
        return idPlanet;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getArea(int width, int length){
        return width * length;
    }

    public void takePosition(int x, int y){
        int[] position = new int[]{x, y};
        verifyAvailable(position);
        this.occupiedPositions.add(position);
    }

    private void verifyAvailable(int[] position) {
        for(int[] pos: occupiedPositions){
            if(pos[0] == position[0] && pos[1] == position[1]){
                throw new RuntimeException("Posição ocupada");
            }
        }
    }
}
