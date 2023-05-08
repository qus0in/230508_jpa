package io.playdata.jpa.controller;

import io.playdata.jpa.model.Shoe;
import io.playdata.jpa.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Shoe> findById(@PathVariable Long id) {
        Optional<Shoe> shoe = shoeService.findById(id);
        return shoe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Shoe> save(@RequestBody Shoe shoe) {
        Shoe savedShoe = shoeService.save(shoe);
        return ResponseEntity.ok(savedShoe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoe> update(@PathVariable Long id, @RequestBody Shoe shoe) {
        Optional<Shoe> existingShoe = shoeService.findById(id);
        if (existingShoe.isPresent()) {
            shoe.setId(id);
            Shoe updatedShoe = shoeService.save(shoe);
            return ResponseEntity.ok(updatedShoe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Shoe> shoe = shoeService.findById(id);
        if (shoe.isPresent()) {
            shoeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name")
    public List<Shoe> findByName(@RequestParam String name) {
        return shoeService.findByName(name);
    }

    @GetMapping("/price-range")
    public List<Shoe> findByPriceRange(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return shoeService.findByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/brand-count")
    public Map<String, Integer> countByBrand() {
        return shoeService.countByBrand();
    }

    @GetMapping("/most-expensive")
    public ResponseEntity<Shoe> findMostExpensive() {
        Shoe shoe = shoeService.findMostExpensive();
        if (shoe != null) {
            return ResponseEntity.ok(shoe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}