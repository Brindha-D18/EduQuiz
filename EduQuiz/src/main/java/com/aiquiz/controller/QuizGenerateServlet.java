package com.aiquiz.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class QuizGenerateServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
resp.getWriter().print("AI Questions Generated (Demo)");
}
}