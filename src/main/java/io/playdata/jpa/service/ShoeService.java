package io.playdata.jpa.service;

import io.playdata.jpa.model.Shoe;
import io.playdata.jpa.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}