package me.wook.springboot.exception;

public class MovieException extends RuntimeException {

  public MovieException() {
    super("MovieException");
  }

  public <T> MovieException(final T t) {
    super(String.format("MovieException -> %s", t));
  }
}
