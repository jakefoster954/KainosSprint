<#include "/templates/baseLayout.ftl">

<#macro pageContent>
    <div class="d-flex justify-content-center">
    <table class="table table-striped table-bordered text-center w-50" id="jobTable">
        <thead>
        <tr>
            <th style="width: 60%;">Job Name</th>
            <th style="width: 40%;">Capability</th>
        </tr>
        </thead>
        <tbody>
        <#foreach job in dto>
        <tr class="tableBody">
            <td><a href="/api/job-roles/${job.getJobNameAsURL()}">${job.getJobName()}</a></td>
            <td>${job.getCapability()}</td>
        </tr>
        </#foreach>
        </tbody>
    </table>
    </div>
</#macro>
