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


}
