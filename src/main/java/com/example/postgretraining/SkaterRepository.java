package com.example.postgretraining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface SkaterRepository  extends JpaRepository<Skater, Long> {
        List<Skater> findByName(String Name);
        List<Skater> findAll();
        Skater findById(long id);
        Long deleteById(long id);
    }

