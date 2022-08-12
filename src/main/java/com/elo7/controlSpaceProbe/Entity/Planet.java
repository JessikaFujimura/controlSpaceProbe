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

    @OneToMany(mappedBy = "planet")
    private List<SpaceProbe> listOfProbe;

    @Transient
    private List<int[]> occupiedPositions = new ArrayList<>();

    public Planet(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.listOfProbe = new ArrayList<>();
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

    public void landProbeInPlanet(SpaceProbe spaceProbe){
        this.listOfProbe.add(spaceProbe);
        int[] position = new int[]{spaceProbe.getPositionX(),spaceProbe.getPositionY()};
        verifyAvailable(position);
        this.occupiedPositions.add(position);
    }

    public void removeProbe(SpaceProbe spaceProbe){
        listOfProbe.remove(spaceProbe);
    }

    private void verifyAvailable(int[] position) {
        for(int[] pos: occupiedPositions){
            if(pos[0] == position[0] && pos[1] == position[1]){
                throw new RuntimeException("Posição ocupada");
            }
        }
    }
}
