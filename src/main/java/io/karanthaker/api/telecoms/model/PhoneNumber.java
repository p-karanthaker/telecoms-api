package io.karanthaker.api.telecoms.model;

/** Model for a phone number and it's activation status. */
public class PhoneNumber {

  /** Stores the phone number */
  private final String number;

  public PhoneNumber(String number) {
    this.number = number;
  }

  public String getNumber() {
    return this.number;
  }

  @Override
  public String toString() {
    return String.format("{ \"number\": %s }", this.number);
  }
}
