<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

  <div id="text">
    <h1>Analyzer Output</h1>
    <br>

    <form action="/java112/analyzer-show-output" method="get">
      Output File:<br>
      <select name="fileDropdown">
        <option value="summary_report.txt">Summary Report</option>
        <option value="unique_tokens.txt">Unique Tokens</option>
        <option value="token_count.txt">Token Count</option>
        <option value="token_size.txt">Token Size</option>
        <option value="big_words.txt">Big Words</option>
        <option value="keyword_locations.txt">Keyword Locations</option>
      </select>

      <br><br>
      <input type="submit" value="Show Output"><br>

    </form>

    <br>
    <pre>
<c:import url="${outputFile}" />
    </pre>

  </div>
</div>