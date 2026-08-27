package be.hoangconsulting.demo_api.mapper;

import be.hoangconsulting.demo_api.dto.ProjectDto;
import be.hoangconsulting.demo_api.model.Project;

public class ProjectMapper {

    public static ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getTechStack(),
                project.getLiveUrl()
        );
    }

    public static Project toEntity(ProjectDto dto) {
        return new Project(
                dto.name(),
                dto.description(),
                dto.techStack(),
                dto.liveUrl()
        );
    }
}