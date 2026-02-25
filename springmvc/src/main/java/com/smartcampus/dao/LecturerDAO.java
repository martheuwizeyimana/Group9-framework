package com.smartcampus.dao;

import com.smartcampus.model.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LecturerDAO.java - Data Access Object
 */
@Repository
public class LecturerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final RowMapper<Lecturer> mapper = (rs, rowNum) -> {
        Lecturer l = new Lecturer();
        l.setId(rs.getInt("id"));
        l.setStaffNumber(rs.getString("staff_number"));
        l.setFirstName(rs.getString("first_name"));
        l.setLastName(rs.getString("last_name"));
        l.setEmail(rs.getString("email"));
        l.setPhone(rs.getString("phone"));
        l.setDepartmentId(rs.getInt("department_id"));
        l.setDepartmentName(rs.getString("department_name"));
        l.setSpecialization(rs.getString("specialization"));
        l.setStatus(rs.getString("status"));
        l.setCreatedAt(rs.getString("created_at"));
        return l;
    };

    private static final String BASE_SELECT =
        "SELECT l.*, d.name AS department_name " +
        "FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id ";

    // ── CREATE ────────────────────────────────────────────────────────────────
    public int save(Lecturer l) {
        String sql = "INSERT INTO lecturers " +
            "(staff_number, first_name, last_name, email, phone, department_id, specialization, status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql,
            l.getStaffNumber(), l.getFirstName(), l.getLastName(),
            l.getEmail(), l.getPhone(), l.getDepartmentId(),
            l.getSpecialization(),
            l.getStatus() != null ? l.getStatus() : "ACTIVE");
    }

    // ── READ ALL ──────────────────────────────────────────────────────────────
    public List<Lecturer> findAll() {
        return jdbc.query(BASE_SELECT + "ORDER BY l.last_name, l.first_name", mapper);
    }

    // ── READ ONE ──────────────────────────────────────────────────────────────
    public Lecturer findById(int id) {
        List<Lecturer> list = jdbc.query(BASE_SELECT + "WHERE l.id = ?", mapper, id);
        return list.isEmpty() ? null : list.get(0);
    }

    // ── READ by department (used by CourseDAO) ────────────────────────────────
    public List<Lecturer> findByDepartment(int departmentId) {
        return jdbc.query(BASE_SELECT + "WHERE l.department_id = ? ORDER BY l.last_name", mapper, departmentId);
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public int update(Lecturer l) {
        String sql = "UPDATE lecturers SET " +
            "staff_number=?, first_name=?, last_name=?, email=?, phone=?, " +
            "department_id=?, specialization=?, status=? WHERE id=?";
        return jdbc.update(sql,
            l.getStaffNumber(), l.getFirstName(), l.getLastName(),
            l.getEmail(), l.getPhone(), l.getDepartmentId(),
            l.getSpecialization(), l.getStatus(), l.getId());
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public int delete(int id) {
        return jdbc.update("DELETE FROM lecturers WHERE id=?", id);
    }

    // ── COUNT ─────────────────────────────────────────────────────────────────
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM lecturers", Integer.class);
    }
}
