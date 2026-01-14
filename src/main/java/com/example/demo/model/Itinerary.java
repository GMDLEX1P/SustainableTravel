package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<Long> destinationIds;

    private LocalDate startDate;
    private LocalDate endDate;

    private String activities;

    public Itinerary() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Long> getDestinationIds() { return destinationIds; }
    public void setDestinationIds(List<Long> destinationIds) { this.destinationIds = destinationIds; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getActivities() { return activities; }
    public void setActivities(String activities) { this.activities = activities; }
}
