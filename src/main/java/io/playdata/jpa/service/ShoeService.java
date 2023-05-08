package io.playdata.jpa.service;

import io.playdata.jpa.model.Shoe;
import io.playdata.jpa.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShoeService {
    @Autowired
    private ShoeRepository shoeRepository;

    public List<Shoe> findAll() {
        return shoeRepository.findAll();
    }

    public Optional<Shoe> findById(Long id) {
        return shoeRepository.findById(id);
    }

    public Shoe save(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

    public void deleteById(Long id) {
        shoeRepository.deleteById(id);
    }

    public List<Shoe> findByName(String name) {
        return shoeRepository.findByNameContaining(name);
    }

    public List<Shoe> findByPriceRange(int minPrice, int maxPrice) {
        return shoeRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Map<String, Integer> countByBrand() {
        List<Object[]> counts = shoeRepository.countByBrand();
        Map<String, Integer> result = new HashMap<>();

        counts.forEach(row -> {
            String brand = (String) row[0];
            BigInteger count = (BigInteger) row[1];
            result.put(brand, count.intValue());
        });

        return result;
    }

    public Shoe findMostExpensive() {
        return shoeRepository.findMostExpensive();
    }
}