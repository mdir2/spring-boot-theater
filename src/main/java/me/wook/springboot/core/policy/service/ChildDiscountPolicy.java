package me.wook.springboot.core.policy.service;

import me.wook.springboot.core.model.Audience;
import me.wook.springboot.core.policy.DiscountPolicy;

public class ChildDiscountPolicy implements DiscountPolicy {

  Audience audience;

  ChildDiscountPolicy(Audience audience) {
    this.audience = audience;
  }

  @Override
  public double discount() {
    return 0;
  }
}
