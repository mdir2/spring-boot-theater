package me.wook.springboot.web.dto;

import lombok.*;
import me.wook.springboot.data.entity.Movie;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieDTO {
    private long id;
    private String name;

    public Movie movie() {
        return Movie.builder()
                .id(id)
                .name(name)
                .build();
    }

    public Movie movie(MovieDTO movieDto) {
        return Movie.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .build();
    }
}
