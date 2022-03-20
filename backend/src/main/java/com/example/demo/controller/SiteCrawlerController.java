package com.example.demo.controller;

import com.example.demo.entity.Sight;
import com.example.demo.service.SiteCrawlerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)


public class SiteCrawlerController {

    @GetMapping("/getZoneSight")
    public Sight[] getCrawler(@RequestParam(value = "zone", defaultValue = "") String zone) {
        SiteCrawlerService crawler = new SiteCrawlerService();
        return crawler.getItems(zone);
    }
}
