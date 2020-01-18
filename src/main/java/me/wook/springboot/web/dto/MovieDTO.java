package me.wook.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.wook.springboot.data.entity.Movie;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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