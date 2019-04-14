package io.karanthaker.api.telecoms.controller;

import io.karanthaker.api.telecoms.dao.DataStore;
import io.karanthaker.api.telecoms.model.PhoneNumber;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
      default:
        break;
    }
    
    out.flush();
  }
}
