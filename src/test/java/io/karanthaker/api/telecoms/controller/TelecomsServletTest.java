package io.karanthaker.api.telecoms.controller;

import io.karanthaker.api.telecoms.dao.DataStore;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Telecoms API Tests")
public class TelecomsServletTest {

  private TelecomsServlet servlet;
  private HttpServletRequest request;
  private HttpServletResponse response;
  private StringWriter stringWriter;

  @BeforeEach
  public void setUp() throws Exception {
    Field instance = DataStore.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);

    servlet = new TelecomsServlet();
    request = Mockito.mock(HttpServletRequest.class);
    response = Mockito.mock(HttpServletResponse.class);

    stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(response.getWriter()).thenReturn(writer);
  }

  @Test
  @DisplayName("Endpoint - Get All Phone Numbers")
  public void testRetrievalOfAllPhoneNumbers() throws Exception {
    Mockito.when(request.getPathInfo()).thenReturn("/numbers");
    servlet.doGet(request, response);

    final String expectedJson = "[{ \"number\": \"1\", \"activated\": false }, { \"number\": \"2\", \"activated\": false }, { \"number\": \"3\", \"activated\": false }, { \"number\": \"4\", \"activated\": false }, { \"number\": \"5\", \"activated\": false }, { \"number\": \"6\", \"activated\": false }, { \"number\": \"7\", \"activated\": false }, { \"number\": \"8\", \"activated\": false }, { \"number\": \"9\", \"activated\": false }, { \"number\": \"10\", \"activated\": false }]";
    Assertions.assertEquals(expectedJson, stringWriter.toString());
  }

  @Test
  @DisplayName("Endpoint - Get Customer's Phone Numbers")
  public void testRetrievalOfACustomersNumbers() throws Exception {
    Mockito.when(request.getPathInfo()).thenReturn("/numbers/");
    Mockito.when(request.getParameter("customer")).thenReturn("1");

    final HashMap<String, String> params = new HashMap<>();
    params.put("customer", "1");
    Mockito.when(request.getParameterMap()).thenReturn(params);

    servlet.doGet(request, response);
    Mockito.verify(request, Mockito.atLeast(1)).getParameter("customer");

    final String expectedJson = "[{ \"number\": \"1\", \"activated\": false }, { \"number\": \"2\", \"activated\": false }, { \"number\": \"3\", \"activated\": false }]";
    Assertions.assertEquals(expectedJson, stringWriter.toString());
  }

  @Test
  @DisplayName("Endpoint - Activate A Phone Number")
  public void testActivationOfAPhoneNumber() throws Exception {
    Mockito.when(request.getPathInfo()).thenReturn("/numbers/");
    Mockito.when(request.getParameter("activate")).thenReturn("1");

    final HashMap<String, String> params = new HashMap<>();
    params.put("activate", "1");
    Mockito.when(request.getParameterMap()).thenReturn(params);

    servlet.doGet(request, response);
    Mockito.verify(request, Mockito.atLeast(1)).getParameter("activate");

    final String expectedJson = "{ \"message\": \"Phone number was activated successfully.\" }";
    Assertions.assertEquals(expectedJson, stringWriter.toString());
  }

  @Test
  @DisplayName("Endpoint - Unknown Endpoint")
  public void testUnknownEndpoint() throws Exception {
    Mockito.when(request.getPathInfo()).thenReturn("/");
    servlet.doGet(request, response);

    final String expectedJson = "{ \"message\": \"Invalid request.\" }";
    Assertions.assertEquals(expectedJson, stringWriter.toString());
  }

}
