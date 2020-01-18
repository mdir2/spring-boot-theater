package me.wook.springboot.data.factory;

import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.entity.Screen;
import me.wook.springboot.web.dto.ScreenDTO;

public final class ScreenFactory {

  private ScreenFactory() {
  }

  public static Screen screen(ScreenDTO screenDTO, Movie movie) {
    return Screen.builder()
        .id(screenDTO.getId())
        .name(screenDTO.getName())
        .movie(movie)
        .build();
  }
}
