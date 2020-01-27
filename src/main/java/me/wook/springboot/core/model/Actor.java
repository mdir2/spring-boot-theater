package me.wook.springboot.core.model;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

  private String name;
  private int age;
  private String hometown;
  private Collection<String> masterpiece;
}
