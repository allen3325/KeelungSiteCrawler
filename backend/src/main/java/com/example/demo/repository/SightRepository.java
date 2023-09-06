package com.example.demo.repository;

import com.example.demo.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SightRepository extends MongoRepository<Sight,String> {
    boolean existsSightBySightName(String sightName);
    Sight[] findSightByZoneLike(String zone);
    Optional<Object[]> findSightBySightNameLike(String name);
}
