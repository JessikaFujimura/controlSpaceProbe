package com.elo7.controlSpaceProbe.Controller;

import com.elo7.controlSpaceProbe.Domain.Dto.PlanetDto;
import com.elo7.controlSpaceProbe.Domain.Dto.SpaceProbeDto;
import com.elo7.controlSpaceProbe.Entity.SpaceProbe;
import com.elo7.controlSpaceProbe.Service.ControlSpaceProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlSpaceProbeController {

    @Autowired
    private ControlSpaceProbeService controlSpaceProbeService;

    @PostMapping(value = "/planets")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PlanetDto createPlanet(@RequestBody PlanetDto planetDto){
        return controlSpaceProbeService.createPlanet(planetDto);
    }

    @PostMapping("/space-probes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SpaceProbeDto landSpaceProbe(@RequestBody SpaceProbeDto spaceProbeDto){
        return controlSpaceProbeService.landSpaceProbe(spaceProbeDto);
    }

    @PutMapping("/space-probes/{id}")
    public String moveSpaceProbe(@RequestBody String command,
                                 @PathVariable Integer id){
        SpaceProbe spaceProbe = controlSpaceProbeService.findSpaceProbe(id);
        return controlSpaceProbeService.moveSpaceProbe(command, spaceProbe);
    }

}
