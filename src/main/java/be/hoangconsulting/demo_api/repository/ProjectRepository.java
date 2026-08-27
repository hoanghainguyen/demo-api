package be.hoangconsulting.demo_api.repository;


import be.hoangconsulting.demo_api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, String> {

    // Example custom query — find by name (case-insensitive)
    List<Project> findByNameContainingIgnoreCase(String name);
}
