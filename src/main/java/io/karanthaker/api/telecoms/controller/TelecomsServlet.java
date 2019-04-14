package io.karanthaker.api.telecoms.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelecomsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    final String action = req.getPathInfo();

    switch (action) {
      case "/numbers":
        resp.getWriter().write("Get All Phone Numbers");
        break;
      default:
        break;
    }
  }
}
