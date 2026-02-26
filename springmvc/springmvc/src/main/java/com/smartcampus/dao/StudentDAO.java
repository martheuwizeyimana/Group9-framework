package com.smartcampus.dao;

import com.smartcampus.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StudentDAO.java - Data Access Object
 * All SQL for the students table lives here.
 */
@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbc;

    // ── RowMapper ─────────────────────────────────────────────────────────────
    // JOIN with departments so we can show department name in the views
    private final RowMapper<Student> mapper = (rs, rowNum) -> {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setRegNumber(rs.getString("reg_number"));
        s.setFirstName(rs.getString("first_name"));
        s.setLastName(rs.getString("last_name"));
        s.setEmail(rs.getString("email"));
        s.setPhone(rs.getString("phone"));
        s.setDepartmentId(rs.getInt("department_id"));
        s.setDepartmentName(rs.getString("department_name"));
        s.setAcademicYear(rs.getInt("academic_year"));
        s.setStatus(rs.getString("status"));
        s.setCreatedAt(rs.getString("created_at"));
        return s;
    };

    // Base SELECT with JOIN - reused in findAll and findById
    private static final String BASE_SELECT =
        "SELECT s.*, d.name AS department_name " +
        "FROM students s LEFT JOIN departments d ON s.department_id = d.id ";

    // ── CREATE ────────────────────────────────────────────────────────────────
    public int save(Student s) {
        String sql = "INSERT INTO students " +
            "(reg_number, first_name, last_name, email, phone, department_id, academic_year, status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql,
            s.getRegNumber(), s.getFirstName(), s.getLastName(),
            s.getEmail(), s.getPhone(), s.getDepartmentId(),
            s.getAcademicYear(),
            s.getStatus() != null ? s.getStatus() : "ACTIVE");
    }

    // ── READ ALL ──────────────────────────────────────────────────────────────
    public List<Student> findAll() {
        return jdbc.query(BASE_SELECT + "ORDER BY s.last_name, s.first_name", mapper);
    }

    // ── READ ONE ──────────────────────────────────────────────────────────────
    public Student findById(int id) {
        List<Student> list = jdbc.query(BASE_SELECT + "WHERE s.id = ?", mapper, id);
        return list.isEmpty() ? null : list.get(0);
    }

    // ── SEARCH by name or reg number ──────────────────────────────────────────
    public List<Student> search(String keyword) {
        String like = "%" + keyword + "%";
        String sql = BASE_SELECT +
            "WHERE s.first_name LIKE ? OR s.last_name LIKE ? OR s.reg_number LIKE ? " +
            "ORDER BY s.last_name";
        return jdbc.query(sql, mapper, like, like, like);
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public int update(Student s) {
        String sql = "UPDATE students SET " +
            "reg_number=?, first_name=?, last_name=?, email=?, phone=?, " +
            "department_id=?, academic_year=?, status=? WHERE id=?";
        return jdbc.update(sql,
            s.getRegNumber(), s.getFirstName(), s.getLastName(),
            s.getEmail(), s.getPhone(), s.getDepartmentId(),
            s.getAcademicYear(), s.getStatus(), s.getId());
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public int delete(int id) {
        return jdbc.update("DELETE FROM students WHERE id=?", id);
    }

    // ── COUNT ─────────────────────────────────────────────────────────────────
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM students", Integer.class);
    }
}
