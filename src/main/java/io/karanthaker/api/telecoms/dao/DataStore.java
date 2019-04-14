package io.karanthaker.api.telecoms.dao;

import io.karanthaker.api.telecoms.model.PhoneNumber;
import java.util.ArrayList;
import java.util.List;

/** Singleton class to store the telecoms data. */
public class DataStore {

  /** List to store all phone numbers. */
  private List<PhoneNumber> numbers = new ArrayList<>();

  /** The DataStore instance. */
  private static DataStore instance = new DataStore();

  /**
   * Get the instance of the DataStore object.
   * @return a DataStore instance.
   */
  public static DataStore getInstance() {
    return instance;
  }

  /** Initialise DataStore with 10 PhoneNumbers. */
  private DataStore() {
    for (int i = 0; i < 10; i++) {
      numbers.add(new PhoneNumber(Integer.toString(i)));
    }
  }

  /**
   * Get the list of phone numbers.
   * @return a List of PhoneNumber objects.
   */
  public List<PhoneNumber> getAllNumbers() {
    return numbers;
  }
}
