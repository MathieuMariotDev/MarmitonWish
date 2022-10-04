package com.example.marmitonwish.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter("/auth/*")
public class AuthenticateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        Object user = httpReq.getSession().getAttribute("username");

        if (user != null) {
            filterChain.doFilter(httpReq, httpResp);
        } else {
            httpResp.sendRedirect(httpReq.getContextPath() + "/login");
        }

    }
}
