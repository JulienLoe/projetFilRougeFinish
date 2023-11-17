package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Movie;
import com.example.projetFilRouge.models.MovieCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestMovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Movie> findByTitleContaining(String title) {
        String q = "SELECT * from movie WHERE title ILIKE '%" + title + "%'";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public List<Movie> findAllMovies() {
        String q = "SELECT * from movie";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public List<MovieCategory> findAllMoviesByCategory(int categoryId) {
        String q = "select distinct m.*, c.name FROM movie m JOIN category c ON c.id_db = " + categoryId + " AND (m.genre1 = " + categoryId + " OR m.genre2 = "+ categoryId + " OR m.genre3 = "+ categoryId + " OR m.genre4 = "+ categoryId + " OR m.genre5 = "+ categoryId + " OR m.genre6 = "+ categoryId + ") ORDER BY m.release_date DESC";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(MovieCategory.class));
    }


    public List<MovieCategory> findFirst10MoviesByCategory(int categoryId) {
        String q = "select distinct m.*, c.name FROM movie m JOIN category c ON c.id_db = " + categoryId + " AND (m.genre1 = " + categoryId + " OR m.genre2 = "+ categoryId + " OR m.genre3 = "+ categoryId + " OR m.genre4 = "+ categoryId + " OR m.genre5 = "+ categoryId + " OR m.genre6 = "+ categoryId + ") ORDER BY m.release_date DESC LIMIT 10";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(MovieCategory.class));
    }

}
