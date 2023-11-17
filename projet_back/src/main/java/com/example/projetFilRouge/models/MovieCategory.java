package com.example.projetFilRouge.models;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MovieCategory {

    private int Id;

    private boolean adult;

    private String backdrop_path;

    private String genre_ids;

    private int idDb;

    private String original_language;

    private String original_title;

    private String overview;

    private double popularity;

    private String poster_path;

    private String release_date;

    private String title;

    private boolean video;
    private double vote_average;
    private int vote_count;
    private int genre1;
    private int genre2;
    private int genre3;
    private int genre4;
    private int genre5;
    private int genre6;

    private String name;
}
