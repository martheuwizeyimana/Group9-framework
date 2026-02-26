<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header">
    <h3>${editMode ? 'Edit Lecturer' : 'Add New Lecturer'}</h3>
</div>
<div class="card p-4" style="max-width:620px">
    <form action="${pageContext.request.contextPath}/lecturers/${editMode ? 'update' : 'save'}" method="post">
        <c:if test="${editMode}">
            <input type="hidden" name="id" value="${lecturer.id}">
        </c:if>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label fw-semibold">First Name *</label>
                <input type="text" name="firstName" class="form-control" value="${lecturer.firstName}" required>
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label fw-semibold">Last Name *</label>
                <input type="text" name="lastName" class="form-control" value="${lecturer.lastName}" required>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label fw-semibold">Staff Number *</label>
            <input type="text" name="staffNumber" class="form-control" value="${lecturer.staffNumber}" required placeholder="e.g. STAFF001">
        </div>
        <div class="mb-3">
            <label class="form-label fw-semibold">Email *</label>
            <input type="email" name="email" class="form-control" value="${lecturer.email}" required>
        </div>
        <div class="mb-3">
            <label class="form-label fw-semibold">Phone</label>
            <input type="text" name="phone" class="form-control" value="${lecturer.phone}">
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label class="form-label fw-semibold">Department *</label>
                <select name="departmentId" class="form-select" required>
                    <option value="">-- Select --</option>
                    <c:forEach var="d" items="${departments}">
                        <option value="${d.id}" ${lecturer.departmentId == d.id ? 'selected' : ''}>${d.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4 mb-3">
                <label class="form-label fw-semibold">Status</label>
                <select name="status" class="form-select">
                    <option value="ACTIVE"   ${lecturer.status == 'ACTIVE'   ? 'selected' : ''}>Active</option>
                    <option value="INACTIVE" ${lecturer.status == 'INACTIVE' ? 'selected' : ''}>Inactive</option>
                </select>
            </div>
        </div>
        <div class="mb-4">
            <label class="form-label fw-semibold">Specialization</label>
            <input type="text" name="specialization" class="form-control" value="${lecturer.specialization}" placeholder="e.g. Software Engineering">
        </div>
        <div class="d-flex gap-2">
            <button type="submit" class="btn btn-warning">${editMode ? 'Update' : 'Save'}</button>
            <a href="${pageContext.request.contextPath}/lecturers/list" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
