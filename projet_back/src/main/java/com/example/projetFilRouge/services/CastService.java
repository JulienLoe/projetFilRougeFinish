package com.example.projetFilRouge.services;

import com.example.projetFilRouge.entities.Cast;
import com.example.projetFilRouge.requestRepositories.RequestCastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CastService {

    private final RequestCastRepository requestCastRepository;


    public ResponseEntity<List<Cast>> getAllCast()  {
        try {
            List<Cast> cast = new ArrayList<>();

            requestCastRepository.findAllCast().forEach(cast::add);

            if (cast.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cast, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Cast>> getFirst5CastById(int movieIdOrSerieId) {
        try {
            List<Cast> casts = new ArrayList<>();

            requestCastRepository.findFirst5CastById(movieIdOrSerieId).forEach(casts::add);

            if (casts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(casts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


