package com.example.demo.service;

import com.example.demo.KeelungSightsCrawler;
import com.example.demo.NotFoundException;
import com.example.demo.entity.Sight;
import com.example.demo.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SightService {
    @Autowired
    private SightRepository repository;

    private final KeelungSightsCrawler keelungSightsCrawler =  new KeelungSightsCrawler();

    public Object[] getSightByZone(String zone) {
        if(repository.findSightByZoneLike(zone).length != 0){
            Sight[] sights = repository.findSightByZoneLike(zone);
            return repository.findSightByZoneLike(zone);
        }else{
            Sight[] sights = keelungSightsCrawler.getItems(zone);
            saveAllSight(sights);
            return sights;
        }
    }

    public Object[] getSightByName(String name){
        return repository.findSightBySightNameLike(name)
                .orElseThrow(() -> new NotFoundException("Can't find it."));
    }

    public Object[] getAllSight(){
        return repository.findAll().toArray();
    }

    public void saveAllSight(Sight[] sights){
        for(Sight s: sights){
            repository.insert(s);
        }
    }

    public void deleteAllSight(){
        repository.deleteAll();
    }
}
