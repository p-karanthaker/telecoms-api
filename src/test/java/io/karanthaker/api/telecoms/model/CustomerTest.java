package io.karanthaker.api.telecoms.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Customer Tests")
public class CustomerTest {

  private static Customer customer;
  private static Set<PhoneNumber> expected;

  @BeforeAll
  public static void setUp() {
    expected = new HashSet<>();
    expected.add(new PhoneNumber("0"));

    customer = new Customer(1, new HashSet<>(Arrays.asList(new PhoneNumber("0"))));
  }

  @Test
  @DisplayName("Test Retrieving Customer's Numbers")
  public void retrieveCustomerNumbers() {
    final Set<PhoneNumber> actual = customer.getNumbers();
    Assertions.assertEquals(expected, actual);
  }

}
