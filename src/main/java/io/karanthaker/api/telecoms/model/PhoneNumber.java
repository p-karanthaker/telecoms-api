package io.karanthaker.api.telecoms.model;

/** Model for a phone number and it's activation status. */
public class PhoneNumber {

  /** Stores the phone number */
  private final String number;

  /** Activation status */
  private boolean activated;

  /**
   * Constructs a PhoneNumber object and sets activation status
   * to false;
   * @param number the phone number
   */
  public PhoneNumber(String number) {
    this.number = number;
    this.activated = false;
  }

  /**
   * Returns the phone number.
   * @return the phone number.
   */
  public String getNumber() {
    return this.number;
  }

  /**
   * Checks activation status of the phone number.
   * @return activation status.
   */
  public boolean activated() {
    return activated;
  }

  /** Activate the phone number (set to true) */
  public void activate() {
    this.activated = true;
  }

  /**
   * Prints the PhoneNumber object as a JSON Object.
   * @return JSON representation of this object.
   */
  @Override
  public String toString() {
    return String.format("{ \"number\": %s }", this.number);
  }
}
