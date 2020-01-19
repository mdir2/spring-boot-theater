package me.wook.springboot.movie.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.movie.entity.Screen;
import me.wook.springboot.web.dto.ScreenDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenFactory {

  public static Screen screen(ScreenDTO screenDTO, Movie movie) {
    return Screen.builder()
        .name(screenDTO.getName())
        .movie(movie)
        .build();
  }
}
