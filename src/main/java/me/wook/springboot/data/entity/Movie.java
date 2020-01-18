package me.wook.springboot.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Builder
@Getter
@Setter
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

  public void addScreen(Screen screen){
    this.screens.add(screen);
    if(screen.getMovie() != this){
      screen.setMovie(this);
    }
  }
}