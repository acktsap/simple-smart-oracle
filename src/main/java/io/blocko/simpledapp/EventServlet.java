package io.blocko.simpledapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/event")
public class EventServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    final String requestBody = readRequestBody(req);
    System.out.println(requestBody);
  }

  protected String readRequestBody(HttpServletRequest request) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
    StringBuffer builder = new StringBuffer();
    String buffer;
    while ((buffer = input.readLine()) != null) {
      if (builder.length() > 0) {
        builder.append("\n");
      }
      builder.append(buffer);
    }
    return builder.toString();
  }

}
