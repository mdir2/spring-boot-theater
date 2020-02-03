package me.wook.springboot.web.api.controller;

import static org.assertj.core.api.BDDAssertions.then;

import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.movie.service.MovieService;
import me.wook.springboot.web.dto.MovieDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("영화 정보 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieControllerTest {

  @Autowired
  private MovieService movieService;

  @Test
  @Order(1)
  @DisplayName("영화 정보 목록 조회")
  void list() throws Exception {
    // given
    final Page<Movie> movies = movieService.list(PageRequest.of(0, 10));

    // when
    then(movies).isNotEmpty();
  }

  @Test
  @Order(2)
  @DisplayName("영화 정보 상세 조회")
  void detail() throws Exception {
    // given
    final long id = movieService.list(PageRequest.of(0, 1)).getContent().get(0).getId();
    final Movie movie = movieService.detail(id);

    // when
    then(movie).isNotNull();
  }

  @Test
  @Order(0)
  @DisplayName("영화 정보 등록")
  void add() {
    // given
    final MovieDTO movieDTO = MovieDTO
        .builder()
        .name("The Avengers")
        .description("This is super hero movie")
        .build();

    // when
    boolean isSuccess = movieService.add(movieDTO);

    // then
    then(isSuccess).isEqualTo(true);
  }

  @Test
  @Order(3)
  @DisplayName("영화 정보 수정")
  void update() throws Exception {
    // given
    final long id = movieService.list(PageRequest.of(0, 1)).getContent().get(0).getId();
    final MovieDTO movieDTO = MovieDTO
        .builder()
        .name("The Avengers 2")
        .description("This is latest version of the avengers")
        .build();

    boolean isSuccess = movieService.update(id, movieDTO);

    // then
    then(isSuccess).isEqualTo(true);
  }

  @Test
  @Order(4)
  @DisplayName("영화 정보 삭제")
  void delete() throws Exception {
    // given
    final long id = movieService.list(PageRequest.of(0, 1)).getContent().get(0).getId();
    boolean isSuccess = movieService.delete(id);

    // then
    then(isSuccess).isEqualTo(true);
  }
}