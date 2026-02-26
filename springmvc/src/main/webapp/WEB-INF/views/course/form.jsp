<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header">
  <h3>${editMode ? 'Edit Course' : 'Add New Course'}</h3>
</div>
<div class="card p-4" style="max-width:620px">
  <form action="${pageContext.request.contextPath}/courses/${editMode ? 'update' : 'save'}" method="post">
    <c:if test="${editMode}">
      <input type="hidden" name="id" value="${course.id}">
    </c:if>
    <div class="row">
      <div class="col-md-4 mb-3">
        <label class="form-label fw-semibold">Course Code *</label>
        <input type="text" name="courseCode" class="form-control" value="${course.courseCode}" required placeholder="e.g. CS101">
      </div>
      <div class="col-md-8 mb-3">
        <label class="form-label fw-semibold">Course Name *</label>
        <input type="text" name="courseName" class="form-control" value="${course.courseName}" required>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4 mb-3">
        <label class="form-label fw-semibold">Credits *</label>
        <input type="number" name="credits" class="form-control" value="${course.credits > 0 ? course.credits : 3}" min="1" max="6" required>
      </div>
      <div class="col-md-4 mb-3">
        <label class="form-label fw-semibold">Status</label>
        <select name="status" class="form-select">
          <option value="ACTIVE"   ${course.status == 'ACTIVE'   ? 'selected' : ''}>Active</option>
          <option value="INACTIVE" ${course.status == 'INACTIVE' ? 'selected' : ''}>Inactive</option>
        </select>
      </div>
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Department *</label>
      <select name="departmentId" class="form-select" required>
        <option value="">-- Select Department --</option>
        <c:forEach var="d" items="${departments}">
          <option value="${d.id}" ${course.departmentId == d.id ? 'selected' : ''}>${d.name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Assigned Lecturer</label>
      <select name="lecturerId" class="form-select">
        <option value="0">-- None assigned --</option>
        <c:forEach var="l" items="${lecturers}">
          <option value="${l.id}" ${course.lecturerId == l.id ? 'selected' : ''}>${l.firstName} ${l.lastName}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-4">
      <label class="form-label fw-semibold">Description</label>
      <textarea name="description" class="form-control" rows="3">${course.description}</textarea>
    </div>
    <div class="d-flex gap-2">
      <button type="submit" class="btn btn-primary">${editMode ? 'Update' : 'Save'}</button>
      <a href="${pageContext.request.contextPath}/courses/list" class="btn btn-secondary">Cancel</a>
    </div>
  </form>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
