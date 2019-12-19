package me.wook.springboot.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

    @OneToMany
    private List<Screen> screens = new ArrayList<>();

}


