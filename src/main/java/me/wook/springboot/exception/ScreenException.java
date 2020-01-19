package me.wook.springboot.exception;

public class ScreenException extends RuntimeException {

  public ScreenException() {
    super("ScreenException");
  }

  public <T> ScreenException(final T t) {
    super(String.format("ScreenException -> %s", t));
  }
}
