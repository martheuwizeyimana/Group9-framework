
package com.smartcampus.dao;

import com.smartcampus.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DepartmentDAO.java - Data Access Object
 *
 * @Repository  tells Spring this is a DAO bean (adds it to the Spring context)
 * @Autowired   tells Spring to inject the JdbcTemplate automatically
 *
 * JdbcTemplate is Spring's way of running SQL without try/catch/connection boilerplate.
 * It handles:
 *   - Opening connections
 *   - Closing connections
 *   - Exception translation (SQLException -> DataAccessException)
 */
@Repository
public class DepartmentDAO {

    @Autowired
    private JdbcTemplate jdbc;

    // ── RowMapper ─────────────────────────────────────────────────────────────
    // RowMapper converts one ResultSet row into one Department object
    private final RowMapper<Department> mapper = (rs, rowNum) -> {
        Department d = new Department();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setCode(rs.getString("code"));
        d.setDescription(rs.getString("description"));
        d.setCreatedAt(rs.getString("created_at"));
        return d;
    };

    // ── CREATE ────────────────────────────────────────────────────────────────
    public int save(Department d) {
        String sql = "INSERT INTO departments (name, code, description) VALUES (?, ?, ?)";
        return jdbc.update(sql, d.getName(), d.getCode(), d.getDescription());
    }

    // ── READ ALL ──────────────────────────────────────────────────────────────
    public List<Department> findAll() {
        return jdbc.query("SELECT * FROM departments ORDER BY name", mapper);
    }

    // ── READ ONE ──────────────────────────────────────────────────────────────
    public Department findById(int id) {
        String sql = "SELECT * FROM departments WHERE id = ?";
        List<Department> list = jdbc.query(sql, mapper, id);
        return list.isEmpty() ? null : list.get(0);
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public int update(Department d) {
        String sql = "UPDATE departments SET name=?, code=?, description=? WHERE id=?";
        return jdbc.update(sql, d.getName(), d.getCode(), d.getDescription(), d.getId());
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public int delete(int id) {
        return jdbc.update("DELETE FROM departments WHERE id=?", id);
    }

    // ── COUNT ─────────────────────────────────────────────────────────────────
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM departments", Integer.class);
    }
}

