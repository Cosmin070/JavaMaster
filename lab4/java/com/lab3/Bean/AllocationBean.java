package com.lab3.Bean;


import com.lab3.DTOs.Allocation;
import com.lab3.Database.AllocationRepo;
import com.lab3.Database.StudentRepo;
import jakarta.faces.bean.ManagedBean;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "allocationBean")
public class AllocationBean {
    AllocationRepo repo;

    public AllocationBean() throws NamingException {
        this.repo = new AllocationRepo();
    }

    public List<Allocation> getAllocation() throws SQLException {
        return repo.getAllocation();
    }
}
