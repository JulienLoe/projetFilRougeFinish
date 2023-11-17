package com.example.projetFilRouge.services;

import com.example.projetFilRouge.entities.Episode;
import com.example.projetFilRouge.requestRepositories.RequestEpisodeRepository;
import com.example.projetFilRouge.requestRepositories.RequestMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final RequestEpisodeRepository requestEpisodeRepository;

    public ResponseEntity<List<Episode>> allEpisodesOfSeason(String title, int numberSeason) {
        try {
            List<Episode> episodes = new ArrayList<>();

            requestEpisodeRepository.findAllEpisodesOfSeasonByTitle(title, numberSeason).forEach(episodes::add);
            for (Episode episode : episodes) {
                System.out.println(episode.getName());
            }

            if (episodes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(episodes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Episode>> allEpisodesOfSeasonBySerieId(int serieId, int numberSeason) {
        try {
            List<Episode> episodes = new ArrayList<>();

            requestEpisodeRepository.findAllEpisodesOfSeasonBySerieId(serieId, numberSeason).forEach(episodes::add);
            for (Episode episode : episodes) {
                System.out.println(episode.getName());
            }

            if (episodes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(episodes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
