package me.wook.springboot.core.model;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

  private String name;
  private String description;
  private int fee;

  private Director director;
  private Collection<Actor> actors;
  private Collection<Screen> screens;
}
