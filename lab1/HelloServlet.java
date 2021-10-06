package com.example.demo2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.TreeMap;

@WebServlet(name = "lab1", value = "/lab1")
public class HelloServlet extends HttpServlet {
    private String key;
    private int value;
    private boolean mock;
    private boolean sync;

    public void init() {
        String message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getMethod() + " " + request.getLocalAddr() + " " + request.getRemoteAddr() + " " + request.getLocale() + " " + request.getParameterNames());
        response.setContentType("text/html");
        key = request.getParameter("key");
        value = Integer.parseInt(request.getParameter("value"));
        mock = Objects.equals(request.getParameter("mock"), "on");
        sync = Objects.equals(request.getParameter("sync"), "on");
        if (mock) {
            try (PrintWriter out = response.getWriter()) {
                out.println("Message received.");
            }
        } else {
            processFalseMock(response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    private void processFalseMock(HttpServletResponse response) throws IOException {
        Date date = new Date();
        if (sync) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JetBrains\\FII\\Master\\Java\\demo2\\src\\main\\resources\\repository.txt", true));
            writer.append(key.repeat(value)).append(" ").append(String.valueOf(new Timestamp(date.getTime()).getTime())).append("\n");
            writer.flush();
            writer.close();
            BufferedReader reader = new BufferedReader(new FileReader("D:\\JetBrains\\FII\\Master\\Java\\demo2\\src\\main\\resources\\repository.txt"));
            String line = reader.readLine();
            TreeMap<String, String> repoItems = new TreeMap<>();
            while (line != null) {
                String[] items = line.split(" ");
                repoItems.put(items[0], items[1]);
                line = reader.readLine();
            }
            reader.close();
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body><ul>");
                repoItems.forEach((key1, value1) -> out.println("<li>" + key1 + " " + value1 + "</li>"));
                out.println("</ul></body></html>");
            }
        } else {
            try (AsynchronousFileChannel asyncFile = AsynchronousFileChannel.open(Paths.get("D:\\JetBrains\\FII\\Master\\Java\\demo2\\src\\main\\resources\\repository.txt"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE)) {
                asyncFile.write(ByteBuffer.wrap((key.repeat(value) + " " + new Timestamp(date.getTime()).getTime() + "\n").getBytes()), 0);
            }
        }
    }

    public void destroy() {
    }
}