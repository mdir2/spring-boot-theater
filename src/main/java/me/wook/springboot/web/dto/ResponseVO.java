package me.wook.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {

  @Builder.Default
  private int status = 200;
  @Builder.Default
  private String message = "Success";
}