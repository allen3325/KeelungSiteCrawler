package com.example.demo.repository;

import com.example.demo.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SightRepository extends MongoRepository<Sight,String> {
    Optional<Object[]> findSightByZoneLike(String zone);
    Optional<Object[]> findSightBySightNameLike(String name);
}
