package me.wook.springboot.data.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Screen {

  @Id
  @GeneratedValue
  private long id;
  @Column
  private String name;

  @ManyToOne
  private Movie movie;

  @ManyToMany
  private List<Seat> seats;
}
