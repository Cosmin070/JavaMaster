package com.lab3.Database;

import com.lab3.DTOs.Allocation;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllocationRepo {
    @Resource(name = "jdbc/java")
    private final DataSource dataSource;
    private Connection connection;

    public AllocationRepo() throws NamingException {
        Context initContext = new InitialContext();
        dataSource = (DataSource) initContext.lookup("jdbc/java");
    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public List<Allocation> getAllocation() throws SQLException {
        connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select stud.id, first_name, last_name, name from students stud join scheduler s on stud.id = s.student_id join exams e on e.id = s.exam_id");
        ResultSet rs = stmt.executeQuery();
        List<Allocation> allocations = new ArrayList<>();
        while (rs.next()) {
            Allocation allocation = new Allocation();
            allocation.setId(rs.getInt(1));
            allocation.setFirstName(rs.getString(2));
            allocation.setLastName(rs.getString(3));
            allocation.setExam(rs.getString(4));
            allocations.add(allocation);
        }
        return allocations;
    }


}
