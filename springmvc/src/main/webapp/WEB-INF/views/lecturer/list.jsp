<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <h3 class="mb-0">&#128104;&#8205;&#127979; Lecturers</h3>
  <a href="${pageContext.request.contextPath}/lecturers/new" class="btn btn-warning">+ Add Lecturer</a>
</div>
<div class="card">
  <div class="table-responsive">
    <table class="table table-hover mb-0">
      <thead>
        <tr><th>#</th><th>Staff No.</th><th>Full Name</th><th>Email</th><th>Department</th><th>Specialization</th><th>Status</th><th>Actions</th></tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty lecturers}">
            <tr><td colspan="8" class="text-center text-muted py-4">No lecturers found.</td></tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="l" items="${lecturers}" varStatus="st">
              <tr>
                <td>${st.count}</td>
                <td><small>${l.staffNumber}</small></td>
                <td>${l.firstName} ${l.lastName}</td>
                <td><small>${l.email}</small></td>
                <td>${l.departmentName}</td>
                <td><small>${l.specialization}</small></td>
                <td><span class="badge ${l.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${l.status}</span></td>
                <td>
                  <a href="${pageContext.request.contextPath}/lecturers/view/${l.id}"   class="btn btn-sm btn-outline-info btn-action">View</a>
                  <a href="${pageContext.request.contextPath}/lecturers/edit/${l.id}"   class="btn btn-sm btn-outline-warning btn-action">Edit</a>
                  <a href="${pageContext.request.contextPath}/lecturers/delete/${l.id}" class="btn btn-sm btn-outline-danger btn-action"
                     onclick="return confirm('Delete this lecturer?')">Delete</a>
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
