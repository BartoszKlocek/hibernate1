package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Position;
import io.mbab.sda.sdajpa17.entity.Project;
import io.mbab.sda.sdajpa17.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController extends AbstractController<Project, Long> {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        super(projectRepository);
        this.projectRepository = projectRepository;
    }
    @GetMapping("/names")
    public List<String> findAllNames(String name){
        return projectRepository.findAllNames();
    }

    @GetMapping("/search")
    public List<Project> findByName(@RequestParam(required = false) String name) {
        return projectRepository.findByName(name);
    }


}
