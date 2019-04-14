package io.karanthaker.api.telecoms.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Telecoms API Tests")
public class TelecomsServletTest {

  private static TelecomsServlet servlet;
  private static HttpServletRequest request;
  private static HttpServletResponse response;
  private static StringWriter stringWriter;

  @BeforeAll
  public static void setUp() throws Exception {
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

    final String expectedJson = "[{ \"number\": 1, \"activated\": false }, { \"number\": 2, \"activated\": false }, { \"number\": 3, \"activated\": false }, { \"number\": 4, \"activated\": false }, { \"number\": 5, \"activated\": false }, { \"number\": 6, \"activated\": false }, { \"number\": 7, \"activated\": false }, { \"number\": 8, \"activated\": false }, { \"number\": 9, \"activated\": false }, { \"number\": 10, \"activated\": false }]";
    Assertions.assertEquals(expectedJson, stringWriter.toString());
  }

}
