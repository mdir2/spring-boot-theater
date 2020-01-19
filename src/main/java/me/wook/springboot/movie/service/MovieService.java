package me.wook.springboot.movie.service;

import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.web.dto.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

  Page<Movie> list(final Pageable pageable) throws Exception;

  Movie detail(final long id);

  boolean add(final MovieDTO movieDto);

  boolean update(final long id, final MovieDTO movieDTO);

  boolean delete(final long id);
}
