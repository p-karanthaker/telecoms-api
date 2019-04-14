package io.karanthaker.api.telecoms.dao;

import io.karanthaker.api.telecoms.model.PhoneNumber;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DataStore Tests")
public class DataStoreTest {

  private final DataStore dataStore = DataStore.getInstance();

  @Test
  @DisplayName("Test Retrieving All Numbers")
  public void retrieveAllNumbers() {
    Assertions.assertEquals(10, dataStore.getAllNumbers().size());
  }

  @Test
  @DisplayName("Get Numbers For Specific Customer")
  public void testCustomersNumbers() {
    Set<PhoneNumber> expected = new HashSet<>();
    expected.add(new PhoneNumber("1"));
    expected.add(new PhoneNumber("2"));
    expected.add(new PhoneNumber("3"));

    Assertions.assertEquals(expected, dataStore.getCustomersNumbers(1));
  }

}
