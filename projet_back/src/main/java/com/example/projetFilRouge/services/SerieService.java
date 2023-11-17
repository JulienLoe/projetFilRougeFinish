package com.example.projetFilRouge.services;

import com.example.projetFilRouge.entities.Serie;
import com.example.projetFilRouge.models.SerieCategory;
import com.example.projetFilRouge.requestRepositories.RequestSerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final RequestSerieRepository requestSerieRepository;

    public ResponseEntity<List<Serie>> allSeries() {
        try {
            List<Serie> series = new ArrayList<>();

            requestSerieRepository.findAllSerie().forEach(series::add);

            if (series.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<SerieCategory>> first10SeriesByCategory(int categoryId) {
        try {
            List<SerieCategory> series = new ArrayList<>();

            requestSerieRepository.findFisrt10SeriesByCategory(categoryId).forEach(series::add);
            for (SerieCategory serie : series) {
                System.out.println(serie.getName());
            }

            if (series.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<SerieCategory>> allSeriesByCategory(int categoryId) {
        try {
            List<SerieCategory> series = new ArrayList<>();

            requestSerieRepository.findAllSeriesByCategory(categoryId).forEach(series::add);
            for (SerieCategory serie : series) {
                System.out.println(serie.getName());
            }

            if (series.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    public ResponseEntity<List<Episode>> allEpisodesOfSeason(String title, int numberSeason) {
//        try {
//            List<Episode> episodes = new ArrayList<>();
//
//            requestSerieRepository.findAllEpisodesOfSeasonByTitle(title, numberSeason).forEach(episodes::add);
//            for (Episode episode : episodes) {
//                System.out.println(episode.getName());
//            }
//
//            if (episodes.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(episodes, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<List<Episode>> allEpisodesOfSeasonBySerieId(int serieId, int numberSeason) {
//        try {
//            List<Episode> episodes = new ArrayList<>();
//
//            requestSerieRepository.findAllEpisodesOfSeasonBySerieId(serieId, numberSeason).forEach(episodes::add);
//            for (Episode episode : episodes) {
//                System.out.println(episode.getName());
//            }
//
//            if (episodes.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(episodes, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
