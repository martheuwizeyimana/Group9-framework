package com.smartcampus.service;

import com.smartcampus.dao.DepartmentDAO;
import com.smartcampus.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DepartmentService.java - Service Layer
 *
 * @Service tells Spring this is a Service bean.
 * Business logic and validation live here.
 * Controllers call this. This calls the DAO.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDAO dao;

    public int save(Department d) {
        if (d.getName() == null || d.getName().isBlank()) throw new IllegalArgumentException("Department name is required.");
        if (d.getCode() == null || d.getCode().isBlank()) throw new IllegalArgumentException("Department code is required.");
        return dao.save(d);
    }

    public List<Department> getAll()       { return dao.findAll(); }
    public Department       getById(int id){ return dao.findById(id); }
    public int              count()        { return dao.count(); }

    public int update(Department d) {
        if (d.getName() == null || d.getName().isBlank()) throw new IllegalArgumentException("Name is required.");
        return dao.update(d);
    }

    public int delete(int id) { return dao.delete(id); }
}
