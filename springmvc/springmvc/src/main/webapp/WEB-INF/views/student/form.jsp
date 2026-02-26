<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header">
  <h3>${editMode ? 'Edit Student' : 'Register New Student'}</h3>
</div>
<div class="card p-4" style="max-width:620px">
  <form action="${pageContext.request.contextPath}/students/${editMode ? 'update' : 'save'}" method="post">
    <c:if test="${editMode}">
      <input type="hidden" name="id" value="${student.id}">
    </c:if>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label fw-semibold">First Name *</label>
        <input type="text" name="firstName" class="form-control" value="${student.firstName}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label fw-semibold">Last Name *</label>
        <input type="text" name="lastName" class="form-control" value="${student.lastName}" required>
      </div>
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Registration Number *</label>
      <input type="text" name="regNumber" class="form-control" value="${student.regNumber}" required placeholder="e.g. SC2025/CS/001">
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Email *</label>
      <input type="email" name="email" class="form-control" value="${student.email}" required>
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Phone</label>
      <input type="text" name="phone" class="form-control" value="${student.phone}" placeholder="+250...">
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label fw-semibold">Department *</label>
        <select name="departmentId" class="form-select" required>
          <option value="">-- Select --</option>
          <c:forEach var="d" items="${departments}">
            <option value="${d.id}" ${student.departmentId == d.id ? 'selected' : ''}>${d.name}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-md-3 mb-3">
        <label class="form-label fw-semibold">Academic Year *</label>
        <select name="academicYear" class="form-select">
          <c:forEach begin="1" end="5" var="y">
            <option value="${y}" ${student.academicYear == y ? 'selected' : ''}>Year ${y}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-md-3 mb-3">
        <label class="form-label fw-semibold">Status</label>
        <select name="status" class="form-select">
          <option value="ACTIVE"    ${student.status == 'ACTIVE'    ? 'selected' : ''}>Active</option>
          <option value="INACTIVE"  ${student.status == 'INACTIVE'  ? 'selected' : ''}>Inactive</option>
          <option value="GRADUATED" ${student.status == 'GRADUATED' ? 'selected' : ''}>Graduated</option>
          <option value="SUSPENDED" ${student.status == 'SUSPENDED' ? 'selected' : ''}>Suspended</option>
        </select>
      </div>
    </div>
    <div class="d-flex gap-2 mt-2">
      <button type="submit" class="btn btn-success">${editMode ? 'Update' : 'Register'}</button>
      <a href="${pageContext.request.contextPath}/students/list" class="btn btn-secondary">Cancel</a>
    </div>
  </form>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
