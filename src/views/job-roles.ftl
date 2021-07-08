<#include "/templates/baseLayout.ftl">

<#macro pageContent>
    <div class="d-flex justify-content-center">
    <table class="table table-striped table-bordered text-center w-50" id="jobTable">
        <thead>
        <tr>
            <th>Job Name</th>
        </tr>
        </thead>
        <tbody>
        <#foreach job in dto>
        <tr class="tableBody">
            <td><a href="/api/job-roles/${job.getJobNameAsURL()}">${job.getJobName()}</a></td>
        </tr>
        </#foreach>
        </tbody>
    </table>
    </div>
</#macro>
