package be.hoangconsulting.demo_api.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String id) {
        super("Project not found with id: " + id);
    }
}