package me.wook.springboot.data.service;

import java.util.Optional;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.repository.MovieRepository;
import me.wook.springboot.movie.exception.MovieException;
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
  public Movie detail(MovieDTO movieDTO) {
    return movieRepository.findById(movieDTO.movie().getId()).orElseThrow(MovieException::new);
  }

  @Override
  public boolean add(final MovieDTO movieDto) {
    return Optional.of(movieRepository.save(movieDto.movie())).isPresent();
  }

  @Override
  public boolean update(MovieDTO movieDTO) {
    movieRepository.findById(movieDTO.getId()).ifPresent(movie -> {
      movie = movieDTO.movie();
      Optional.of(movieRepository.save(movie)).orElseThrow(MovieException::new);
    });
    return movieRepository.findById(movieDTO.getId()).isPresent();
  }

  @Override
  public boolean delete(MovieDTO movieDTO) {
    movieRepository.findById(movieDTO.getId()).ifPresent(movie -> {
      movieRepository.delete(movieDTO.movie());
    });
    return movieRepository.findById(movieDTO.getId()).isPresent();
  }
}
