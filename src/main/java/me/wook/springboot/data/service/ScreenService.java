package me.wook.springboot.data.service;

import me.wook.springboot.data.entity.Screen;
import me.wook.springboot.web.dto.ScreenDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScreenService {

  Page<Screen> list(final Pageable pageable);

  boolean save(final long id, final ScreenDTO screenDTO);
}
