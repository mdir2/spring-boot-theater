package me.wook.springboot.data.service;

import java.util.Optional;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.repository.MovieRepository;
import me.wook.springboot.web.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("movieService")
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
  public boolean add(final MovieDTO movieDto) {
    return Optional.of(movieRepository.save(movieDto.movie())).isPresent();
  }
}
