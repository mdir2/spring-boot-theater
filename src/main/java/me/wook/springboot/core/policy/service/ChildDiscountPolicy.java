package me.wook.springboot.core.policy.service;

import me.wook.springboot.core.model.Audience;
import me.wook.springboot.core.model.Movie;
import me.wook.springboot.core.policy.DiscountPolicy;
import me.wook.springboot.core.policy.Policy;

public class ChildDiscountPolicy implements DiscountPolicy {

  Movie movie;
  Audience audience;

  ChildDiscountPolicy(final Movie movie, final Audience audience) {
    this.movie = movie;
    this.audience = audience;
  }

  @Override
  public double discount() {
    final int fee = movie.getFee();
    final int condition = Policy.CHILD_DISCOUNT.getCondition();
    final double policy = Policy.CHILD_DISCOUNT.getPolicy();

    return audience.getAge() <= condition ? fee - (fee * policy) : fee;
  }
}
