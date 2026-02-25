<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <div><h3 class="mb-0">&#127970; Departments</h3></div>
  <a href="${pageContext.request.contextPath}/departments/new" class="btn btn-primary">+ Add Department</a>
</div>
<div class="card">
  <div class="table-responsive">
    <table class="table table-hover mb-0">
      <thead>
        <tr><th>#</th><th>Code</th><th>Name</th><th>Description</th><th>Created</th><th>Actions</th></tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty departments}">
            <tr><td colspan="6" class="text-center text-muted py-4">No departments found.</td></tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="d" items="${departments}" varStatus="s">
              <tr>
                <td>${s.count}</td>
                <td><span class="badge bg-primary">${d.code}</span></td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td><small class="text-muted">${d.createdAt}</small></td>
                <td>
                  <a href="${pageContext.request.contextPath}/departments/edit/${d.id}" class="btn btn-sm btn-outline-warning btn-action">Edit</a>
                  <a href="${pageContext.request.contextPath}/departments/delete/${d.id}" class="btn btn-sm btn-outline-danger btn-action"
                     onclick="return confirm('Delete this department?')">Delete</a>
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
