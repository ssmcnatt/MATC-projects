<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text" align="center">
    <h1>Employee Search Results</h1>
    <br>

    <c:choose>
      <c:when test="${search.foundEmployees}">
        <table border="1">
          <tr>
            <td>Employee ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Social Security Number</td>
            <td>Department</td>
            <td>Room Number</td>
            <td>Phone Number</td>
          </tr>
          <c:forEach var="employee" items="${search.queryResults}">
            <tr>
              <td>${employee.employeeId}</td>
              <td>${employee.employeeFirstName}</td>
              <td>${employee.employeeLastName}</td>
              <td>${employee.employeeSsn}</td>
              <td>${employee.employeeDepartment}</td>
              <td>${employee.employeeRoomNumber}</td>
              <td>${employee.employeePhoneNumber}</td>
            </tr>
          </c:forEach>
        </table>
      </c:when>

      <c:otherwise>
        <h3>No Employees Found</h3>
      </c:otherwise>
    </c:choose>

  </div>
</div>