<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text">
    <h1>Employee Search</h1>
    <br>

    <form action="/java112/employee-search-results" method="get">
      <input type="text" name="searchTerm" size="30" maxlength="30"><br>
      <input type="radio" name="searchType" value="lastName" checked />Last Name<br>
      <input type="radio" name="searchType" value="firstName" />First Name<br>
      <input type="radio" name="searchType" value="employeeId" />Employee ID<br><br>

      <input type="submit" value="Search Employees">
    </form>

  </div>
</div>