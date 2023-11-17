package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Season;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestSeasonRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Season> findAllSeason() {
        String q = "SELECT * from season";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Season.class));
    }
}
