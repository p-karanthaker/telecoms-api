package io.karanthaker.api.telecoms.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Phone Number Tests")
public class PhoneNumberTest {

  private final PhoneNumber number = new PhoneNumber("07123123123");

  @Test
  @DisplayName("Test Phone Number Is Returned")
  public void testRetrievalOfPhoneNumber() {
    Assertions.assertEquals("07123123123", number.getNumber());
  }

  @Test
  @DisplayName("Phone Number Activation")
  public void testPhoneNumberActivation() {
    Assertions.assertFalse(number.activated());

    number.activate();

    Assertions.assertTrue(number.activated());
  }
}
