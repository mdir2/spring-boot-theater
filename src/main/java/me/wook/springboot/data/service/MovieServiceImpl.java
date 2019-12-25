package me.wook.springboot.data.service;

import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.repository.MovieRepository;
import me.wook.springboot.web.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Override
    public Page<Movie> list(final Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    
    @Override
    public boolean add(final MovieDto movieDto) {
        return movieRepository.save(movieDto.movie()) != null;
    }
}
