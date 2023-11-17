package com.example.projetFilRouge.controllers;


import com.example.projetFilRouge.entities.*;
import com.example.projetFilRouge.helper.MovieHelper;
import com.example.projetFilRouge.models.MovieCategory;
import com.example.projetFilRouge.repositories.TutorialRepository;
import com.example.projetFilRouge.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/api")
    @RequiredArgsConstructor
    public class MovieController {

    @Autowired
    TutorialRepository tutorialRepository;


    @Autowired
    MovieService movieService;

    private final MovieHelper movieHelper;

        @GetMapping("/movies")
        public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {
            return movieService.allMoviesByTitle(title);

//            try {
//                List<Movie> movies = new ArrayList<>();
//
////                if (title == null)
////                    tutorialRepository.findAll().forEach(tutorials::add);
//
//                    requestRepository.findByTitleContaining(title).forEach(movies::add);
//
//                if (movies.isEmpty()) {
//                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//                }
//
//                return new ResponseEntity<>(movies, HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//            }

        }

        @GetMapping("/movie")
        public ResponseEntity<List<Movie>> getAllMovie() {
            return movieService.allMovies();
        }


    @GetMapping("/moviesFirst10ByCategory/{categoryId}")
    public ResponseEntity<List<MovieCategory>> getFirst10MoviesByCategory(@PathVariable("categoryId") int categoryId) {
           return movieService.first10MoviesByCategory(categoryId);
    }

    @GetMapping("/moviesByCategory/{categoryId}")
    public ResponseEntity<List<MovieCategory>> getAllMoviesByCategory(@PathVariable("categoryId") int categoryId) {
            return movieService.allMoviesByCategory(categoryId);
    }

}
