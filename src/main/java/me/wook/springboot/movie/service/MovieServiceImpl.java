package me.wook.springboot.movie.service;

import java.util.Optional;
import me.wook.springboot.exception.MovieException;
import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.movie.factory.MovieFactory;
import me.wook.springboot.movie.repository.MovieRepository;
import me.wook.springboot.web.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  private MovieRepository movieRepository;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public Page<Movie> list(final Pageable pageable) {
    return movieRepository.findAll(pageable);
  }

  @Override
  public Movie detail(final long id) {
    return movieRepository.findById(id)
        .orElseThrow(() -> new MovieException("{id: " + id + "}"));
  }

  @Override
  public boolean add(final MovieDTO movieDto) {
    return Optional.of(movieRepository.save(MovieFactory.movie(movieDto))).isPresent();
  }

  @Override
  public boolean update(final long id, final MovieDTO movieDTO) {
    movieRepository.findById(id).ifPresent(movie -> {
      movie = MovieFactory.movie(id, movieDTO);
      Optional.of(movieRepository.save(movie))
          .orElseThrow(() -> new MovieException(movieDTO));
    });
    return movieRepository.findById(id).isPresent();
  }

  @Override
  public boolean delete(final long id) {
    movieRepository.findById(id).ifPresent(movie -> {
      movie.setId(id);
      movieRepository.delete(movie);
    });
    return movieRepository.findById(id).isPresent() == false;
  }
}