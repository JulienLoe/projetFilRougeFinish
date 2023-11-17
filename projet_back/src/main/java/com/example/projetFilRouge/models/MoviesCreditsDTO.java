package com.example.projetFilRouge.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class MoviesCreditsDTO {



        public int Id;

        public String adult;

        public String belongs_to_collection;
        public Long budget;

        public String genres;

        public String homepage;


        public int id;



        public String imdb_id;

        public String original_language;

        public String original_title;

        public String overview;

        public String popularity;

        public String poster_path;

        public String production_companies;

        public String production_countries;

        public String release_date;
        public Long revenue;

        public String runtime;

        public String spoken_languages;

        public String status;

        public String tagline;

        public String title;

        public String video;

        public String vote_average;
        public Long vote_count;


        public Credits credits;

        public String crew;



        public MoviesCreditsDTO(int Id, String adult, String belongs_to_collection, long budget, String genres, String homepage, int id, String imdb_id, String original_language, String original_title, String overview, String poster_path, String production_companies,String production_countries, String popularity, String release_date, long revenue, String runtime, String spoken_languages, String status, String tagline, String title, String video, String vote_average, long vote_count, String crew) {
            this.Id = Id;
            this.adult = adult;
            this.belongs_to_collection = belongs_to_collection;
            this.budget = budget;
            this.genres = genres;
            this.homepage = homepage;
            this.id = id;
            this.imdb_id = imdb_id;
            this.original_language = original_language;
            this.original_title = original_title;
            this.overview = overview;
            this.popularity = popularity;
            this.poster_path = poster_path;
            this.production_companies = production_companies;
            this.production_countries = production_countries;
            this.release_date = release_date;
            this.revenue = revenue;
            this.runtime = runtime;
            this.spoken_languages = spoken_languages;
            this.status = status;
            this.tagline = tagline;
            this.title = title;
            this.video = video;
            this.vote_average = vote_average;
            this.vote_count = vote_count;
            this.crew = crew;

        }

        public MoviesCreditsDTO() {

        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getImdb_id() {
            return imdb_id;
        }

        public void setImdb_id(String imdb_id) {
            this.imdb_id = imdb_id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getProduction_companies() {
            return production_companies;
        }

        public void setProduction_companies(String production_companies) {
            this.production_companies = production_companies;
        }

        public String getProduction_countries() {
            return production_countries;
        }

        public void setProduction_countries(String production_countries) {
            this.production_countries = production_countries;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public Long getRevenue() {
            return revenue;
        }

        public void setRevenue(Long revenue) {
            this.revenue = revenue;
        }

        public String getRuntime() {
            return runtime;
        }

        public void setRuntime(String runtime) {
            this.runtime = runtime;
        }

        public String getSpoken_languages() {
            return spoken_languages;
        }

        public void setSpoken_languages(String spoken_languages) {
            this.spoken_languages = spoken_languages;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVote_average() {
            return vote_average;
        }

        public void setVote_average(String vote_average) {
            this.vote_average = vote_average;
        }

        public Long getVote_count() {
            return vote_count;
        }

        public void setVote_count(Long vote_count) {
            this.vote_count = vote_count;
        }

        public Credits getCredits() {
            return credits;
        }

        public void setCredits(Credits credits) {
            this.credits = credits;
        }

        public String getAdult() {
            return adult;
        }

        public void setAdult(String adult) {
            this.adult = adult;
        }

        public String getBelongs_to_collection() {
            return belongs_to_collection;
        }

        public void setBelongs_to_collection(String belongs_to_collection) {
            this.belongs_to_collection = belongs_to_collection;
        }

        public Long getBudget() {
            return budget;
        }

        public void setBudget(Long budget) {
            this.budget = budget;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }
}
