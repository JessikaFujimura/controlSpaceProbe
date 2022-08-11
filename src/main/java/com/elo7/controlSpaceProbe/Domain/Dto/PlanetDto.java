package com.elo7.controlSpaceProbe.Domain.Dto;

public class PlanetDto {

    private int idPlanet;
    private String name;
    private int width;
    private int length;

    public PlanetDto(int idPlanet, String name, int width, int length) {
        this.idPlanet = idPlanet;
        this.name = name;
        this.width = width;
        this.length = length;
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


}
