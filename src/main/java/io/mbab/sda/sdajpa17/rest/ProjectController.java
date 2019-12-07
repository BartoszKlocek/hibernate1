package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Project;
import io.mbab.sda.sdajpa17.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @GetMapping
    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    @PostMapping
    public Project create(@RequestBody Project obj){
        return projectRepository.create(obj);
    }
    @PutMapping
    public Project update(@RequestBody Project obj){
        return projectRepository.update(obj);
    }

    @GetMapping("/{id}")
    public  Project findById(@PathVariable Long id){
        return projectRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        projectRepository.deleteById(id);
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
