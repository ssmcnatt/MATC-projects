<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text">
    <h1>HTTP Request Data</h1>

    <ul>
      <li><b>Remote Computer Name: </b>${requestData.requestRemoteComputer}</li>
      <li><b>Remote Computer Address: </b>${requestData.requestRemoteAddress}</li>
      <li><b>Request HTTP Method: </b>${requestData.requestHttpMethod}</li>
      <li><b>Request URI: </b>${requestData.requestUri}</li>
      <li><b>Request URL: </b>${requestData.requestUrl}</li>
      <li><b>Request Protocol: </b>${requestData.requestProtocol}</li>
      <li><b>Server Name: </b>${requestData.serverName}</li>
      <li><b>Server Port Number: </b>${requestData.serverPortNumber}</li>
      <li><b>Server Current Locale: </b>${requestData.serverCurrentLocale}</li>
      <li><b>Query String: </b>${requestData.queryString}</li>
      <li><b>queryParameter value: </b>${requestData.queryParameterValue}</li>
      <li><b>User-Agent value: </b>${requestData.userAgentValue}</li>
    </ul>
    <p><a href="/java112">Home page</p>

  </div>
</div>