package com.example.lab2.Controllers;

import com.example.lab2.DTO.Record;
import com.example.lab2.DTO.Storage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.IOException;

@WebServlet(name = "HelloServlet", value = "/category")
public class HelloServlet extends HttpServlet {
    private Storage storage;

    public void init() {
        storage = new Storage();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realCaptcha = (String)req.getSession().getAttribute("captcha");
        String captcha = req.getParameter("captchaValue");
        Expression expression = new ExpressionBuilder(realCaptcha).build();
        System.out.println();
        if ((int)expression.evaluate() == Integer.parseInt(captcha)) {
            resp.setContentType("text/html");
            String category = req.getParameter("category");
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            Record record = new Record(category, key, value);
            Cookie cookie = new Cookie("PreviousCategory", category);
            cookie.setMaxAge(1800);
            storage.addRecord(record);
            req.setAttribute("storage", storage);
            resp.addCookie(cookie);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/input.jsp").forward(req, resp);
        }
    }

    public void destroy() {
    }
}