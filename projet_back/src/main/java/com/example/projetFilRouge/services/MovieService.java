package com.example.projetFilRouge.services;

import com.example.projetFilRouge.entities.Movie;
import com.example.projetFilRouge.models.MovieCategory;
import com.example.projetFilRouge.requestRepositories.RequestMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {


    private final RequestMovieRepository requestMovieRepository;

    public ResponseEntity<List<Movie>> allMoviesByTitle(String title) {
        try {
            List<Movie> movies = new ArrayList<>();

//                if (title == null)
//                    tutorialRepository.findAll().forEach(tutorials::add);

            requestMovieRepository.findByTitleContaining(title).forEach(movies::add);

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Movie>> allMovies() {
        try {
            List<Movie> movies = new ArrayList<>();

            requestMovieRepository.findAllMovies().forEach(movies::add);

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<MovieCategory>> first10MoviesByCategory(int categoryId) {
        try {
            List<MovieCategory> movies = new ArrayList<>();


            requestMovieRepository.findFirst10MoviesByCategory(categoryId).forEach(movies::add);
            for (MovieCategory movie : movies) {
                System.out.println(movie.getTitle());
            }

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<MovieCategory>> allMoviesByCategory(int categoryId) {
        try {
            List<MovieCategory> movies = new ArrayList<>();


            requestMovieRepository.findAllMoviesByCategory(categoryId).forEach(movies::add);
            for (MovieCategory movie : movies) {
                System.out.println(movie.getTitle());
            }

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
