package me.wook.springboot.web.api.handler;

import me.wook.springboot.web.dto.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ResponseVO> exception(Exception e) {
    return new ResponseEntity(ResponseVO.builder()
        .status(HttpStatus.BAD_GATEWAY.value())
        .message(HttpStatus.BAD_GATEWAY.getReasonPhrase()).build(), HttpStatus.BAD_REQUEST);
  }
}