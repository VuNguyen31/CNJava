package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class InputFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String username = req.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            req.getRequestDispatcher("login.jsp?error=true").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
