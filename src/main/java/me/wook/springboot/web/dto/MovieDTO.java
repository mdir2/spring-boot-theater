package me.wook.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.wook.springboot.data.entity.Movie;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieDTO {

  private long id;
  private String name;
  private String description;

  public Movie movie() {
    return Movie.builder()
        .id(id)
        .name(name)
        .description(description)
        .build();
  }
}