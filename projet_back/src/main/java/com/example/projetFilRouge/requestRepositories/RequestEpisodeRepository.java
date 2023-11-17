package com.example.projetFilRouge.requestRepositories;

import com.example.projetFilRouge.entities.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestEpisodeRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Episode> findAllEpisode() {
        String q = "SELECT * from episode";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Episode.class));
    }

    public List<Episode> findAllEpisodesOfSeasonByTitle(String title, int numberSeason) {
        String q = "select * from episode e where UPPER(s.name) = UPPER('" + title + "') and e.season_number = "+ numberSeason + " order by e.episode_number asc";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Episode.class));
    }
    public List<Episode> findAllEpisodesOfSeasonBySerieId(int serieId, int numberSeason) {
        String q = "select * from episode e  where e.show_id = " + serieId + " and e.season_number = "+ numberSeason + " order by e.episode_number asc";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Episode.class));
    }

}
