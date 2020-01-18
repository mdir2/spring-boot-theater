package me.wook.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ResponseVO {

  @Builder.Default
  private int status = 200;
  @Builder.Default
  private String message = "";
}