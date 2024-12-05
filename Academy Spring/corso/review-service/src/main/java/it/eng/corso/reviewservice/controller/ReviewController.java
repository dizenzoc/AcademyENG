package it.eng.corso.reviewservice.controller;

import it.eng.corso.reviewservice.dto.ReviewDTO;
import it.eng.corso.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewDTO save( @RequestBody ReviewDTO review ){
        return reviewService.save( review );
    }

    @GetMapping
    public List<ReviewDTO> findAll( ){
        return reviewService.findAll();
    }

    @GetMapping("/{bookUuid}")
    public List<ReviewDTO> findByBookUuid( @PathVariable String bookUuid ){
        return reviewService.findByBookUuid( bookUuid );
    }

    @GetMapping("/average")
    public Double average(@RequestParam String uuidBook){
        return reviewService.average(uuidBook);
    }

    @PutMapping("/{uuid}")
    public ReviewDTO update( @PathVariable String uuid, @RequestBody ReviewDTO review ){
        return reviewService.update(uuid, review );
    }

    @DeleteMapping("/{uuid}")
    public void delete( @PathVariable String uuid ){
        reviewService.delete( uuid );
    }
}
