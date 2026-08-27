package be.hoangconsulting.demo_api.model;

import java.util.List;

// Project.java (JPA Entity)


import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_tech_stack", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tech")
    private List<String> techStack;

    @Column(name = "live_url")
    private String liveUrl;

    protected Project() {} // required by JPA

    public Project(String name, String description, List<String> techStack, String liveUrl) {
        this.name = name;
        this.description = description;
        this.techStack = techStack;
        this.liveUrl = liveUrl;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getTechStack() { return techStack; }
    public void setTechStack(List<String> techStack) { this.techStack = techStack; }
    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }
}