package be.hoangconsulting.demo_api.service;

// ProjectServiceImpl.java



import be.hoangconsulting.demo_api.dto.ProjectDto;
import be.hoangconsulting.demo_api.exception.ProjectNotFoundException;
import be.hoangconsulting.demo_api.mapper.ProjectMapper;
import be.hoangconsulting.demo_api.model.Project;
import be.hoangconsulting.demo_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectDto create(ProjectDto dto) {
        Project saved = repository.save(ProjectMapper.toEntity(dto));
        return ProjectMapper.toDto(saved);
    }

    @Override
    public ProjectDto getById(String id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return ProjectMapper.toDto(project);
    }

    @Override
    public List<ProjectDto> getAll() {
        return repository.findAll().stream()
                .map(ProjectMapper::toDto)
                .toList(); // Java 16+ Stream.toList()
    }

    @Override
    public ProjectDto update(String id, ProjectDto dto) {
        Project existing = repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        existing.setName(dto.name());
        existing.setDescription(dto.description());
        existing.setTechStack(dto.techStack());
        existing.setLiveUrl(dto.liveUrl());

        return ProjectMapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ProjectNotFoundException(id);
        }
        repository.deleteById(id);
    }
}