package me.wook.springboot.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
