package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Category> findAllCategory() {
        String q = "SELECT * from category";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Category.class));
    }
}
