<#include "/templates/baseLayout.ftl">
<#macro pageContent>
    <div class="row mt-3" style="display:flex; align-items:center;">
        <div class="card" style="width: 60rem;" id="jobCard">
            <div class="card-header text-center">
                <h2>${job.getJobName()}</h2>
                <h3>Capability - </h3>
                <h3>Band Level - </h3>
            </div>
            <div class="card-body">
                <div class="jumbotron">
                    <h3 class="display-9">Job Specification Summary</h3>
                        <div class="jumbotron">
                            <p class="card-text">${job.getJobSpec()}</p>
                        </div>
                </div>
            </div>
        <div class="card-body">
            Find out more <a href="${job.getJobUrl()}" target="_blank" rel="noopener noreferrer">here</a>
        </div>
    </div>
</div>
</#macro>

