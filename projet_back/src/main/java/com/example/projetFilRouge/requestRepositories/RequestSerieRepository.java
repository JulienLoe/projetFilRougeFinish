package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Serie;
import com.example.projetFilRouge.models.SerieCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestSerieRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Serie> findAllSerie() {
        String q = "SELECT * from serie";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Serie.class));
    }

    public List<SerieCategory> findAllSeriesByCategory(int categoryId) {
        String q = "select distinct s.*, c.name as categoryName FROM serie s JOIN category c ON c.id_db = " + categoryId + " AND (s.genre1 = " + categoryId + " OR s.genre2 = "+ categoryId + " OR s.genre3 = "+ categoryId + " OR s.genre4 = "+ categoryId + " OR s.genre5 = "+ categoryId + " OR s.genre6 = "+ categoryId + ") ORDER BY s.first_air_date DESC";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(SerieCategory.class));
    }

    public List<SerieCategory> findFisrt10SeriesByCategory(int categoryId) {
        String q = "select distinct s.*, c.name as categoryName FROM serie s JOIN category c ON c.id_db = " + categoryId + " AND (s.genre1 = " + categoryId + " OR s.genre2 = "+ categoryId + " OR s.genre3 = "+ categoryId + " OR s.genre4 = "+ categoryId + " OR s.genre5 = "+ categoryId + " OR s.genre6 = "+ categoryId + ") ORDER BY s.first_air_date DESC LIMIT 3";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(SerieCategory.class));
    }
}
