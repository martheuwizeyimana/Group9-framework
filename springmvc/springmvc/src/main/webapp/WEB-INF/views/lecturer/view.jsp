<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
    <h3>Lecturer Profile</h3>
    <div class="d-flex gap-2">
        <a href="${pageContext.request.contextPath}/lecturers/edit/${lecturer.id}" class="btn btn-warning">Edit</a>
        <a href="${pageContext.request.contextPath}/lecturers/list" class="btn btn-secondary">Back</a>
    </div>
</div>
<div class="card p-4" style="max-width:600px">
    <table class="table table-borderless">
        <tr><td class="fw-bold text-muted" width="180">Staff Number</td>   <td>${lecturer.staffNumber}</td></tr>
        <tr><td class="fw-bold text-muted">Full Name</td>       <td>${lecturer.firstName} ${lecturer.lastName}</td></tr>
        <tr><td class="fw-bold text-muted">Email</td>           <td>${lecturer.email}</td></tr>
        <tr><td class="fw-bold text-muted">Phone</td>           <td>${lecturer.phone}</td></tr>
        <tr><td class="fw-bold text-muted">Department</td>      <td>${lecturer.departmentName}</td></tr>
        <tr><td class="fw-bold text-muted">Specialization</td>  <td>${lecturer.specialization}</td></tr>
        <tr><td class="fw-bold text-muted">Status</td>
            <td><span class="badge ${lecturer.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${lecturer.status}</span></td></tr>
    </table>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
