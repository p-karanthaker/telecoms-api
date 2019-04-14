package io.karanthaker.api.telecoms.dao;

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

}
