package com.aiquiz.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
resp.sendRedirect("dashboard.html");
}
}