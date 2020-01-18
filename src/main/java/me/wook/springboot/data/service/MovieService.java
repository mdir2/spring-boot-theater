package me.wook.springboot.data.service;

import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.web.dto.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

  Page<Movie> list(final Pageable pageable) throws Exception;

  Movie detail(final MovieDTO movieDTO);

  boolean add(final MovieDTO movieDto);

  boolean update(final MovieDTO movieDTO);

  boolean delete(final MovieDTO movieDTO);
}
