package com.example.projetFilRouge.controllers;

import com.example.projetFilRouge.entities.Category;
import com.example.projetFilRouge.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
