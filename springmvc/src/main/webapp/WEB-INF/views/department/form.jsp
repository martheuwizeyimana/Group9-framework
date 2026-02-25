<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header">
  <h3>${editMode ? 'Edit Department' : 'Add New Department'}</h3>
</div>
<div class="card p-4" style="max-width:550px">
  <form action="${pageContext.request.contextPath}/departments/${editMode ? 'update' : 'save'}" method="post">
    <c:if test="${editMode}">
      <input type="hidden" name="id" value="${department.id}">
    </c:if>
    <div class="mb-3">
      <label class="form-label fw-semibold">Department Name *</label>
      <input type="text" name="name" class="form-control" value="${department.name}" required placeholder="e.g. Computer Science">
    </div>
    <div class="mb-3">
      <label class="form-label fw-semibold">Code *</label>
      <input type="text" name="code" class="form-control" value="${department.code}" required placeholder="e.g. CS" maxlength="20">
    </div>
    <div class="mb-4">
      <label class="form-label fw-semibold">Description</label>
      <textarea name="description" class="form-control" rows="3" placeholder="Brief description...">${department.description}</textarea>
    </div>
    <div class="d-flex gap-2">
      <button type="submit" class="btn btn-primary">${editMode ? 'Update' : 'Save'}</button>
      <a href="${pageContext.request.contextPath}/departments/list" class="btn btn-secondary">Cancel</a>
    </div>
  </form>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
