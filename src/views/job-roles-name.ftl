<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-light bg-primary">
  <p class="navbar-brand">Kainos Sprint</h1>
</nav>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Job Name</th>
            <th>Job Specification</th>
            <th>URL</th>
            <th>Capability</th>
            <th>Band Level</th>
        </tr>
        </thead>
        <tbody>
        <tr class="tableBody">
            <td>${dto.getJobID()}</td>
            <td>${dto.getJobName()}</td>
            <td>${dto.getJobSpec()}</td>
            <td>${dto.getJobUrl()}</td>
            <td>${dto.getCapability()}</td>
            <td>${dto.getBandLevel()}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>