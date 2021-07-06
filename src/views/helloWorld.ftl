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
        <tr class="tableHeader">
            <td>ID</td>
            <td>Job Name</td>
            <td>Job Spec</td>
        </tr>
        <#foreach job in jobs>
        <tr class="tableBody">
            <td>${job.getJobID()}</td>
            <td>${job.getJobName()}</td>
            <td>${job.getJobSpec()}</td>
        </tr>
        </#foreach>
    </table>
</div>
</body>
</html>