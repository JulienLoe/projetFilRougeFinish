package com.example.projetFilRouge.controllers;
import com.example.projetFilRouge.entities.Cast;
import com.example.projetFilRouge.services.CastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CastRestController {

    private final CastService castService;


    @GetMapping("/cast")
    public ResponseEntity<List<Cast>> getAllCast() {
        return castService.getAllCast();
    }

    @GetMapping("/castingById/{movieIdOrSerieId}")
    public ResponseEntity<List<Cast>> getFisrt5CastById(@PathVariable("movieIdOrSerieId") int movieIdOrSerieId) {
        return castService.getFirst5CastById(movieIdOrSerieId);
    }

//    @GetMapping("/castingBySerieId/{serieId}")
//    public ResponseEntity<List<Cast>> getFisrt5CastBySerieId(@PathVariable("serieId") int serieId) {
//        return castService.getFirst5CastBySerieId(serieId);
//    }
}
