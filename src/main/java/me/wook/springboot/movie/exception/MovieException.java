package me.wook.springboot.movie.exception;

public class MovieException extends RuntimeException {

  public MovieException() {
    super("MovieException");
  }

  public MovieException(String msg) {
    super(String.format("MovieException -> %s", msg));
  }

  public <T> MovieException(String msg, T t) {
    super(String.format("MovieException -> %s, %s", msg, t.toString()));
  }
}
