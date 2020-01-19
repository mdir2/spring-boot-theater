package me.wook.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.wook.springboot.movie.entity.Movie;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

  private String name;
  private String description;
}