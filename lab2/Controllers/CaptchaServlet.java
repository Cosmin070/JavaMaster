package com.example.lab2.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "CaptchaServlet", value = "/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String captcha = generateMathematicalExpression();
        request.getSession().setAttribute("captcha", captcha);
        BufferedImage image = new BufferedImage(150, 75, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        Font font = new Font("Monospaced", Font.BOLD, 30);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int x = image.getWidth() - fm.stringWidth(captcha);
        int y = fm.getHeight();
        g.drawString(captcha, x, y);
        g.dispose();
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
        os.close();
    }

    public String generateMathematicalExpression() {
        Random random = new Random();
        int first = random.nextInt(100);
        int second = random.nextInt(100);
        String[] operations = new String[]{
                "+", "-", "*"
        };
        int index = random.nextInt(operations.length);
        return first + operations[index] + second;
    }
}
