package com.example.projetFilRouge.controllers;

import com.example.projetFilRouge.entities.Serie;
import com.example.projetFilRouge.models.SerieCategory;
import com.example.projetFilRouge.services.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SerieRestController {

    private final SerieService serieService;

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> getAllSeries() {
        return serieService.allSeries();
    }

    @GetMapping("/series/First10ByCategory/{categoryId}")
    public ResponseEntity<List<SerieCategory>> getFirst10SeriesByCategory(@PathVariable("categoryId") int categoryId) {
        return serieService.first10SeriesByCategory(categoryId);
    }

    @GetMapping("/seriesByCategory/{categoryId}")
    public ResponseEntity<List<SerieCategory>> getAllSeriesByCategory(@PathVariable("categoryId") int categoryId) {
        return serieService.allSeriesByCategory(categoryId);
    }

//    @GetMapping("/seriesEpisodes/{title}/saison{numberSeason}")
//    public ResponseEntity<List<Episode>> getAllEpisodesOfSeasonByTitle(@PathVariable("title") String title, @PathVariable("numberSeason") int numberSeason) {
//        return serieService.allEpisodesOfSeason(title, numberSeason);
//    }
//
//    @GetMapping("/seriesEpisodesById/{serieId}/saison{numberSeason}")
//    public ResponseEntity<List<Episode>> getAllEpisodesOfSeasonBySerieId(@PathVariable("serieId") int serieId, @PathVariable("numberSeason") int numberSeason) {
//        return serieService.allEpisodesOfSeasonBySerieId(serieId, numberSeason);
//    }
}
