package me.wook.springboot.movie.service;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.when;

import me.wook.springboot.movie.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("영화 예약")
class ReserveManagerTest {

  @Autowired
  private MovieService movieService;

  @Test
  @DisplayName("영화 예약하기")
  void reserve() throws Exception {
    /*
     예약 순서
     1. 영화 정보를 불러온다
     2. 해당영화의 상영정보를 불러온다.
     3. 해당 상영관의 좌석정보를 불러온다. (! 예약 된 좌석은 제외)
     4. 예약한다.
       4.1. 예약정보
         4.1.1. 영화아이디
         4.1.2. 스크린아이디
         4.1.3. 좌석번호
         (세가지가 PK 여야 함.)
    */

    // 영화 정보
    final Movie movie = movieService.list(PageRequest.of(0, 10)).getContent().get(0);

    // 상영관 정보 목록
//    final List<Screen> screens = movie.getScreens()
//        .stream()
//        .collect(Collectors.toList());

    // 상영관 선택
//    final Screen screen = screens
//        .stream()
//        .filter(s -> s.getId() == 1)
//        .findFirst().orElseThrow(Exception::new);

    // 좌석 정보
//    final Seat seat = screen.getSeats()
//        .stream()
//        .filter(s -> s.equals("H01"))
//        .findFirst().orElseThrow(Exception::new);

    // 예약 정보 등록
    // boolean isSuccess = reserveManger.reserve();

    // then(isSuccess).isEqualTo(true);
    then(movie).isNotNull();
  }
}