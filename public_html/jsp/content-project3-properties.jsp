<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text">
    <h1>Project 3 Properties</h1>

    <table border="1">
    <col width="150">
      <tr>
        <td>Author Name</td>
        <td>${authorName}</td>
      </tr>
      <tr>
        <td>Author Email Address</td>
        <td>${authorEmail}</td>
      </tr>
      <tr>
        <td>Course Title</td>
        <td>${courseTitle}</td>
      </tr>
      <tr>
        <td>Course Days/Times</td>
        <td>${courseDaysTimes}</td>
      </tr>
      <tr>
        <td>Instructor Name</td>
        <td>${instructorName}</td>
      </tr>
      <tr>
        <td>Project Description</td>
        <td>${projectDescription}</td>
      </tr>
    </table>
    <p><a href="/java112">Home page</p>

  </div>
</div>