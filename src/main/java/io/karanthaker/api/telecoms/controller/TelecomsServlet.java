package io.karanthaker.api.telecoms.controller;

import io.karanthaker.api.telecoms.dao.DataStore;
import io.karanthaker.api.telecoms.model.PhoneNumber;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelecomsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    final String action = req.getPathInfo();
    final PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    final DataStore dataStore = DataStore.getInstance();

    switch (action) {
      case "/numbers":
        final List<PhoneNumber> numbers = dataStore.getAllNumbers();
        out.print(numbers.toString());
        break;
      case "/numbers/":
        if (req.getParameterMap().containsKey("customer")) {
          final int customerId = Integer.parseInt(req.getParameter("customer"));
          final Set<PhoneNumber> customerNumbers = dataStore.getCustomersNumbers(customerId);
          out.print(customerNumbers.toString());
          break;
        } else if (req.getParameterMap().containsKey("activate")) {
          final String number = req.getParameter("activate");
          final boolean activated = dataStore.activatePhoneNumber(number);
          if (activated) {
            out.print("{ \"message\": \"Phone number was activated successfully.\" }");
          } else {
            out.print("{ \"message\": \"Phone number not found!\" }");
          }
          break;
        }
      default:
        out.print("{ \"message\": \"Invalid request.\" }");
        break;
    }
    
    out.flush();
  }
}
