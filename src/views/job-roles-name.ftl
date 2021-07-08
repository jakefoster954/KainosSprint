<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-light bg-primary">
  <p class="navbar-brand">Kainos Sprint</h1>
</nav>

<div class="container">
<div class="row mt-3 style="display:flex; align-items:center;">
    <div class="card"  style="width: 60rem;">
        <div class="card-header text-center">
            <h2>Job Role - ${job.getJobName()}</h2>
        </div>
        <div class="card-body">
        <div class="jumbotron">
          <div class="container">
            <h3 class="display-9">Job Specification Summary</h3>
            <p class="card-text">${job.getJobSpec()}</p>
          </div>
        </div>

        </div>
        <div class="card-body">
            Find out more <a href="${job.getJobUrl()}" target="_blank" rel="noopener noreferrer">here</a>
        </div>
    </div>
</div>
</div>
</body>
</html>