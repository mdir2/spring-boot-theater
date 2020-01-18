package me.wook.springboot.web.util;

import java.util.Optional;
import java.util.function.Function;
import me.wook.springboot.movie.exception.MovieException;
import me.wook.springboot.web.dto.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseUtils {

  private ResponseUtils() {
  }

  public static <T> ResponseEntity<T> responseEntity(T t) {
    return Optional
        .of(ResponseEntity.ok(t))
        .orElseThrow(MovieException::new);
  }

  public static ResponseVO of(final boolean result) {
    Function<Boolean, ResponseVO> function = bool -> {
      if (bool) {
        return null;
      } else {
        return ResponseVO
            .builder()
            .status(HttpStatus.OK.value())
            .message(HttpStatus.OK.getReasonPhrase())
            .build();
      }
    };
    return function.apply(result);
  }
}
