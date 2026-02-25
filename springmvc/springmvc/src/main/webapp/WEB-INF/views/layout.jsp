<%-- layout.jsp: shared header + nav. Include at top of every page with:
     <%@ include file="/WEB-INF/views/layout.jsp" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>SmartCampus - Spring MVC</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <style>
    body           { background: #f4f6fb; font-family: Arial, sans-serif; }
    .sidebar       { min-height: 100vh; background: #0d1b6e; color: white; padding-top: 20px; }
    .sidebar a     { color: #c5cae9; text-decoration: none; display: block;
                     padding: 10px 20px; border-radius: 6px; margin: 2px 8px; }
    .sidebar a:hover, .sidebar a.active { background: #283593; color: white; }
    .sidebar .brand{ font-size: 1.2rem; font-weight: bold; padding: 10px 20px 20px;
                     border-bottom: 1px solid #283593; margin-bottom: 10px; }
    .main-content  { padding: 24px; }
    .page-header   { background: white; border-radius: 10px; padding: 20px 24px;
                     margin-bottom: 20px; box-shadow: 0 2px 8px rgba(0,0,0,.06); }
    .card          { border: none; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,.07); }
    .stat-card     { border-left: 5px solid; }
    .table th      { background: #0d1b6e; color: white; }
    .btn-action    { padding: 3px 10px; font-size: 0.8rem; }
  </style>
</head>
<body>
<div class="container-fluid">
<div class="row">

  <!-- Sidebar Navigation -->
  <div class="col-md-2 sidebar p-0">
    <div class="brand">&#127979; SmartCampus</div>
    <a href="${pageContext.request.contextPath}/dashboard">&#127968; Dashboard</a>
    <div style="color:#7986cb; font-size:0.75rem; padding:8px 20px; text-transform:uppercase">Management</div>
    <a href="${pageContext.request.contextPath}/departments/list">&#127970; Departments</a>
    <a href="${pageContext.request.contextPath}/students/list">&#127891; Students</a>
    <a href="${pageContext.request.contextPath}/lecturers/list">&#128104;&#8205;&#127979; Lecturers</a>
    <a href="${pageContext.request.contextPath}/courses/list">&#128218; Courses</a>
  </div>

  <!-- Main Content Area -->
  <div class="col-md-10 main-content">
    <!-- Flash messages -->
    <c:if test="${not empty success}">
      <div class="alert alert-success alert-dismissible fade show mt-2">
        &#10003; ${success}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      </div>
    </c:if>
    <c:if test="${not empty error}">
      <div class="alert alert-danger alert-dismissible fade show mt-2">
        &#9888; ${error}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      </div>
    </c:if>
