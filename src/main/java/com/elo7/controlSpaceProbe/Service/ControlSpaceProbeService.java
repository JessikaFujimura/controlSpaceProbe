package com.elo7.controlSpaceProbe.Service;

import com.elo7.controlSpaceProbe.Domain.Dto.PlanetDto;
import com.elo7.controlSpaceProbe.Domain.Dto.SpaceProbeDto;
import com.elo7.controlSpaceProbe.Domain.Enum.Command;
import com.elo7.controlSpaceProbe.Domain.Enum.Direction;
import com.elo7.controlSpaceProbe.Entity.Planet;
import com.elo7.controlSpaceProbe.Entity.SpaceProbe;
import com.elo7.controlSpaceProbe.Repository.PlanetRepository;
import com.elo7.controlSpaceProbe.Repository.SpaceProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlSpaceProbeService {

    @Autowired
    private SpaceProbeRepository spaceProbeRepository;

    @Autowired
    private PlanetRepository planetRepository;

    public SpaceProbeDto landSpaceProbe(SpaceProbeDto spaceProbeDto){
        Planet planet = planetRepository.findById(spaceProbeDto.getIdPlanet())
                .orElseThrow(() -> new RuntimeException("Planeta não encontrado"));
        planet.takePosition(spaceProbeDto.getPositionX(), spaceProbeDto.getPositionY());
        SpaceProbe spaceProbe = new SpaceProbe(spaceProbeDto.getPositionX(),
                spaceProbeDto.getPositionY(), spaceProbeDto.getDirection());
        SpaceProbe entityPersisted = spaceProbeRepository.save(spaceProbe);
        return new SpaceProbeDto(entityPersisted.getPositionX(),
                entityPersisted.getPositionY(),
                entityPersisted.getDirection().name().charAt(0),
                planet.getIdPlanet());
    }

    public PlanetDto createPlanet(PlanetDto planetDto){
        Planet planet = new Planet(planetDto.getName(), planetDto.getLength(), planetDto.getWidth());
        Planet entityPersisted = planetRepository.save(planet);
        return new PlanetDto(entityPersisted.getIdPlanet(), entityPersisted.getName(),
                entityPersisted.getWidth(), entityPersisted.getLength());
    }

    public String moveSpaceProbe(String command, SpaceProbe spaceProbe){
        char[] commands = command.toCharArray();
        for(char com: commands) {
            switch (com) {
                case 'R':
                    Command c = Command.valueOf(String.valueOf(com));
                    Direction d = c.commandR(spaceProbe.getDirection()) ;
                    spaceProbe.setDirection(d);
                    break;
                case 'L':
                    Direction di = Command.valueOf(String.valueOf(com))
                            .commandL(spaceProbe.getDirection());
                    spaceProbe.setDirection(di);
                    break;
                case 'M':
                    int pos;
                    if(spaceProbe.getDirection().equals(Direction.N) || spaceProbe.getDirection().equals(Direction.S)) {
                        pos = spaceProbe.moveY(1, spaceProbe.getDirection());
                    } else {
                        pos = spaceProbe.moveX(1, spaceProbe.getDirection());
                    }
                    break;
            }
        }

        return "Posição final da sonda:" + spaceProbe.getPositionAndDirection();
    }

    public SpaceProbe findSpaceProbe(int id){
        return spaceProbeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Sonda espacial não encontrada"));
    }

}
