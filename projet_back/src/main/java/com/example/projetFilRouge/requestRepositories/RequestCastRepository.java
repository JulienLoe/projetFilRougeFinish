package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Cast;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestCastRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Cast> findAllCast() {
        String q = "SELECT * from casting";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Cast.class));
    }

//    public List<Cast> findFirst5CastByMovieId(int movieId) {
//        String q = "select * from casting c where c.movie_id = "+ movieId + " order by c.rang asc limit 5 ";
//        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Cast.class));
//    }

    public List<Cast> findFirst5CastById(int movieIdOrSerieId) {
        String q = "select * from casting c where c.movie_id = "+ movieIdOrSerieId + " order by c.rang asc limit 5 ";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Cast.class));
    }

}
