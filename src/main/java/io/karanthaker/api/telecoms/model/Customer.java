package io.karanthaker.api.telecoms.model;

import java.util.Set;

/**
 * Model for a customer and their associated phone numbers.
 */
public class Customer {

  /**
   * Customer ID number.
   */
  private final int id;

  /**
   * Phone numbers associated with the customer.
   */
  private final Set<PhoneNumber> numbers;

  /**
   * Instantiate a Customer with an ID and a set of phone numbers
   */
  public Customer(int id, Set<PhoneNumber> numbers) {
    this.id = id;
    this.numbers = numbers;
  }

  /**
   * Get a set of the phone numbers associated with the customer.
   *
   * @return a Set of PhoneNumber objects.
   */
  public Set<PhoneNumber> getNumbers() {
    return this.numbers;
  }

  /**
   * Prints the Customer object as a JSON object.
   *
   * @return JSON representation of this object.
   */
  @Override
  public String toString() {
    return String.format("{ \"id\": %d, \"numbers\": %s }", id, numbers);
  }
}
