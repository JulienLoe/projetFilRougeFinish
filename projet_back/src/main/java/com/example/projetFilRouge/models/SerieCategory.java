package com.example.projetFilRouge.models;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SerieCategory {

    private int id;

    private String backdrop_path;

    private String first_air_date;

    private String genre_ids;

    private int idDb;

    private String name;

    private String origin_country;

    private String original_language;

    private String original_name;


    private String overview;

    private double popularity;


    private String poster_path;


    private double vote_average;
    private int vote_count;

    private int nbr_seasons;
    private int nbr_episodes;
    private int page;
    private int genre1;
    private int genre2;
    private int genre3;
    private int genre4;
    private int genre5;
    private int genre6;

    private String categoryName;
}
