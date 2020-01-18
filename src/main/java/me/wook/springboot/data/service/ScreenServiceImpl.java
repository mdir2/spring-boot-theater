package me.wook.springboot.data.service;

import java.util.Optional;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.entity.Screen;
import me.wook.springboot.data.factory.ScreenFactory;
import me.wook.springboot.data.repository.ScreenRepository;
import me.wook.springboot.web.dto.MovieDTO;
import me.wook.springboot.web.dto.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {

  private ScreenRepository screenRepository;

  private MovieService movieService;

  @Autowired
  public ScreenServiceImpl(ScreenRepository screenRepository, MovieService movieService) {
    this.screenRepository = screenRepository;
    this.movieService = movieService;
  }

  @Override
  public Page<Screen> list(Pageable pageable) {
    return screenRepository.findAll(pageable);
  }

  @Override
  public boolean save(long id, ScreenDTO screenDTO) {
    Movie movie = movieService.detail(MovieDTO.builder().id(id).build());
    return Optional.of(screenRepository.save(ScreenFactory.screen(screenDTO, movie))).isPresent();
  }
}
