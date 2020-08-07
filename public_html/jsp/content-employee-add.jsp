<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text">
    <h1>Employee Add</h1>
    <br>
    <h3>${project4AddMessage}</h3>
    <c:remove var="project4AddMessage" />
    <br>
    <form action="/java112/employee-add-action" method="post">
      First Name:<br>
        <input type="text" name="firstName" size="25" maxlength="25"><br>
      Last Name:<br>
        <input type="text" name="lastName" size="30" maxlength="30"><br>
      Social Security Number:<br>
        <input type="text" name="socialSecurityNumber" size="20" maxlength="20"><br>
      Department:<br>
        <input type="text" name="department" size="10" maxlength="10"><br>
      Room Number:<br>
        <input type="text" name="roomNumber" size="10" maxlength="10"><br>
      Phone Number:<br>
        <input type="text" name="phoneNumber" size="10" maxlength="10"><br><br>

      <input type="submit" value="Add Employee">
    </form>

  </div>
</div>