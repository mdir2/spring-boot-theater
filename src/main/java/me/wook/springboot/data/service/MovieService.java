package me.wook.springboot.data.service;

import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.web.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Page<Movie> list(final Pageable pageable);
    
    boolean add(final MovieDto movieDto);
}
