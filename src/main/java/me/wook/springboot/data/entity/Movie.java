package me.wook.springboot.data.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @OneToMany
  private List<Screen> screens = new ArrayList<>();

}