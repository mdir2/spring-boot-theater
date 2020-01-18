package me.wook.springboot.movie.exception;

public class ScreenException extends RuntimeException {

  public ScreenException() {
    super("ScreenException");
  }

  public ScreenException(String message) {
    super(String.format("ScreenException -> %s", message));
  }

  public <T> ScreenException(String message, T t) {
    super(String.format("ScreenException -> %s, %s", message, t.toString()));
  }
}
