//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.smartcampus.dao;

import com.smartcampus.model.Lecturer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
    private static final String BASE_SELECT = "SELECT l.*, d.name AS department_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id ";

    public int save(Lecturer l) {
        String sql = "INSERT INTO lecturers (staff_number, first_name, last_name, email, phone, department_id, specialization, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return this.jdbc.update(sql, new Object[]{l.getStaffNumber(), l.getFirstName(), l.getLastName(), l.getEmail(), l.getPhone(), l.getDepartmentId(), l.getSpecialization(), l.getStatus() != null ? l.getStatus() : "ACTIVE"});
    }

    public List<Lecturer> findAll() {
        return this.jdbc.query("SELECT l.*, d.name AS department_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id ORDER BY l.last_name, l.first_name", this.mapper);
    }

    public Lecturer findById(int id) {
        List<Lecturer> list = this.jdbc.query("SELECT l.*, d.name AS department_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id WHERE l.id = ?", this.mapper, new Object[]{id});
        return list.isEmpty() ? null : (Lecturer)list.get(0);
    }

    public List<Lecturer> findByDepartment(int departmentId) {
        return this.jdbc.query("SELECT l.*, d.name AS department_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id WHERE l.department_id = ? ORDER BY l.last_name", this.mapper, new Object[]{departmentId});
    }

    public int update(Lecturer l) {
        String sql = "UPDATE lecturers SET staff_number=?, first_name=?, last_name=?, email=?, phone=?, department_id=?, specialization=?, status=? WHERE id=?";
        return this.jdbc.update(sql, new Object[]{l.getStaffNumber(), l.getFirstName(), l.getLastName(), l.getEmail(), l.getPhone(), l.getDepartmentId(), l.getSpecialization(), l.getStatus(), l.getId()});
    }

    public int delete(int id) {
        return this.jdbc.update("DELETE FROM lecturers WHERE id=?", new Object[]{id});
    }

    public int count() {
        return (Integer)this.jdbc.queryForObject("SELECT COUNT(*) FROM lecturers", Integer.class);
    }
}
