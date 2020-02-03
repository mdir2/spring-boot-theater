package me.wook.springboot.movie.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@JsonIdentityInfo(property = "@screen", generator = ObjectIdGenerators.UUIDGenerator.class)
public class Screen {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String name;

  @ManyToOne
  private Movie movie;

  @OneToMany
  private Collection<Seat> seats;
}
