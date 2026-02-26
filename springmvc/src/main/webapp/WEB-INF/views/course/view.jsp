<%@ include file="/WEB-INF/views/layout.jsp" %>
<div class="page-header d-flex justify-content-between align-items-center">
  <h3>&#128218; Course Detail</h3>
  <div class="d-flex gap-2">
    <a href="${pageContext.request.contextPath}/courses/edit/${course.id}" class="btn btn-primary">Edit</a>
    <a href="${pageContext.request.contextPath}/courses/list" class="btn btn-secondary">Back</a>
  </div>
</div>
<div class="card p-4" style="max-width:600px">
  <table class="table table-borderless">
    <tr><td class="fw-bold text-muted" width="180">Course Code</td>  <td><span class="badge bg-secondary fs-6">${course.courseCode}</span></td></tr>
    <tr><td class="fw-bold text-muted">Course Name</td>  <td>${course.courseName}</td></tr>
    <tr><td class="fw-bold text-muted">Credits</td>      <td>${course.credits}</td></tr>
    <tr><td class="fw-bold text-muted">Department</td>   <td>${course.departmentName}</td></tr>
    <tr><td class="fw-bold text-muted">Lecturer</td>     <td>${empty course.lecturerName ? 'Not assigned' : course.lecturerName}</td></tr>
    <tr><td class="fw-bold text-muted">Description</td>  <td>${course.description}</td></tr>
    <tr><td class="fw-bold text-muted">Status</td>
        <td><span class="badge ${course.status == 'ACTIVE' ? 'bg-success' : 'bg-secondary'}">${course.status}</span></td></tr>
  </table>
</div>
<%@ include file="/WEB-INF/views/layout-footer.jsp" %>
