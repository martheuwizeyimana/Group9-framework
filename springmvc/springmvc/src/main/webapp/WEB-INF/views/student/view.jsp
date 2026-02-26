<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <h3>&#127891; Student Profile</h3>
  <div class="d-flex gap-2">
    <a href="${pageContext.request.contextPath}/students/edit/${student.id}" class="btn btn-warning">Edit</a>
    <a href="${pageContext.request.contextPath}/students/list" class="btn btn-secondary">Back</a>
  </div>
</div>
<div class="card p-4" style="max-width:600px">
  <table class="table table-borderless">
    <tr><td class="fw-bold text-muted" width="180">Registration No.</td><td>${student.regNumber}</td></tr>
    <tr><td class="fw-bold text-muted">Full Name</td>        <td>${student.firstName} ${student.lastName}</td></tr>
    <tr><td class="fw-bold text-muted">Email</td>            <td>${student.email}</td></tr>
    <tr><td class="fw-bold text-muted">Phone</td>            <td>${student.phone}</td></tr>
    <tr><td class="fw-bold text-muted">Department</td>       <td>${student.departmentName}</td></tr>
    <tr><td class="fw-bold text-muted">Academic Year</td>    <td>Year ${student.academicYear}</td></tr>
    <tr><td class="fw-bold text-muted">Status</td>
        <td><span class="badge ${student.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${student.status}</span></td></tr>
    <tr><td class="fw-bold text-muted">Registered</td>       <td><small>${student.createdAt}</small></td></tr>
  </table>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
