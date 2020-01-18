package me.wook.springboot.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

    @ManyToMany
    private List<Screen> screens = new ArrayList<>();
}
