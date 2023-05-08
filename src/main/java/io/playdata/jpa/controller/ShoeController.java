package io.playdata.jpa.controller;

import io.playdata.jpa.model.Shoe;
import io.playdata.jpa.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoes")
public class ShoeController {
    @Autowired
    private ShoeService shoeService;

    @GetMapping
    public List<Shoe> findAll() {
        return shoeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Shoe> findById(@PathVariable Long id) {
        return shoeService.findById(id);
    }

    @PostMapping
    public Shoe save(@RequestBody Shoe shoe) {
        return shoeService.save(shoe);
    }

    @PutMapping("/{id}")
    public Shoe update(@PathVariable Long id, @RequestBody Shoe shoe) {
        shoe.setId(id);
        return shoeService.save(shoe);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        shoeService.deleteById(id);
    }
}