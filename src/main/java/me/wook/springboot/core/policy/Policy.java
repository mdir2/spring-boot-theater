package me.wook.springboot.core.policy;

public enum Policy {

  CHILD_DISCOUNT("미성년자 할인", 14, 0.1);

  private String name;
  private int condition;
  private double policy;

  Policy(final String name, final int condition, final double policy) {
    this.name = name;
    this.condition = condition;
    this.policy = policy;
  }

  public String getName() {
    return name;
  }

  public int getCondition() {
    return condition;
  }

  public double getPolicy() {
    return policy;
  }
}
