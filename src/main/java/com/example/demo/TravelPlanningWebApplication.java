package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.model.Destination;

@SpringBootApplication
public class TravelPlanningWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelPlanningWebApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(DestinationRepository repo) {
        return args -> {
            repo.save(createDestination("Almaty", "Central Asia", "Mountain city", "Big Almaty Lake", "Eco-hotels", "Adventure", 50, 30));
            repo.save(createDestination("Astana", "Central Asia", "Modern capital", "Baiterek Tower", "Green transport", "Culture", 70, 40));
            repo.save(createDestination("Shymkent", "Central Asia", "Historic city", "Ancient sites", "Local guides", "History", 40, 25));
        };
    }

    private Destination createDestination(String name, String region, String desc, String highlights, String sustain, String type, double accom, double activity) {
        Destination d = new Destination();
        d.setName(name);
        d.setRegion(region);
        d.setDescription(desc);
        d.setHighlights(highlights);
        d.setSustainability(sustain);
        d.setExperienceType(type);
        d.setAccomCost(accom);
        d.setActivityCost(activity);
        return d;
    }
}
