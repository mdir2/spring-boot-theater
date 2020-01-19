package me.wook.springboot.movie.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.web.dto.MovieDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MovieFactory {

  public static Movie movie(final long id, final MovieDTO movieDTO) {
    return Movie.builder()
        .id(id)
        .name(movieDTO.getName())
        .description(movieDTO.getDescription())
        .build();
  }

  public static Movie movie(final MovieDTO movieDTO) {
    return Movie.builder()
        .name(movieDTO.getName())
        .description(movieDTO.getDescription())
        .build();
  }
}
