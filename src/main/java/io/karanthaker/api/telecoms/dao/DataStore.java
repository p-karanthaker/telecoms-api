package io.karanthaker.api.telecoms.dao;

import io.karanthaker.api.telecoms.model.Customer;
import io.karanthaker.api.telecoms.model.PhoneNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Singleton class to store the telecoms data. */
public class DataStore {

  /** Maps Customer Ids to Customers. */
  private HashMap<Integer, Customer> customers = new HashMap<>();

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

  /** Initialise DataStore with 10 PhoneNumbers and 3 customers. */
  private DataStore() {
    for (int i = 1; i < 11; i++) {
      numbers.add(new PhoneNumber(Integer.toString(i)));
    }

    customers.put(1, new Customer(1, new HashSet<>(numbers.subList(0, 3))));
    customers.put(2, new Customer(2, new HashSet<>(numbers.subList(3, 7))));
    customers.put(3, new Customer(3, new HashSet<>(numbers.subList(7, 10))));
  }

  /**
   * Get the list of phone numbers.
   * @return a List of PhoneNumber objects.
   */
  public List<PhoneNumber> getAllNumbers() {
    return numbers;
  }

  public Set<PhoneNumber> getCustomersNumbers(int customerId) {
    if (customers.containsKey(customerId)) {
      final Customer customer = customers.get(customerId);
      return customer.getNumbers();
    } else {
      return new HashSet<>();
    }
  }
}
