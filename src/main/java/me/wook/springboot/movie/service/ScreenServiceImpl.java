package me.wook.springboot.movie.service;

import java.util.Optional;
import me.wook.springboot.exception.MovieException;
import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.movie.entity.Screen;
import me.wook.springboot.movie.factory.ScreenFactory;
import me.wook.springboot.movie.repository.ScreenRepository;
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
  public Screen detail(long id) {
    return screenRepository.findById(id).orElseThrow(() -> new MovieException(id));
  }

  @Override
  public boolean save(long id, ScreenDTO screenDTO) {
    Movie movie = movieService.detail(id);
    return Optional.of(screenRepository.save(ScreenFactory.screen(screenDTO, movie))).isPresent();
  }

  @Override
  public boolean update(long id, ScreenDTO screenDTO) {
    screenRepository.findById(id).ifPresent(screen -> {
      screen.setName(screenDTO.getName());
      screenRepository.save(screen);
    });
    return screenRepository.findById(id).isPresent();
  }

  @Override
  public boolean delete(long id) {
    screenRepository.findById(id).ifPresent(screen -> {
      screenRepository.delete(screen);
    });
    return screenRepository.findById(id).isPresent() == false;
  }
}
