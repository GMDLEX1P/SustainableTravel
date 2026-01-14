package com.example.demo.controller;

import com.example.demo.model.Destination;
import com.example.demo.model.Itinerary;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;


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

    @PostMapping("/budget")
    public Map<String, Double> calculateBudget(@RequestBody Map<String, Double> costs) {
        double travelCost = costs.getOrDefault("travelCost", 0.0);
        double accomCost = costs.getOrDefault("accomCost", 0.0);
        double activityCost = costs.getOrDefault("activityCost", 0.0);
        double total = travelCost + accomCost + activityCost;

        Map<String, Double> result = new HashMap<>();
        result.put("travelCost", travelCost);
        result.put("accomCost", accomCost);
        result.put("activityCost", activityCost);
        result.put("total", total);
        return result;
    }

    @GetMapping("/budget-test")
    public Map<String, Double> calculateBudgetTest() {
        Map<String, Double> result = new HashMap<>();
        result.put("travelCost", 100.0);
        result.put("accomCost", 50.0);
        result.put("activityCost", 30.0);
        result.put("total", 180.0);
        return result;
    }

}

