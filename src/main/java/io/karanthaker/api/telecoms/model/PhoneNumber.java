package io.karanthaker.api.telecoms.model;

import java.util.Objects;

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
    return String.format("{ \"number\": %s, \"activated\": %b }", this.number, this.activated);
  }

  /**
   * Overridden equals to compare objects using the number field.
   * @param obj the object to compare to.
   * @return true if objects are the same, and true if number fields are the same.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof PhoneNumber)) return false;

    PhoneNumber phoneNumber = (PhoneNumber) obj;
    return Objects.equals(number, phoneNumber.number);
  }

  /**
   * Must be overridden to ensure object comparisons on the number field are done correctly.
   * @return the hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
