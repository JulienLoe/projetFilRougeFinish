package com.example.projetFilRouge.services;

import com.example.projetFilRouge.entities.Category;
import com.example.projetFilRouge.requestRepositories.RequestCastRepository;
import com.example.projetFilRouge.requestRepositories.RequestCategoryRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final RequestCategoryRepository requestCategoryRepository;

    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories = new ArrayList<>();

            requestCategoryRepository.findAllCategory().forEach(categories::add);

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
