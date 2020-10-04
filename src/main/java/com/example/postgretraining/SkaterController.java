package com.example.postgretraining;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    String SaveSkater(@RequestBody Skater skater) {
        skaterRepository.save(skater);

        return "Skater has been addded. His/her id is " + skater.getId();
    }

    @GetMapping("/{id}")
        Skater skater (@PathVariable long id){
            return skaterRepository.findById(id);
        }

}
