package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;



    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }


    @GetMapping(value = "/whiskies/year/{year}")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries/{id}")
    public ResponseEntity<List<Whisky>> findWhiskiesFromDistilleriesWithAge(@RequestParam(name="aged") int age, @PathVariable Long id){
        List<Whisky> whiskies = whiskyRepository.findByAgeAndDistilleryId( age, id);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }
    @GetMapping(value = "/whiskies/distilleries/region/{region}")
    public ResponseEntity<List<Whisky>> findWhiskiesWithDistilleryRegion(@RequestParam(name = "region") String region){
        List<Whisky> whiskies = whiskyRepository.findByDistilleryRegion(region);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

}
