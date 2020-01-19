package me.wook.springboot.movie.service;

import me.wook.springboot.movie.entity.Screen;
import me.wook.springboot.web.dto.ScreenDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScreenService {

  Page<Screen> list(final Pageable pageable);

  Screen detail(long id);

  boolean save(final long id, final ScreenDTO screenDTO);

  boolean update(long id, ScreenDTO screenDTO);

  boolean delete(long id);
}
