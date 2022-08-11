package com.elo7.controlSpaceProbe.ControllerTests;

import com.elo7.controlSpaceProbe.Controller.ControlSpaceProbeController;
import com.elo7.controlSpaceProbe.Domain.Dto.PlanetDto;
import com.elo7.controlSpaceProbe.Domain.Dto.SpaceProbeDto;
import com.elo7.controlSpaceProbe.Entity.SpaceProbe;
import com.elo7.controlSpaceProbe.Service.ControlSpaceProbeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ControlSpaceProbeController.class)
public class ControlSpaceProbeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ControlSpaceProbeService service;


    @Test
    public void testCreatePlanet() throws Exception{
        PlanetDto planetDto = new PlanetDto(1,"Terra", 5,5);
        Mockito.when(service.createPlanet(Mockito.any(PlanetDto.class))).thenReturn(planetDto);
       this.mockMvc.perform(MockMvcRequestBuilders.post("/planets")
                .content((new ObjectMapper()).writeValueAsString(planetDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testLandSpaceProbe() throws Exception{
        SpaceProbeDto spaceProbeDto = new SpaceProbeDto(1,1,'N', 1);
        Mockito.when(service.landSpaceProbe(Mockito.any(SpaceProbeDto.class))).thenReturn(spaceProbeDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/space-probes")
                .content((new ObjectMapper()).writeValueAsString(spaceProbeDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

//    @Test
//    public void testMoveSpaceProbe() throws Exception {
//        String command = "LMD";
//        Mockito.when(service.moveSpaceProbe(command, Mockito.any(SpaceProbe.class)));
//    }
}
