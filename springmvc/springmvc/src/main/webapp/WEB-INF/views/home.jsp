<%@ include file="/WEB-INF/views/layout.jsp" %>

<div class="page-header">
  <h3 class="mb-0">&#127968; Dashboard</h3>
  <p class="text-muted mb-0">SmartCampus University Management System - Spring MVC</p>
</div>

<!-- Stats Cards -->
<div class="row g-4 mb-4">
  <div class="col-md-3">
    <div class="card stat-card p-4" style="border-color:#0d1b6e">
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <div class="text-muted small">Departments</div>
          <div class="fs-2 fw-bold text-primary">${departmentCount}</div>
        </div>
        <div style="font-size:2.5rem">&#127970;</div>
      </div>
      <a href="${pageContext.request.contextPath}/departments/list" class="btn btn-sm btn-outline-primary mt-2">View All</a>
    </div>
  </div>
  <div class="col-md-3">
    <div class="card stat-card p-4" style="border-color:#2e7d32">
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <div class="text-muted small">Students</div>
          <div class="fs-2 fw-bold text-success">${studentCount}</div>
        </div>
        <div style="font-size:2.5rem">&#127891;</div>
      </div>
      <a href="${pageContext.request.contextPath}/students/list" class="btn btn-sm btn-outline-success mt-2">View All</a>
    </div>
  </div>
  <div class="col-md-3">
    <div class="card stat-card p-4" style="border-color:#e65100">
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <div class="text-muted small">Lecturers</div>
          <div class="fs-2 fw-bold text-warning">${lecturerCount}</div>
        </div>
        <div style="font-size:2.5rem">&#128104;&#8205;&#127979;</div>
      </div>
      <a href="${pageContext.request.contextPath}/lecturers/list" class="btn btn-sm btn-outline-warning mt-2">View All</a>
    </div>
  </div>
  <div class="col-md-3">
    <div class="card stat-card p-4" style="border-color:#6a1b9a">
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <div class="text-muted small">Courses</div>
          <div class="fs-2 fw-bold text-purple" style="color:#6a1b9a">${courseCount}</div>
        </div>
        <div style="font-size:2.5rem">&#128218;</div>
      </div>
      <a href="${pageContext.request.contextPath}/courses/list" class="btn btn-sm btn-outline-secondary mt-2">View All</a>
    </div>
  </div>
</div>

<!-- Quick action buttons -->
<div class="card p-4">
  <h5 class="mb-3">Quick Actions</h5>
  <div class="d-flex gap-3 flex-wrap">
    <a href="${pageContext.request.contextPath}/students/new"    class="btn btn-success">+ New Student</a>
    <a href="${pageContext.request.contextPath}/lecturers/new"   class="btn btn-warning">+ New Lecturer</a>
    <a href="${pageContext.request.contextPath}/courses/new"     class="btn btn-primary">+ New Course</a>
    <a href="${pageContext.request.contextPath}/departments/new" class="btn btn-secondary">+ New Department</a>
  </div>
</div>

<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
