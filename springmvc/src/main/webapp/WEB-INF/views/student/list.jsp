<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <div><h3 class="mb-0">&#127891; Students</h3></div>
  <a href="${pageContext.request.contextPath}/students/new" class="btn btn-success">+ Register Student</a>
</div>

<!-- Search bar -->
<form action="${pageContext.request.contextPath}/students/list" method="get" class="mb-3 d-flex gap-2">
  <input type="text" name="search" class="form-control" style="max-width:300px"
         value="${search}" placeholder="Search by name or reg number...">
  <button class="btn btn-outline-primary">Search</button>
  <a href="${pageContext.request.contextPath}/students/list" class="btn btn-outline-secondary">Clear</a>
</form>

<div class="card">
  <div class="table-responsive">
    <table class="table table-hover mb-0">
      <thead>
        <tr><th>#</th><th>Reg Number</th><th>Full Name</th><th>Email</th><th>Department</th><th>Year</th><th>Status</th><th>Actions</th></tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty students}">
            <tr><td colspan="8" class="text-center text-muted py-4">No students found.</td></tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="s" items="${students}" varStatus="st">
              <tr>
                <td>${st.count}</td>
                <td><small>${s.regNumber}</small></td>
                <td>${s.firstName} ${s.lastName}</td>
                <td><small>${s.email}</small></td>
                <td>${s.departmentName}</td>
                <td>Year ${s.academicYear}</td>
                <td>
                  <span class="badge ${s.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${s.status}</span>
                </td>
                <td>
                  <a href="${pageContext.request.contextPath}/students/view/${s.id}"   class="btn btn-sm btn-outline-info btn-action">View</a>
                  <a href="${pageContext.request.contextPath}/students/edit/${s.id}"   class="btn btn-sm btn-outline-warning btn-action">Edit</a>
                  <a href="${pageContext.request.contextPath}/students/delete/${s.id}" class="btn btn-sm btn-outline-danger btn-action"
                     onclick="return confirm('Delete this student record?')">Delete</a>
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
