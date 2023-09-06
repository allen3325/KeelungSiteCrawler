package com.example.demo.controller;

import com.example.demo.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SightController {

    @Autowired
    private SightService sightService;

    @GetMapping("/getAllSight")
    public Object[] getData() {
        return sightService.getAllSight();
    }

    @GetMapping("/getZoneSight")
    public Object[] getZoneSight(@RequestParam(value = "zone",defaultValue = "") String zone){
        return sightService.getSightByZone(zone);
    }

    @GetMapping("/getSight")
    public Object[] getSight(@RequestParam(value = "name",defaultValue = "") String name){
        return sightService.getSightByName(name);
    }

}
