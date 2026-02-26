<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <h3 class="mb-0">&#128218; Courses</h3>
  <a href="${pageContext.request.contextPath}/courses/new" class="btn btn-primary">+ Add Course</a>
</div>
<div class="card">
  <div class="table-responsive">
    <table class="table table-hover mb-0">
      <thead>
        <tr><th>#</th><th>Code</th><th>Course Name</th><th>Credits</th><th>Department</th><th>Lecturer</th><th>Status</th><th>Actions</th></tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty courses}">
            <tr><td colspan="8" class="text-center text-muted py-4">No courses found.</td></tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="c" items="${courses}" varStatus="st">
              <tr>
                <td>${st.count}</td>
                <td><span class="badge bg-secondary">${c.courseCode}</span></td>
                <td>${c.courseName}</td>
                <td><span class="badge bg-info text-dark">${c.credits} cr</span></td>
                <td>${c.departmentName}</td>
                <td>${c.lecturerName}</td>
                <td><span class="badge ${c.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${c.status}</span></td>
                <td>
                  <a href="${pageContext.request.contextPath}/courses/view/${c.id}"   class="btn btn-sm btn-outline-info btn-action">View</a>
                  <a href="${pageContext.request.contextPath}/courses/edit/${c.id}"   class="btn btn-sm btn-outline-warning btn-action">Edit</a>
                  <a href="${pageContext.request.contextPath}/courses/delete/${c.id}" class="btn btn-sm btn-outline-danger btn-action"
                     onclick="return confirm('Delete this course?')">Delete</a>
                </td>
              </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
