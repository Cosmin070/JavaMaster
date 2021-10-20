package com.example.lab2.Filters;


import com.example.lab2.Wrappers.SimpleResponseWrapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/*"})
public class ResponseDecorator implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        SimpleResponseWrapper wrapper
                = new SimpleResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);
        String content = wrapper.toString();
        String prelude = "<prelude>" +
                "<p>Java Laboratory</p>" +
                "</prelude>";
        String coda = "<footer>" +
                "<p>CODA written for second point<p>" +
                "</footer>";
        String output = prelude + content + coda;
        PrintWriter out = response.getWriter();
        out.write(output);
    }
}
