package com.app.moviecom.controller;

import com.app.moviecom.models.Movie;
import com.app.moviecom.services.MovieService;
import info.movito.themoviedbapi.tools.TmdbException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getMovie(Model model) {
        List<Movie> movies=movieService.getAllMovies();
        movies.sort(Comparator.comparing(Movie::getRating).reversed());
        model.addAttribute("movies",movies);
        return "index";
    }

    @PostMapping
    public String addMovie(@RequestParam String title,String comment,int rating) {
        movieService.addMovie(title,comment,rating);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/";
    }


}
