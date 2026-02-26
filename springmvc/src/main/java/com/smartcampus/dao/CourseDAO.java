package com.smartcampus.dao;

import com.smartcampus.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CourseDAO.java - Data Access Object
 */
@Repository
public class CourseDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final RowMapper<Course> mapper = (rs, rowNum) -> {
        Course c = new Course();
        c.setId(rs.getInt("id"));
        c.setCourseCode(rs.getString("course_code"));
        c.setCourseName(rs.getString("course_name"));
        c.setCredits(rs.getInt("credits"));
        c.setDepartmentId(rs.getInt("department_id"));
        c.setDepartmentName(rs.getString("department_name"));
        c.setLecturerId(rs.getInt("lecturer_id"));
        c.setLecturerName(rs.getString("lecturer_name"));
        c.setDescription(rs.getString("description"));
        c.setStatus(rs.getString("status"));
        c.setCreatedAt(rs.getString("created_at"));
        return c;
    };

    // JOIN with departments AND lecturers for display names
    private static final String BASE_SELECT =
        "SELECT c.*, d.name AS department_name, " +
        "CONCAT(l.first_name, ' ', l.last_name) AS lecturer_name " +
        "FROM courses c " +
        "LEFT JOIN departments d ON c.department_id = d.id " +
        "LEFT JOIN lecturers l ON c.lecturer_id = l.id ";

    // ── CREATE ────────────────────────────────────────────────────────────────
    public int save(Course c) {
        String sql = "INSERT INTO courses " +
            "(course_code, course_name, credits, department_id, lecturer_id, description, status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql,
            c.getCourseCode(), c.getCourseName(), c.getCredits(),
            c.getDepartmentId(),
            c.getLecturerId() > 0 ? c.getLecturerId() : null,
            c.getDescription(),
            c.getStatus() != null ? c.getStatus() : "ACTIVE");
    }

    // ── READ ALL ──────────────────────────────────────────────────────────────
    public List<Course> findAll() {
        return jdbc.query(BASE_SELECT + "ORDER BY c.course_code", mapper);
    }

    // ── READ ONE ──────────────────────────────────────────────────────────────
    public Course findById(int id) {
        List<Course> list = jdbc.query(BASE_SELECT + "WHERE c.id = ?", mapper, id);
        return list.isEmpty() ? null : list.get(0);
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public int update(Course c) {
        String sql = "UPDATE courses SET " +
            "course_code=?, course_name=?, credits=?, department_id=?, " +
            "lecturer_id=?, description=?, status=? WHERE id=?";
        return jdbc.update(sql,
            c.getCourseCode(), c.getCourseName(), c.getCredits(),
            c.getDepartmentId(),
            c.getLecturerId() > 0 ? c.getLecturerId() : null,
            c.getDescription(), c.getStatus(), c.getId());
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public int delete(int id) {
        return jdbc.update("DELETE FROM courses WHERE id=?", id);
    }

    // ── COUNT ─────────────────────────────────────────────────────────────────
    public int count() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM courses", Integer.class);
    }
}
