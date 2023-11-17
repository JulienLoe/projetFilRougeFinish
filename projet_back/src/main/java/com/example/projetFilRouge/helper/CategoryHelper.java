package com.example.projetFilRouge.helper;

import com.example.projetFilRouge.entities.Category;
import com.example.projetFilRouge.repositories.CategoryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class CategoryHelper {

    private final CategoryRepository categoryRepository;
    public void getAllCategoryMovies(String movieOrTv) throws IOException, InterruptedException {

        // Accéder aux catégories des films = movie ou des series = tv
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/genre/" + movieOrTv + "/list?language=fr"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYTc5ZDI1OWFjNWZhYTM4ZTcwNDdkYjlkMWEzYWNjYiIsInN1YiI6IjY1MzZkMDM4OTQ2MzE4MDBhZDk0MDA1NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.6f5J39O2-Irt0iTC4TDXsiEdCTChCARLF7yvx-72_rE")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response.body());

        // Accéder aux résultats
        JsonNode genres = jsonResponse.get("genres");

        for (JsonNode genre: genres) {
            Category category = new Category();

            category.setIdDb( genre.get("id").asInt());
            category.setName(genre.get("name").asText());

            if(movieOrTv.equals("tv")) {
                category.setOfSerie(true);
            }

            categoryRepository.save(category);

            System.out.println(category.getIdDb());
            System.out.println(category.getName());
        }
    }

}
