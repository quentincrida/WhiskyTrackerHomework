package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int age);


    List<Whisky> findByAgeAndDistilleryName(int age, String name );

    List<Whisky> findByAgeAndDistilleryId(int age, Long id);

    List<Whisky> findByDistilleryRegion(String region);
}
