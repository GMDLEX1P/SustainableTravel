package com.example.demo.controller;

import com.example.demo.model.Destination;
import com.example.demo.model.Itinerary;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DestinationController {

    @Autowired
    private DestinationRepository repo;
    private DestinationRepository reo;


    @Autowired
    private ItineraryRepository itineraryRepo;

    @GetMapping("/destinations")
    public List<Destination> getAllDestinations(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String experienceType) {

        if (region != null) return repo.findByRegion(region);
        if (experienceType != null) return repo.findByExperienceType(experienceType);
        return repo.findAll();
    }

    @PostMapping("/itinerary")
    public Itinerary saveItinerary(@RequestBody Itinerary itinerary) {
        return itineraryRepo.save(itinerary);
    }

    @GetMapping("/itinerary")
    public List<Itinerary> getAllItineraries() {
        return itineraryRepo.findAll();
    }
}
