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
<div class="row mt-3">
    <div class="card col-8">
        <div class="card-header text-center">
            <h2>Job Role - ${job.getJobName()}</h2>
        </div>
        <div class="card-body">
            <h3 class="card-title">Job Specification Summary</h3>
            <div class="card-body">
               <p>${job.getJobSpec()}</p>
            </div>
        </div>
        <div class="card-body">
            Find out more <a href='${job.getJobUrl()}'>here</a>
        </div>
    </div>
</div>
</div>
</body>
</html>