package me.wook.springboot.movie.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String name;

  @Column
  private String description;

  @OneToMany(mappedBy = "movie")
  private Collection<Screen> screens;
}