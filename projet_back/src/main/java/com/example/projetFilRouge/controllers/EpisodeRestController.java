package com.example.projetFilRouge.controllers;

import com.example.projetFilRouge.entities.Episode;
import com.example.projetFilRouge.services.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EpisodeRestController {

    private final EpisodeService episodeService;

    @GetMapping("/seriesEpisodes/{title}/saison{numberSeason}")
    public ResponseEntity<List<Episode>> getAllEpisodesOfSeasonByTitle(@PathVariable("title") String title, @PathVariable("numberSeason") int numberSeason) {
        return episodeService.allEpisodesOfSeason(title, numberSeason);
    }

    @GetMapping("/seriesEpisodesById/{serieId}/saison{numberSeason}")
    public ResponseEntity<List<Episode>> getAllEpisodesOfSeasonBySerieId(@PathVariable("serieId") int serieId, @PathVariable("numberSeason") int numberSeason) {
        return episodeService.allEpisodesOfSeasonBySerieId(serieId, numberSeason);
    }
}
