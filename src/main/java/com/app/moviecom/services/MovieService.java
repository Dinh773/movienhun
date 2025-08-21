package com.app.moviecom.services;

import com.app.moviecom.models.Movie;
import com.app.moviecom.repository.MovieRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.tools.TmdbException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    public final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(String title, String comment, int rating) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setComment(comment);
        movie.setRating(rating);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
