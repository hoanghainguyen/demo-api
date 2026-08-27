package be.hoangconsulting.demo_api.dto;


import java.util.List;

public record ProjectDto(
        String id,
        String name,
        String description,
        List<String> techStack,
        String liveUrl
) {}