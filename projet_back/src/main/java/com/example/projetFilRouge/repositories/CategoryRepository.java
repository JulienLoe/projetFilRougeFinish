package com.example.projetFilRouge.repositories;

import com.example.projetFilRouge.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
