package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;
    private String description;
    private String highlights;
    private String sustainability;
    private String experienceType;
    private double accomCost;
    private double activityCost;

    public Destination() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getHighlights() { return highlights; }
    public void setHighlights(String highlights) { this.highlights = highlights; }

    public String getSustainability() { return sustainability; }
    public void setSustainability(String sustainability) { this.sustainability = sustainability; }

    public String getExperienceType() { return experienceType; }
    public void setExperienceType(String experienceType) { this.experienceType = experienceType; }

    public double getAccomCost() { return accomCost; }
    public void setAccomCost(double accomCost) { this.accomCost = accomCost; }

    public double getActivityCost() { return activityCost; }
    public void setActivityCost(double activityCost) { this.activityCost = activityCost; }
}
