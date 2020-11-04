package com.example.postgretraining;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/skaters")
public class SkaterController {

    @Autowired
    SkaterRepository skaterRepository;


    @GetMapping
    @ResponseBody
    List<Skater> getAllSkaters() {

        return skaterRepository.findAll();
    }

    @PostMapping
    String SaveSkater(@RequestBody Skater skater) {
        skaterRepository.save(skater);

        return "Skater has been addded. His/her id is " + skater.getId();
    }

    @GetMapping("/{id}")
        Skater skater (@PathVariable long id) {
        Skater temp = skaterRepository.findById(id);

        if (temp != null){
            return temp;
        }

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("/{id}")
            String deleteSkater (@PathVariable long id){
            skaterRepository.deleteById(id);
            return "This skater has just been deleted, ID: " + id;
        }

}
