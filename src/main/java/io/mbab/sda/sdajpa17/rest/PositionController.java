package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Position;
import io.mbab.sda.sdajpa17.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
class PositionController {

    private PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Position findById(@PathVariable Long id) {
        return positionRepository.findById(id);
    }

    @GetMapping("/names")
    public List<String> findAllNames() {
        return positionRepository.findAllNames();
    }

    @GetMapping("/search")
    public List<Position> findByName(@RequestParam(required = false) String value) {
        return positionRepository.findByName(value);
    }

    @PostMapping
    public Position create(@RequestBody Position obj) {
        return positionRepository.create(obj);
    }

    @PutMapping
    public Position update(@RequestBody Position obj) {
        return positionRepository.update(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        positionRepository.deleteById(id);
    }

}

