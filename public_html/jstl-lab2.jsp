<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>JSTL Lab 2</title>
  </head>
  <body>
    <table border="1">
    <c:forEach var="item" items="${arrayList}">
      <tr>
        <td>${item}</td>
      </tr>
    </c:forEach>
    </table>
    <p><a href="/java112">Home page</p>
  </body>
</html>