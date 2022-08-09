package com.elo7.controlSpaceProbe.Controller;

import com.elo7.controlSpaceProbe.Domain.Dto.SpaceProbeDto;
import com.elo7.controlSpaceProbe.Entity.SpaceProbe;
import com.elo7.controlSpaceProbe.Service.ControlSpaceProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlSpaceProbeController {

    @Autowired
    private ControlSpaceProbeService controlSpaceProbeService;

    @PostMapping("/planets")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createPlanet(){
        controlSpaceProbeService.createPlanet();
    }

    @PostMapping("/space-probes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SpaceProbe landSpaceProbe(@RequestBody SpaceProbeDto spaceProbeDto){
        return controlSpaceProbeService.landSpaceProbe(spaceProbeDto);
    }

    @PutMapping("/space-probes/{id}")
    public String moveSpaceProbe(@RequestBody String command,
                                 @PathVariable Integer id){
        SpaceProbe spaceProbe = controlSpaceProbeService.findSpaceProbe(id);
        return controlSpaceProbeService.moveSpaceProbe(command, spaceProbe);
    }

}
