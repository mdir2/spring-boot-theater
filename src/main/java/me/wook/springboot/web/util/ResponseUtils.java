package me.wook.springboot.web.util;

import java.util.Optional;
import java.util.function.Function;
import me.wook.springboot.exception.MovieException;
import me.wook.springboot.web.dto.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseUtils {

  private ResponseUtils() {
  }

  public static <T> ResponseEntity<T> responseEntity(final T t) {
    return Optional
        .of(ResponseEntity.ok(t))
        .orElseThrow(() -> new MovieException(t.toString()));
  }

  public static ResponseVO of(final boolean result) {
    Function<Boolean, ResponseVO> function = bool -> {
      if (bool) {
        return ResponseVO.builder().build();
      } else {
        return ResponseVO
            .builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .build();
      }
    };
    return function.apply(result);
  }
}
