package me.wook.springboot.data.service;

import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.web.model.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Page<Movie> list(final Pageable pageable) throws Exception;
    
    boolean add(final MovieDTO movieDto);
}
