package be.hoangconsulting.demo_api.service;


import be.hoangconsulting.demo_api.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto create(ProjectDto dto);
    ProjectDto getById(String id);
    List<ProjectDto> getAll();
    ProjectDto update(String id, ProjectDto dto);
    void delete(String id);
}